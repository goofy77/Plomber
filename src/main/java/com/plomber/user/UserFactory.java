package com.plomber.user;

import com.plomber.user.dto.UserDto;

class UserFactory {

    private final UserRepository userRepository;

    UserFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User create(UserDto userDto) {
        return User
                .builder()
                .email(userDto.getEmail())
                .id(userDto.getId())
                .password(userDto.getPassword())
                .build();
    }
}
