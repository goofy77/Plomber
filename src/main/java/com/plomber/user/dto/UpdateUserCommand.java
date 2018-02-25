package com.plomber.user.dto;

import java.util.Optional;

import static com.plomber.user.dto.UserDto.*;

public class UpdateUserCommand {

    private String email;
    private String password;

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }


    public UserDto prepareData(UserDto existingUser) {
        return builder()
                .email(getEmail().orElse(existingUser.getEmail()))
                .password(getPassword().orElse(existingUser.getPassword()))
                .id(existingUser.getId())
                .build();
    }
}
