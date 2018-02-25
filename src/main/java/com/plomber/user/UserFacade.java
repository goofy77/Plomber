package com.plomber.user;

import com.plomber.user.dto.UserDto;

public class UserFacade {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public UserFacade(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public UserDto add(UserDto userDto) {
        User user = User.builder()
                .email(userDto.getEmail())
                .build();
        User savedUser = userRepository.save(user);
        return savedUser.dto();
    }
}
