package com.plomber.user;

import com.plomber.user.dto.UserDto;
import com.plomber.user.exceptions.EmailExistsException;

public class UserFacade {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public UserFacade(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public UserDto add(UserDto userDto) {
        if(emailExists(userDto.getEmail())) {
            throw new EmailExistsException(String.format("Email %s already taken", userDto.getEmail()));
        }
        User user = userFactory.create(userDto);
        User savedUser = userRepository.save(user);
        return savedUser.dto();
    }

    private boolean emailExists(String email) {
       return userRepository.existsByEmail(email);
    }
}
