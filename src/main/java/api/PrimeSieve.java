package api;

import java.util.List;

/**
 * A Prime Sieve is some representation of determined prime numbers.
 * 
 * @author Joe Burkhart
 *
 */
public interface PrimeSieve {
    
    /**
     * Generate a sieve of primes up to the specified value.
     * 
     * @param startValue the lower bound to check for primes
     * @param endValue the upper bound to check for primes
     */
    List<Integer> generate(int startValue, int endValue);

}
