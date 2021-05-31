package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import api.PrimeNumberGenerator;

public class EratosthenesPrimeGenerator implements PrimeNumberGenerator{
    
	
    public List<Integer> generate(int startValue, int endValue) {
	int minValue = startValue <= endValue ? startValue : endValue;
	int maxValue = endValue >= startValue ? endValue : startValue;
	
	List<Boolean> primeSieve = new ArrayList<>();
	for(int i = 0; i <= maxValue; i++) {
	    if(i < FIRST_PRIME_NUMBER)
		primeSieve.add(false);
	    else
		primeSieve.add(true);
	}
	
        for(int i = FIRST_PRIME_NUMBER; i <= Math.sqrt(maxValue); i++){
            if(primeSieve.get(i)){
                for(int j = i*i; j <= maxValue; j = j+i){
                    primeSieve.set(j, false);
                }
            }
        }
        
        return IntStream.range(minValue, maxValue+1).boxed().filter(value -> primeSieve.get(value)).collect(Collectors.toList());
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
