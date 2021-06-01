package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrimeSieveTest {
    
    private PrimeSieve classUnderTest;

    @BeforeEach
    protected void setUp() throws Exception {
	classUnderTest = new PrimeSieve();
    }
    
    @Test
    void testInitPrimeSieve() {
	Assertions.assertAll(() -> Assertions.assertFalse(classUnderTest.isPrime(0)),
			     () -> Assertions.assertFalse(classUnderTest.isPrime(1)));
    }
    
    @Test
    void testIsPrime2() {
	Assertions.assertTrue(classUnderTest.isPrime(2));
    }
    
    @Test
    void testIsPrimeNegative2() {
	Assertions.assertFalse(classUnderTest.isPrime(-2));
    }
    
    @Test
    void testMarkComposite2() {
	classUnderTest.markComposite(2);
	Assertions.assertFalse(classUnderTest.isPrime(2));
    }
    
    @Test
    void testMarkCompositeNegative2() {
	classUnderTest.markComposite(-2);
	Assertions.assertFalse(classUnderTest.isPrime(-2));
    }
    
    @Test
    void testIsPrimeMaxInt() {
	Assertions.assertTrue(classUnderTest.isPrime(Integer.MAX_VALUE));
    }
    
    @Test
    void testIsPrimeMinInt() {
	Assertions.assertFalse(classUnderTest.isPrime(Integer.MIN_VALUE));
    }
    
    @Test
    void testMarkCompositeMaxInt() {
	classUnderTest.markComposite(Integer.MAX_VALUE);
	Assertions.assertFalse(classUnderTest.isPrime(Integer.MAX_VALUE));
    }
    
    @Test
    void testMarkCompositeMinInt() {
	classUnderTest.markComposite(Integer.MIN_VALUE);
	Assertions.assertFalse(classUnderTest.isPrime(Integer.MIN_VALUE));
    }

}
