# PrimeNumberGenerator

## Overview
### Purpose
Create a console app that can generate all prime numbers found in a fully-inclusive range specified by the user.

### Plan
To generate all prime numbers in a range it is best to use a [Prime Sieve](https://en.wikipedia.org/wiki/Generation_of_primes) algorithm.  Specifically, we will use the [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes) algorithm.  To check whether a single number n is prime it is sufficient to use trial division, however, for optimization we only need to check the sqrt(n) potential factors because if a number n is non-prime (composite) then it will have at least one factor <= sqrt(n).

## Running the application
### Building and Testing
***Note: You will need to have Maven and Java 8+ installed***
 
To build the application and run all tests use the following command from the project root folder

``` mvn verify ```

Please be aware that there are a couple of test cases for upper bounds that will cause the testing to take a minute, but they are included to achieve 100% code coverage.  To find the JaCoCo code coverage reports after building and testing the application look under

``` \target\site\jacoco\index.html ```

Further more you can find some testing reports by looking under

``` \target\surefire-reports ```

### Execute the application
The prime number generator is a command line program that accepts two arguments that define the range of primes to generate.  To execute the app from the command line, run the following command from the project root folder

``` mvn compile exec:java -Dexec.args="First Second" ```

replacing ```First``` and ```Second``` with integer values.  Any input that is not a valid integer format will default to 0.  If too many or too few arguments are passed the app will terminate without running the generator.

##### Java heap space
Generation of primes in a very large range could result in the deafult java heap space being insufficient.  If you are using the application to generate primes in a very large range you may need to update your memory requirements in the ```pom.xml``` file.

## Coding Challenge Retrospective
While doing the coding challenge, about halfway through I had one interface (```PrimeNumberGenerator```) with one implementing class (```EratosthenesPrimeGenerator```).  This was good because the codebase had virtually no coupling and high cohesion.  However, in more robust applications there is always going to be at least some level of coupling - through database connection, services,  other modules, etc - even though the goal is always to keep coupling to a minimum.  I wanted to have an opportunity to show how I might go about handling some level of coupling both in implementation style as well as testing.  So, I added a new interface called ```PrimeSieve``` and an implementing class ```EratosthenesPrimeSieve```.  I wanted at least some benefit from the newly added coupling so I changed the name of ```EratosthenesPrimeGenerator``` to ```SievePrimeGenerator``` to make the underlying algorithm more ambigous and extract sieve algorithm and building responsibilities away from the generator.  Then I coupled ```PrimeSieve``` to the ```SievePrimeGenerator```, but I did so using a factory pattern.  The factory pattern allows the factory to take responsibility of instantiating concrete classes away from other objects like ```SievePrimeGenerator```.  For unit testing ```SievePrimeGenerator``` I obviously wanted to be careful not to test the coupled class in the ```generate()``` method, so I used mocking of the ```PrimeNumberGeneratorFactory``` and ```PrimeSieve```.  

Usually, for a straightforward, clean implementation I would have stuck with the one interface and one implementing class, but hopefully for demo purposes it is understood why I decided to introduce some level of coupling.

