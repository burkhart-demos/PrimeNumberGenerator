package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import api.PrimeNumberGeneratorFactory;
import api.PrimeSieve;

public class SievePrimeGeneratorTest {
    
    private SievePrimeGenerator classUnderTest;
    
    private PrimeNumberGeneratorFactory factoryMock;
    
    private PrimeSieve sieveMock;
    
    private static final List<Integer> EXPECTED_7900_TO_7920 = Arrays.asList(7901, 7907, 7919);
    
    private static final List<Integer> EXPECTED_NEGATIVE_50_TO_50 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
    
    private static final List<Integer> EXPECTED_NO_PRIMES_IN_RANGE = Collections.emptyList();

    @BeforeEach
    protected void setUp() throws Exception {
	factoryMock = Mockito.mock(PrimeNumberGeneratorFactory.class);
	sieveMock = Mockito.mock(PrimeSieve.class);
	Mockito.when(factoryMock.createPrimeSieve()).thenReturn(sieveMock);
	classUnderTest = new SievePrimeGenerator(factoryMock);
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
	when(sieveMock.generate(7900, 7920)).thenReturn(EXPECTED_7900_TO_7920);
	Assertions.assertEquals(EXPECTED_7900_TO_7920, classUnderTest.generate(7900, 7920));
	verify(sieveMock).generate(7900, 7920);
    }
    
    @Test
    void testGenerate7920To7900() {
	when(sieveMock.generate(7920, 7900)).thenReturn(EXPECTED_7900_TO_7920);
	Assertions.assertEquals(EXPECTED_7900_TO_7920, classUnderTest.generate(7920, 7900));
	verify(sieveMock).generate(7920, 7900);
    }
    
    @Test
    void testGenerateNegative50To50() {
	when(sieveMock.generate(-50, 50)).thenReturn(EXPECTED_NEGATIVE_50_TO_50);
	Assertions.assertEquals(EXPECTED_NEGATIVE_50_TO_50, classUnderTest.generate(-50, 50));
	verify(sieveMock).generate(-50, 50);
    }
    
    @Test
    void testGenerate50ToNegative50() {
	when(sieveMock.generate(50, -50)).thenReturn(EXPECTED_NEGATIVE_50_TO_50);
	Assertions.assertEquals(EXPECTED_NEGATIVE_50_TO_50, classUnderTest.generate(50, -50));
	verify(sieveMock).generate(50, -50);
    }
    
    @Test
    void testGenerateNegative100ToNegative1() {
	when(sieveMock.generate(-100, -1)).thenReturn(EXPECTED_NO_PRIMES_IN_RANGE);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(-100, -1));
	verify(sieveMock).generate(-100, -1);
    }
    
    @Test
    void testGenerateNegative1ToNegative100() {
	when(sieveMock.generate(-1, -100)).thenReturn(EXPECTED_NO_PRIMES_IN_RANGE);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(-1, -100));
	verify(sieveMock).generate(-1, -100);
    }
    
    @Test
    void testGenerate0To0() {
	when(sieveMock.generate(0, 0)).thenReturn(EXPECTED_NO_PRIMES_IN_RANGE);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(0, 0));
	verify(sieveMock).generate(0, 0);
    }
    
    @Test
    void testGenerate2To2() {
	List<Integer> expected = Arrays.asList(2);
	when(sieveMock.generate(2, 2)).thenReturn(expected);
	Assertions.assertEquals(expected, classUnderTest.generate(2, 2));
	verify(sieveMock).generate(2, 2);
    }
    
    @Test
    void testGenerateNegative2ToNegative2() {
	when(sieveMock.generate(-2, -2)).thenReturn(EXPECTED_NO_PRIMES_IN_RANGE);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(-2, -2));
	verify(sieveMock).generate(-2, -2);
    }
    
    @Test
    void testGenerateUpToMaxInt() {
	List<Integer> expected = Arrays.asList(Integer.MAX_VALUE);
	when(sieveMock.generate(Integer.MAX_VALUE-10, Integer.MAX_VALUE)).thenReturn(expected);
	Assertions.assertEquals(expected, classUnderTest.generate(Integer.MAX_VALUE-10, Integer.MAX_VALUE));
	verify(sieveMock).generate(Integer.MAX_VALUE-10, Integer.MAX_VALUE);
    }
    
    @Test
    void testGenerateDownToMinInt() {
	when(sieveMock.generate(Integer.MIN_VALUE, Integer.MIN_VALUE+10)).thenReturn(EXPECTED_NO_PRIMES_IN_RANGE);
	Assertions.assertEquals(EXPECTED_NO_PRIMES_IN_RANGE, classUnderTest.generate(Integer.MIN_VALUE, Integer.MIN_VALUE+10));
	verify(sieveMock).generate(Integer.MIN_VALUE, Integer.MIN_VALUE+10);
    }

}
