package com.spring.boot.unittesting.auth;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginServiceTest {

    @Test
    public void givenUser_whenLogin_thenSuccess() {
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate("admin", "admin");
        assertTrue("user must authenticated", result);
    }

    @Test
    public void givenFakeUser_whenLogin_thenFailure() {
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate("admin1", "admin");
        assertFalse("user shouldn't authenticate", result);
    }
}
