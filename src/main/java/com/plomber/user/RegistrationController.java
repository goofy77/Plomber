package com.plomber.user;

import com.plomber.user.dto.RegisterUserCommand;
import com.plomber.user.dto.UpdateUserCommand;
import com.plomber.user.dto.UserDto;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
class RegistrationController {

    private final UserFacade userFacade;
    private final RegisterUserCommandValidator registerUserCommandValidator;

    RegistrationController(UserFacade userFacade, UserRepository userRepository) {
        this.userFacade = userFacade;
        this.registerUserCommandValidator = new RegisterUserCommandValidator(userRepository);
    }

    @PostMapping
    UserDto registerUser(@RequestBody @Valid RegisterUserCommand registerUserCommand) {
        return userFacade.save(UserDto.builder()
                .email(registerUserCommand.getEmail())
                .password(registerUserCommand.getPassword())
                .build());
    }

    @PutMapping
    UserDto updateUser(@RequestBody UpdateUserCommand updateUserCommand) {
        UserDto userToUpdate = updateUserCommand.prepareData(userFacade.get(1));
        return userFacade.save(userToUpdate);
    }


    @InitBinder("registerUserCommand")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(registerUserCommandValidator);
    }

}
