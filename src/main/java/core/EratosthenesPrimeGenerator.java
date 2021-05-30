package core;

import java.util.List;

import api.PrimeNumberGenerator;

public class EratosthenesPrimeGenerator implements PrimeNumberGenerator{
    
	
    public List<Integer> generate(int startValue, int endValue) {
	// TODO Auto-generated method stub
	return null;
    }

    public boolean isPrime(int value) {
	if(value == FIRST_PRIME_NUMBER)
	    return true;
	
	if(value > FIRST_PRIME_NUMBER) {
	    for(int divisor = 2; divisor <= Math.sqrt(value); divisor++) {
		if(value % divisor == 0)
		    return false;
	    }
	
	    return true;
	}
	    	
	return false;
    }
	

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
