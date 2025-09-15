package com.spring.boot.unittesting.auth;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<User>();

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void deleteUser(User user) {
        users.remove(user);
    }
}
