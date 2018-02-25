package com.plomber.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfiguration {

    @Bean
    UserFacade userFacade(UserRepository userRepository) {
        UserFactory factory = new UserFactory();
        return new UserFacade(userRepository, factory);
    }
}
