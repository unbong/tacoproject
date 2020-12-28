package com.example.tacoproject.Secure;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String phonenumber;

    public UserForm userToUser(PasswordEncoder passwordEncoder)
    {
        return new UserForm(username, passwordEncoder.encode(password), phonenumber);
    }
}
