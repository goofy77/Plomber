package com.plomber.user;

import com.plomber.user.dto.UserDto;

class UserFactory {

    User create(UserDto userDto) {
        return User
                .builder()
                .email(userDto.getEmail())
                .build();
    }
}
