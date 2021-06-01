package core;

import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import api.PrimeSieve;

public class EratosthenesPrimeSieve implements PrimeSieve{
    
    private BitSet sieve;

    /**
     * Represents a sieve using the Eratosthenes algorithm.  Initially all values greater than one 
     * will be assumed prime until they are marked as composite.  Can only guarantee accuracy of primes
     * in the range given to the generate method.
     * 
     */
    public EratosthenesPrimeSieve() {
	this.sieve = new BitSet();
	this.sieve.set(0, true);
	this.sieve.set(1, true);
    }
    
    @Override
    public List<Integer> generate(int startValue, int endValue) {
	int minValue = Math.min(startValue, endValue) > 0 ? Math.min(startValue, endValue) : 0;
	int maxValue = Math.max(startValue, endValue) > 0 ? Math.max(startValue, endValue) : 0;
	
        for(int i = 2; i <= Math.sqrt(maxValue); i++){
            if(this.isPrime(i)){
                for(int j = i*i; j <= maxValue; j = j+i){
                    this.markComposite(j);
                    if(additionOverflow(j, i)) {
                	break;
                    }
                }
            }
        }
        
        return IntStream.rangeClosed(minValue, maxValue).boxed().filter(value -> this.isPrime(value)).collect(Collectors.toList());
    }
    
    
    /**
     * Returns whether the given value is a prime number based on internal representation.
     * 
     * @param value integer value to test
     * @return true if the value is marked prime, else false
     */
    private boolean isPrime(int value) {
	return !this.sieve.get(value);
    }
    
    /**
     * Sets a given value as composite. Does nothing if the value given is negative.
     * 
     * @param value integer value to set as a composite number
     */
    private void markComposite(int value) {
	if(value >= 0) {
	    this.sieve.set(value, true);
	}
    }
    
    /**
     * Helper method to determine overflow in the positive direction only.  Private helper abstraction for createSieve method where negative 
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
