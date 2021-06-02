package com.burkhart.primenumbergenerator.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.burkhart.primenumbergenerator.api.PrimeNumberGenerator;
import com.burkhart.primenumbergenerator.api.PrimeSieve;
import com.burkhart.primenumbergenerator.core.PrimeNumberGeneratorFactoryImpl;

public class PrimeNumberGeneratorFactoryImplTest {
    
    private PrimeNumberGeneratorFactoryImpl classUnderTest;

    @BeforeEach
    protected void setUp() throws Exception {
	classUnderTest = new PrimeNumberGeneratorFactoryImpl();
    }
    
    @Test
    void testCreatePrimeSieve(){
	Assertions.assertTrue(classUnderTest.createPrimeSieve() instanceof PrimeSieve);
    }
    
    
    @Test
    void testCreatePrimeNumberGenerator() {
	Assertions.assertTrue(classUnderTest.createPrimeNumberGenerator() instanceof PrimeNumberGenerator);
    }

}
