package com.spring.boot.unittesting.auth;

public class LoginService {
    public boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
