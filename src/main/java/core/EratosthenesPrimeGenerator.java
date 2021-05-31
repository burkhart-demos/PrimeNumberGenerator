package core;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import api.PrimeNumberGenerator;

public class EratosthenesPrimeGenerator implements PrimeNumberGenerator{
    
	
    public List<Integer> generate(int startValue, int endValue) {
	int minValue = startValue <= endValue ? startValue : endValue;
	int maxValue = endValue >= startValue ? endValue : startValue;
	minValue = minValue > -1 ? minValue : 0;
	maxValue = maxValue > -1 ? maxValue : 0;
	
	PrimeSieve sieve = new PrimeSieve();
	
        for(int i = FIRST_PRIME_NUMBER; i <= Math.sqrt(maxValue); i++){
            if(sieve.isPrime(i)){
                for(int j = i*i; j <= maxValue; j = j+i){
                    sieve.markComposite(j);
                    long nextNum = (long)j + (long)i;
                    if(nextNum>Integer.MAX_VALUE) {
                	break;
                    }
                }
            }
        }
        
        return IntStream.rangeClosed(minValue, maxValue).boxed().filter(value -> sieve.isPrime(value)).collect(Collectors.toList());
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
	int startValue = Integer.valueOf(args[0]);
	int endValue = Integer.valueOf(args[1]);
	
	System.out.println(new EratosthenesPrimeGenerator().generate(startValue, endValue));
    }

}
