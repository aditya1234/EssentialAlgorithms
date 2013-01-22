package primes;

public class FindPrimesToN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]); // Set in run configurations
		System.out.println("args[0] = " + n);
		boolean[] primeList = primes(n);
		
		int printed = 1;
		for (int i = 1; i < n; i++) {
			if (primeList[i]) {
				if (printed % 10 != 0) {
					printed++;
					System.out.print(i + ", ");
					continue;
				} else {
					printed++;
					System.out.println(i);
				}
			}
		}
	}
	
	/**
	 * Uses Sieve of Eratosthenes Algo: 
	 * 		http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 * @param n number to find primes up to
	 * @return boolean list if primes are valid or not
	 */
	public static boolean[] primes(int n) {
		boolean[] primes = new boolean[n];
		
		for (int i = 0; i < n; i++) //Prep the array 
			primes[i] = true;
		
		for (int i = 2; i <= Math.sqrt((double)n); i++) { //Try all numbers from 2 - sqrt of n (maximum value of a prime)
			if (primes[i]) {	//Don't bother checking ones already deemed unacceptable
				for (int j = 2; j*i < n; j++) { //Set 2i, 3i, 4i up until j*i == n (don't overflow!)
					primes[i*j] = false;
				}
			}
		}
		
		return primes;
	}

}
