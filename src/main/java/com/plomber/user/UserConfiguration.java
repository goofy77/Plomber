package com.plomber.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfiguration {

    @Bean
    UserFacade userFacade(UserRepository userRepository) {
        UserFactory factory = new UserFactory(userRepository);
        return new UserFacade(userRepository, factory);
    }

    @Bean
    UserFactory userFactory(UserRepository userRepository) {
        return new UserFactory(userRepository);
    }

//    @Bean
//    RegisterUserCommandValidator registerUserCommandValidator(UserRepository userRepository) {
//        return new RegisterUserCommandValidator(userRepository);
//    }
}
