package com.burkhart.primenumbergenerator.core;

import java.util.List;

import com.burkhart.primenumbergenerator.api.PrimeNumberGenerator;
import com.burkhart.primenumbergenerator.api.PrimeNumberGeneratorFactory;

public class SievePrimeGenerator implements PrimeNumberGenerator{
    
    private final PrimeNumberGeneratorFactory factory;
    
    /**
     * A prime generator that uses an underlying prime sieve algorithm to determine prime numbers.
     * 
     * @param factory a PrimeNumberGeneratorFactory instance
     * @see PrimeNumberGeneratorFactory
     */
    public SievePrimeGenerator(final PrimeNumberGeneratorFactory factory) {
	this.factory = factory;
    }
    
    @Override
    public List<Integer> generate(final int startValue, final int endValue) {
        return this.factory.createPrimeSieve().generate(startValue, endValue);
    }

    @Override
    public boolean isPrime(final int value) {
	if(value < FIRST_PRIME_NUMBER) {
	    return false;
	}
	
	for(int divisor = 2; divisor <= Math.sqrt(value); divisor++) {
	    if(value % divisor == 0) {
		return false;
	    }
	}
	
	return true;
    }
}
