# Purpose
Create a console app that can generate all prime numbers found in a fully-inclusive range specified by the user.

# Plan
To generate all prime numbers in a range it is best to use a [Prime Sieve](https://en.wikipedia.org/wiki/Generation_of_primes) algorithm.  Specifically, we will use the [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes) algorithm.  To check whether a single number n is prime it is sufficient to use trial division, however, for optimization we only need to check the sqrt(n) potential factors because if a number n is non-prime (composite) then it will have at least one factor <= sqrt(n).
