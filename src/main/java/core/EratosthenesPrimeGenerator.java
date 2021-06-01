package core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import api.PrimeNumberGenerator;

public class EratosthenesPrimeGenerator implements PrimeNumberGenerator{
    
	
    public List<Integer> generate(int startValue, int endValue) {
	int minValue = Math.min(startValue, endValue) > 0 ? Math.min(startValue, endValue) : 0;
	int maxValue = Math.max(startValue, endValue) > 0 ? Math.max(startValue, endValue) : 0;
	
	PrimeSieve sieve = new PrimeSieve();
	
        for(int i = FIRST_PRIME_NUMBER; i <= Math.sqrt(maxValue); i++){
            if(sieve.isPrime(i)){
                for(int j = i*i; j <= maxValue; j = j+i){
                    sieve.markComposite(j);
                    if(additionOverflow(j, i)) {
                	break;
                    }
                }
            }
        }
        
        return IntStream.rangeClosed(minValue, maxValue).boxed().filter(value -> sieve.isPrime(value)).collect(Collectors.toList());
    }

    public boolean isPrime(int value) {
	if(value < FIRST_PRIME_NUMBER) {
	    return false;
	}
	
	if(value == FIRST_PRIME_NUMBER) {
	    return true;
	}
	
	for(int divisor = 2; divisor <= Math.sqrt(value); divisor++) {
	    if(value % divisor == 0) {
		return false;
	    }
	}
	
	return true;
    }
    
    /**
     * Helper method to determine overflow in the positive direction only.  Private helper abstraction for generate method where negative 
     * inputs are not possible and cannot guarantee accuracy with negative inputs.
     * 
     * @param a integer value
     * @param b integer value
     * @return true if a + b > MAX_INTEGER, else false
     */
    private static boolean additionOverflow(int a, int b) {
	return (long)a + (long)b > Integer.MAX_VALUE;
    }
}
