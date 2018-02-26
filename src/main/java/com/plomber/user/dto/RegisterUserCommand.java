package com.plomber.user.dto;

public class RegisterUserCommand {

    private String password;
    private String email;

    public void setPassword(String password) {
        this.password =password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
