package com.plomber.user;

import com.plomber.user.dto.RegisterUserCommand;
import com.plomber.user.dto.UpdateUserCommand;
import com.plomber.user.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
class RegistrationController {

    private UserFacade userFacade;

    RegistrationController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping
    UserDto registerUser(@RequestBody RegisterUserCommand command) {
        return userFacade.save(UserDto.builder()
                .email(command.getEmail())
                .password(command.getPassword())
                .build());
    }

    @PutMapping
    UserDto updateUser(@RequestBody UpdateUserCommand command) {
        UserDto userToUpdate = command.prepareData(userFacade.get(1));
        return userFacade.save(userToUpdate);
    }

}
