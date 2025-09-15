package com.spring.boot.unittesting.auth;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserServiceTest {
    private static UserService userService;
    private User user;

    @BeforeClass
    public static void setUp() {
        userService = new UserService();
    }

    @Before
    public void setUpUser() {
        user = new User("taher", 1L);
    }

    @Test
    public void givenUser_whenAddUser_thenUserAdded() {
        List<User> users = userService.getUsers();
        assertEquals("user must be zero", 0, users.size());
        userService.createUser(user);
        users = userService.getUsers();
        assertEquals("user must be created", 1, users.size());
    }

    @Test
    public void givenUser_whenAddUser_thenUserAdded2() {
        User addedUser = userService.createUser(user);
        assertNotNull("user must be created", addedUser);
    }

    @Test
    public void givenUser_whenDeleteUser_thenUserDeleted() {
        userService.createUser(user);
        List<User> users = userService.getUsers();
        assertEquals("user must be 1", 1, users.size());
        userService.deleteUser(user);
        users = userService.getUsers();
        assertEquals("user must be deleted", 0, users.size());
    }
}
