package core;

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
    
    private PrintStream systemError;
    
    private PrintStream testError;
    
    private ByteArrayOutputStream testOutputStream;
    
    private ByteArrayOutputStream testOutputStreamError;

    @BeforeEach
    protected void setUp() throws Exception {
	systemOut = System.out;
	testOutputStream = new ByteArrayOutputStream();
	testOut = new PrintStream(testOutputStream);
	System.setOut(testOut);
	
	systemError = System.err;
	testOutputStreamError = new ByteArrayOutputStream();
	testError = new PrintStream(testOutputStreamError);
	System.setErr(testError);
    }
    
    @AfterEach
    protected void tearDown() throws Exception {
	System.setOut(systemOut);
	testOutputStream.close();
	
	System.setErr(systemError);
	testOutputStreamError.close();
    }
    
    @Test
    void testInitBootstrapLoader() {
	BootstrapLoader loader = new BootstrapLoader();
	Assertions.assertNotNull(loader);
    }
    
    @Test
    void testNotEnoughArguments() {
	Assertions.assertThrows(IllegalArgumentException.class, () -> BootstrapLoader.main());
    }
    
    @Test
    void test7900To7920() {
	BootstrapLoader.main("7900", "7920");
	Assertions.assertEquals(Arrays.asList(7901, 7907, 7919).toString(), this.testOutputStream.toString());
    }
    
    @Test
    void test7920To7900() {
	BootstrapLoader.main("7920", "7900");
	Assertions.assertEquals(Arrays.asList(7901, 7907, 7919).toString(), this.testOutputStream.toString());
    }
    
    @Test
    void testFirstArgumentDefault0() {
	BootstrapLoader.main("test", "10");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString());
    }
    
    @Test
    void testSecondArgumentDefault0() {
	BootstrapLoader.main("10", "test");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString());
    }
    
    @Test
    void testBothArgumentsDefault0() {
	BootstrapLoader.main("test", "test");
	Assertions.assertEquals(Arrays.asList().toString(), this.testOutputStream.toString());
    }
    
    @Test
    void testNegativeRange() {
	BootstrapLoader.main("-10", "10");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString());
    }
    
    @Test
    void testNegativeRangeReflective() {
	BootstrapLoader.main("10", "-10");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString());
    }
    
    @Test
    void testMaxIntRange() {
	BootstrapLoader.main(String.valueOf(Integer.MAX_VALUE-10), "2147483647");
	Assertions.assertEquals(Arrays.asList(Integer.MAX_VALUE).toString(), this.testOutputStream.toString());
    }
    
    @Test
    void testMinIntRange() {
	BootstrapLoader.main(String.valueOf(Integer.MIN_VALUE), String.valueOf(Integer.MIN_VALUE+10));
	Assertions.assertEquals(Arrays.asList().toString(), this.testOutputStream.toString());
    }
    
    @Test
    void testOverflowMaxInt() {
	BootstrapLoader.main(String.valueOf(10), "2147483648");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString());
    }
    
    @Test
    void testOverflowMinInt() {
	BootstrapLoader.main(String.valueOf(10), "-2147483649");
	Assertions.assertEquals(Arrays.asList(2,3,5,7).toString(), this.testOutputStream.toString());
    }

}
