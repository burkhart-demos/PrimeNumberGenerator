package core;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class EratosthenesPrimeGeneratorTest {
    
    EratosthenesPrimeGenerator classUnderTest;
    
    static final List<Integer> EXPECTED_7900_TO_7920 = Arrays.asList(7901, 7907, 7919);

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
    @Disabled("Not implemented")
    void testGenerate7900To7920() {
	List<Integer> actual = classUnderTest.generate(7900, 7920);
	Assertions.assertEquals(EXPECTED_7900_TO_7920, actual);
    }
    
    @Test
    @Disabled("Not implemented")
    void testGenerate7920To7900() {
	List<Integer> actual = classUnderTest.generate(7920, 7900);
	Assertions.assertEquals(EXPECTED_7900_TO_7920, actual);
    }

}
