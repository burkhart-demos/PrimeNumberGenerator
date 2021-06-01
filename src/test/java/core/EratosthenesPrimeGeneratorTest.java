package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class EratosthenesPrimeGeneratorTest {
    
    private EratosthenesPrimeGenerator classUnderTest;
    
    private static final List<Integer> EXPECTED_7900_TO_7920 = Arrays.asList(7901, 7907, 7919);
    
    private static final List<Integer> EXPECTED_NEGATIVE_50_TO_50 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
    
    private static final List<Integer> EXPECTED_NO_PRIMES_IN_RANGE = Collections.emptyList();

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
    void testIsPrimeNegative1() {
	boolean actual = classUnderTest.isPrime(-1);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrime19() {
	boolean actual = classUnderTest.isPrime(19);
	Assertions.assertTrue(actual);
    }
    
    @Test
    void testIsPrimeNegative19() {
	boolean actual = classUnderTest.isPrime(-19);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrime20() {
	boolean actual = classUnderTest.isPrime(20);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrimeNegative20() {
	boolean actual = classUnderTest.isPrime(-20);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrime21() {
	boolean actual = classUnderTest.isPrime(21);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrimeNegative21() {
	boolean actual = classUnderTest.isPrime(-21);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrime7902() {
	boolean actual = classUnderTest.isPrime(7902);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrimeNegative7902() {
	boolean actual = classUnderTest.isPrime(-7902);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrime7907() {
	boolean actual = classUnderTest.isPrime(7907);
	Assertions.assertTrue(actual);
    }
    
    @Test
    void testIsPrimeNegative7907() {
	boolean actual = classUnderTest.isPrime(-7907);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testIsPrimeMaxInteger() {
	boolean actual = classUnderTest.isPrime(Integer.MAX_VALUE);
	Assertions.assertTrue(actual);
    }
    
    @Test
    void testIsPrimeMinInteger() {
	boolean actual = classUnderTest.isPrime(Integer.MIN_VALUE);
	Assertions.assertFalse(actual);
    }
    
    @Test
    void testGenerate7900To7920() {
	List<Integer> actual = classUnderTest.generate(7900, 7920);
	Assertions.assertEquals(EXPECTED_7900_TO_7920, actual);
    }
    
    @Test
    void testGenerate7920To7900() {
	List<Integer> actual = classUnderTest.generate(7920, 7900);
	Assertions.assertEquals(EXPECTED_7900_TO_7920, actual);
    }
    
    @Test
    void testGenerateNegative50To50() {
	List<Integer> actual = classUnderTest.generate(-50, 50);
	Assertions.assertEquals(EXPECTED_NEGATIVE_50_TO_50, actual);
    }
    
    @Test
    void testGenerate50ToNegative50() {
	List<Integer> actual = classUnderTest.generate(50, -50);
	Assertions.assertEquals(EXPECTED_NEGATIVE_50_TO_50, actual);
    }
    
    @Test
    void testGenerateNegative50To1() {
	List<Integer> actual = classUnderTest.generate(-50, 1);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, actual);
    }
    
    @Test
    void testGenerateNegative50ToNegative1() {
	List<Integer> actual = classUnderTest.generate(-50, -1);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, actual);
    }
    
    @Test
    void testGenerate0To0() {
	List<Integer> actual = classUnderTest.generate(0, 0);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, actual);
    }
    
    @Test
    void testGenerate2To2() {
	List<Integer> expected = Arrays.asList(2);
	List<Integer> actual = classUnderTest.generate(2, 2);
	Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void testGenerateNegative2ToNegative2() {
	List<Integer> actual = classUnderTest.generate(-2, -2);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, actual);
    }
    
    @Test
    void testGenerate19To19() {
	List<Integer> expected = Arrays.asList(19);
	List<Integer> actual = classUnderTest.generate(19, 19);
	Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void testGenerate20To20() {
	List<Integer> actual = classUnderTest.generate(20, 20);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, actual);
    }
    
    @Test
    void testGenerate21To21() {
	List<Integer> actual = classUnderTest.generate(21, 21);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, actual);
    }
    
    @Test
    void testGenerateUpToMaxInt() {
	List<Integer> expected = Arrays.asList(Integer.MAX_VALUE);
	List<Integer> actual = classUnderTest.generate(Integer.MAX_VALUE-10, Integer.MAX_VALUE);
	Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void testGenerateDownToMinInt() {
	List<Integer> actual = classUnderTest.generate(Integer.MIN_VALUE, Integer.MIN_VALUE+10);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, actual);
    }

}
