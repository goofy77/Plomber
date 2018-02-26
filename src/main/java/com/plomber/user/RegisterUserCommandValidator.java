package com.plomber.user;


import com.plomber.user.dto.RegisterUserCommand;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

class RegisterUserCommandValidator implements Validator {

    private final UserRepository userRepository;

    RegisterUserCommandValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterUserCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterUserCommand command = (RegisterUserCommand) o;
        validatePassword(command.getPassword(), errors);
        validateEmail(command.getEmail(), errors);
    }

    private void validatePassword(String password, Errors errors) {
        if(password.length() < 6) {
            errors.reject("Password too short, 6 chars required");
        }
        if(!hasNumber(password)) {
            errors.reject("Password must contain at least one letter");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Empty password");
    }

    private boolean hasNumber(String password) {
        String regex = "(.)*(\\d)(.)*";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

    private void validateEmail(String email, Errors errors) {
        if(!EmailValidator.getInstance().isValid(email)) {
            errors.reject("Email not valid");
        }
        if(userRepository.existsByEmail(email)) {
            errors.reject("Email exists");
        }
    }
}
