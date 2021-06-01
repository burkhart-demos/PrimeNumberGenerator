package core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import api.PrimeNumberGenerator;
import api.PrimeNumberGeneratorFactory;
import api.PrimeSieve;

public class SievePrimeGenerator implements PrimeNumberGenerator{
    
    private PrimeNumberGeneratorFactory factory;
    
    /**
     * A prime generator that uses an underlying prime sieve algorithm to determine prime numbers.
     * 
     * @param factory a PrimeNumberGeneratorFactory instance
     * @see PrimeNumberGeneratorFactory
     */
    public SievePrimeGenerator(PrimeNumberGeneratorFactory factory) {
	this.factory = factory;
    }
    
    @Override
    public List<Integer> generate(int startValue, int endValue) {
        return this.factory.createPrimeSieve().generate(startValue, endValue);
    }

    @Override
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
}
