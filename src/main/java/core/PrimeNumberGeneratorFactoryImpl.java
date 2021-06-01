package core;

import api.PrimeNumberGenerator;
import api.PrimeNumberGeneratorFactory;
import api.PrimeSieve;

public class PrimeNumberGeneratorFactoryImpl implements PrimeNumberGeneratorFactory{

    public PrimeSieve createPrimeSieve() {
	return new EratosthenesPrimeSieve();
    }

    public PrimeNumberGenerator createPrimeNumberGenerator() {
	return new SievePrimeGenerator(this);
    }

}
