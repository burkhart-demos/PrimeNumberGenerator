package api;

/**
 * A factory pattern for instantiating concrete implementations of project interfaces.
 * 
 * @author Joe Burkhart
 *
 */
public interface PrimeNumberGeneratorFactory {
    
    /**
     * Creates and returns a PrimeSieve object.
     * 
     * @return a PrimeSieve object
     */
    PrimeSieve createPrimeSieve();
    
    /**
     * Creates and returns a PrimeNumberGenerator object.
     * 
     * @return a PrimeNumberGenerator object
     */
    PrimeNumberGenerator createPrimeNumberGenerator();

}
