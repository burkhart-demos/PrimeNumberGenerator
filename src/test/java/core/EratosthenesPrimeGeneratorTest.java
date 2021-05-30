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

}
