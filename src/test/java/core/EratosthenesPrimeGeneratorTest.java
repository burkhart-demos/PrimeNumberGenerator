package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class EratosthenesPrimeGeneratorTest {
    
    EratosthenesPrimeGenerator classUnderTest;

    @BeforeEach
    protected void setUp() throws Exception {
	classUnderTest = new EratosthenesPrimeGenerator();
    }
    
    @Test
    void testIsPrime2() {
	boolean actual = classUnderTest.isPrime(2);
	Assertions.assertTrue(actual);
    }
    
    @Test
    void testIsPrimeNegative2() {
	boolean actual = classUnderTest.isPrime(-2);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrime0() {
	boolean actual = classUnderTest.isPrime(0);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrime1() {
	boolean actual = classUnderTest.isPrime(1);
	Assertions.assertFalse(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrime19() {
	boolean actual = classUnderTest.isPrime(19);
	Assertions.assertTrue(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrimeNegative19() {
	boolean actual = classUnderTest.isPrime(-19);
	Assertions.assertFalse(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrime20() {
	boolean actual = classUnderTest.isPrime(20);
	Assertions.assertFalse(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrimeNegative20() {
	boolean actual = classUnderTest.isPrime(-20);
	Assertions.assertFalse(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrime21() {
	boolean actual = classUnderTest.isPrime(21);
	Assertions.assertFalse(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrimeNegative21() {
	boolean actual = classUnderTest.isPrime(-21);
	Assertions.assertFalse(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrime7902() {
	boolean actual = classUnderTest.isPrime(7902);
	Assertions.assertFalse(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrimeNegative7902() {
	boolean actual = classUnderTest.isPrime(-7902);
	Assertions.assertFalse(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrime7907() {
	boolean actual = classUnderTest.isPrime(7907);
	Assertions.assertTrue(actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testIsPrimeNegative7907() {
	boolean actual = classUnderTest.isPrime(-7907);
	Assertions.assertFalse(actual);
    }

}
