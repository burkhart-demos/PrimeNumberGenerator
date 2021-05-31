package api;

import java.util.List;

public interface PrimeNumberGenerator {
    	
    public static final Integer FIRST_PRIME_NUMBER = 2;
    
    /**
     * Returns all the prime numbers found in the fully inclusive range from [startValue, endValue].
     * 
     * @param startValue starting integer of range
     * @param endValue ending integer of range
     * @return a list of any prime numbers in range, empty list if no primes are in the range
     */
    List<Integer> generate(int startValue, int endValue);
    
    /**
     * Returns whether the given value is a prime number.
     * 
     * @param value integer to test
     * @return true if prime, else false
     */
    boolean isPrime(int value);
	
}
