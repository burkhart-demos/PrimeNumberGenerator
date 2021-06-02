package com.burkhart.primenumbergenerator.core;

import com.burkhart.primenumbergenerator.api.PrimeNumberGenerator;
import com.burkhart.primenumbergenerator.api.PrimeNumberGeneratorFactory;
import com.burkhart.primenumbergenerator.api.PrimeSieve;

public class PrimeNumberGeneratorFactoryImpl implements PrimeNumberGeneratorFactory{

    public PrimeSieve createPrimeSieve() {
	return new EratosthenesPrimeSieve();
    }

    public PrimeNumberGenerator createPrimeNumberGenerator() {
	return new SievePrimeGenerator(this);
    }

}
