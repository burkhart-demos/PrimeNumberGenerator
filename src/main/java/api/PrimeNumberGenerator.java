package api;

import java.util.List;

public interface PrimeNumberGenerator {
    	
    public static final Integer FIRST_PRIME_NUMBER = 2;
    List<Integer> generate(int startValue, int endValue);
    boolean isPrime(int value);
	
}
