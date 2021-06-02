package com.burkhart.primenumbergenerator.core;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BootstrapLoaderTest {
    
    private PrintStream systemOut;
    
    private PrintStream testOut;
    
    private ByteArrayOutputStream testOutputStream;

    @BeforeEach
    protected void setUp() throws Exception {
	systemOut = System.out;
	testOutputStream = new ByteArrayOutputStream();
	testOut = new PrintStream(testOutputStream);
	System.setOut(testOut);
    }
    
    @AfterEach
    protected void tearDown() throws Exception {
	System.setOut(systemOut);
	testOutputStream.close();
    }
    
    @Test
    void testInitBootstrapLoader() {
	BootstrapLoader loader = new BootstrapLoader();
	Assertions.assertNotNull(loader);
    }
    
    @Test
    void testNotEnoughArguments() {
	BootstrapLoader.main();
	Assertions.assertEquals("Terminated execution of prime number generator.  Expected exactly two integer arguments {startValue} {endValue}", this.testOutputStream.toString().trim());
    }
    
    @Test
    void test7900To7920() {
	BootstrapLoader.main("7900", "7920");
	Assertions.assertEquals(Arrays.asList(7901, 7907, 7919).toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void test7920To7900() {
	BootstrapLoader.main("7920", "7900");
	Assertions.assertEquals(Arrays.asList(7901, 7907, 7919).toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void testFirstArgumentDefault0() {
	BootstrapLoader.main("test", "10");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void testSecondArgumentDefault0() {
	BootstrapLoader.main("10", "test");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void testBothArgumentsDefault0() {
	BootstrapLoader.main("test", "test");
	Assertions.assertEquals(Arrays.asList().toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void testNegativeRange() {
	BootstrapLoader.main("-10", "10");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void testNegativeRangeReflective() {
	BootstrapLoader.main("10", "-10");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void testMaxIntRange() {
	BootstrapLoader.main(String.valueOf(Integer.MAX_VALUE-10), "2147483647");
	Assertions.assertEquals(Arrays.asList(Integer.MAX_VALUE).toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void testMinIntRange() {
	BootstrapLoader.main(String.valueOf(Integer.MIN_VALUE), String.valueOf(Integer.MIN_VALUE+10));
	Assertions.assertEquals(Arrays.asList().toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void testOverflowMaxInt() {
	BootstrapLoader.main(String.valueOf(10), "2147483648");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString().trim());
    }
    
    @Test
    void testOverflowMinInt() {
	BootstrapLoader.main(String.valueOf(10), "-2147483649");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString().trim());
    }

}
