package com.plomber.user;

import com.plomber.user.UserFacade;
import com.plomber.user.dto.RegisterUserCommand;
import com.plomber.user.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
class RegistrationController {

    private UserFacade userFacade;

    RegistrationController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping
    public UserDto registerUser(@RequestBody RegisterUserCommand command) {
        return userFacade.add(UserDto.builder()
                .email(command.getEmail())
                .password(command.getPassword())
                .build());
    }
}
