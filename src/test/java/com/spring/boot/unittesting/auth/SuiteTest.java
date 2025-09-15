package com.spring.boot.unittesting.auth;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServiceTest.class,
        LoginServiceTest.class,
})
public class SuiteTest {
}
