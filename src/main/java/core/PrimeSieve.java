package core;

import java.util.BitSet;

public class PrimeSieve {
    
    private BitSet sieve;

    /**
     * Represents a bit wise sieve for prime numbers.  Initially all values greater than one 
     * will be assumed prime until they are marked as composite
     */
    public PrimeSieve() {
	this.sieve = new BitSet();
	this.sieve.set(0, true);
	this.sieve.set(1, true);
    }
    
    /**
     * Returns whether a value is prime based on state of the Sieve.
     * 
     * @param value integer to check
     * @return true if the value is recognized as prime internally, else false
     */
    public boolean isPrime(int value) {
	return !this.sieve.get(value);
    }
    
    /**
     * Sets a given value as composite.
     * 
     * @param value integer value to set as a composite number
     */
    public void markComposite(int value) {
	this.sieve.set(value, true);
    }
}
