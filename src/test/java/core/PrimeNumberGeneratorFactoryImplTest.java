package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import api.PrimeNumberGenerator;
import api.PrimeSieve;

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
