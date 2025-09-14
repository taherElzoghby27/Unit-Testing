package com.spring.boot.unittesting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testCalculate() {
        Calculator calculator = new Calculator();
        int result = calculator.evaluate("1+2+3+4");
        assertEquals("result must equal 10", 10, result);
    }
}
