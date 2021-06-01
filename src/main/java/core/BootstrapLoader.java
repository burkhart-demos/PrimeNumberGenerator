package core;

import api.PrimeNumberGeneratorFactory;

/**
 * Main class for running the PrimeNumberGenerator from the command line.  Expects exactly two arguments that
 * are integer values for the endpoints of the prime generation range.  Input that is not formatted as an integer
 * will default to 0.
 * 
 */
public class BootstrapLoader {
    
    public BootstrapLoader() {
	
    }
    
    public static void main(String... args) {
	if(args.length != 2) {
	    throw new IllegalArgumentException("Expected exactly two integer arguments {startValue} {endValue}");
	}
	
	int startValue;
	try {
	    startValue = Integer.parseInt(args[0]);
	} catch(NumberFormatException e) {
	    startValue = 0;
	}
	
	int endValue;
	try {
	    endValue = Integer.parseInt(args[1]);
	} catch(NumberFormatException e ) {
	    endValue = 0;
	}
	
	PrimeNumberGeneratorFactory factory = new PrimeNumberGeneratorFactoryImpl();
	System.out.print(factory.createPrimeNumberGenerator().generate(startValue, endValue));
    }

}
