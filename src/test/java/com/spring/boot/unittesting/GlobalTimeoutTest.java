package com.spring.boot.unittesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GlobalTimeoutTest {
    public static String log;
    private final CountDownLatch latch = new CountDownLatch(1);

    @Rule
    public Timeout globalTimeout = Timeout.seconds(20);

    @Test
    public void testSleepForTooLong() throws InterruptedException {
        log += " log";
        TimeUnit.SECONDS.sleep(19);
    }

    @Test
    public void testForEver() throws InterruptedException {
        log += " forever";
        latch.await();
    }
}
