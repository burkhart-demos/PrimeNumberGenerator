package core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EratosthenesPrimeSieveTest {
    
    private EratosthenesPrimeSieve classUnderTest;
    
    private static final List<Integer> EXPECTED_7900_TO_7920 = Arrays.asList(7901, 7907, 7919);
    
    private static final List<Integer> EXPECTED_NEGATIVE_50_TO_50 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
    
    private static final List<Integer> EXPECTED_NO_PRIMES_IN_RANGE = Collections.emptyList();

    @BeforeEach
    protected void setUp() throws Exception {
	classUnderTest = new EratosthenesPrimeSieve();
    }
    
    @Test
    void testGenerate7900To7920(){
	Assertions.assertEquals(EXPECTED_7900_TO_7920, classUnderTest.generate(7900, 7920));
    }
    
    @Test
    void testGenerate7920To7900(){
	Assertions.assertEquals(EXPECTED_7900_TO_7920, classUnderTest.generate(7920, 7900));
    }
    
    @Test
    void testGenerateNegative50To50() {
	Assertions.assertEquals(EXPECTED_NEGATIVE_50_TO_50, classUnderTest.generate(-50, 50));
    }
    
    @Test
    void testGenerate50ToNegative50() {
	Assertions.assertEquals(EXPECTED_NEGATIVE_50_TO_50, classUnderTest.generate(50, -50));
    }
    
    @Test
    void testGenerateNegative100ToNegative1() {
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(-100, -1));
    }
    
    @Test
    void testGenerateNegative1ToNegative100() {
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(-1, -100));
    }
    
    @Test
    void testGenerate0To0() {
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(0, 0));
    }
    
    @Test
    void testGenerate2To2() {
	Assertions.assertEquals(Arrays.asList(2), classUnderTest.generate(2, 2));
    }
    
    @Test
    void testGenerateNegative2ToNegative2() {
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(-2, -2));
    }
    
    @Test
    void testGenerateUpToMaxInt() {
	Assertions.assertEquals(Arrays.asList(Integer.MAX_VALUE), classUnderTest.generate(Integer.MAX_VALUE-10, Integer.MAX_VALUE));
    }
    
    @Test
    void testGenerateDownToMinInt() {
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(Integer.MIN_VALUE, Integer.MIN_VALUE+10));
    }

}
