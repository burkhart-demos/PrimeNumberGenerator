package com.burkhart.primenumbergenerator.core;

import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.burkhart.primenumbergenerator.api.PrimeSieve;

public class EratosthenesPrimeSieve implements PrimeSieve{
    
    private final BitSet sieve;

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
    public List<Integer> generate(final int startValue, final int endValue) {
	final int minValue = Math.min(startValue, endValue) > 0 ? Math.min(startValue, endValue) : 0;
	final int maxValue = Math.max(startValue, endValue) > 0 ? Math.max(startValue, endValue) : 0;
	
        for(int factor = 2; factor <= Math.sqrt(maxValue); factor++){
            if(this.isPrime(factor)){
                for(int multiple = factor*factor; multiple <= maxValue; multiple = multiple+factor){
                    this.markComposite(multiple);
                    if(additionOverflow(multiple, factor)) {
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
    private boolean isPrime(final int value) {
	return !this.sieve.get(value);
    }
    
    /**
     * Sets a given value as composite. Does nothing if the value given is negative.
     * 
     * @param value integer value to set as a composite number
     */
    private void markComposite(final int value) {
	this.sieve.set(value, true);
    }
    
    /**
     * Helper method to determine overflow in the positive direction only.  Private helper abstraction for createSieve method where negative 
     * inputs are not possible and cannot guarantee accuracy with negative inputs.
     * 
     * @param a integer value
     * @param b integer value
     * @return true if a + b > MAX_INTEGER, else false
     */
    private static boolean additionOverflow(final int a, final int b) {
	return (long)a + (long)b > Integer.MAX_VALUE;
    }
}
