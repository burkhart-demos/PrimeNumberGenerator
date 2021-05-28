package api;

import java.util.List;

public interface PrimeNumberGenerator {
	List<Integer> generate(int startValue, int endValue);
	boolean isPrime();
}
