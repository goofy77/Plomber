package com.plomber.user;

import com.plomber.user.dto.UserDto;
import com.plomber.user.exceptions.EmailExistsException;

import static java.lang.String.*;

public class UserFacade {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public UserFacade(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public UserDto save(UserDto userDto) {
        if(emailExists(userDto.getEmail())) {
            throw new EmailExistsException(format("Email %s already taken", userDto.getEmail()));
        }
        User user = userFactory.create(userDto);
        return userRepository.save(user).dto();
    }

    public UserDto get(Integer id) {
        return userRepository.findOne(id).dto();
    }

    private boolean emailExists(String email) {
       return userRepository.existsByEmail(email);
    }
}
