package primes;

public class FindNthPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]); // Set in run configurations
		System.out.println("args[0] = " + n);
		System.out.println(findNthPrime(n));
	}
	
	public static int findNthPrime(int n) {
		int[] primes = new int[n];
		
		int count = 0;
		primes[count++] = 2;
		
		for (int i = 3 ; count < n; i++) { // Try every number from 3 - n
			boolean prime = true;
			
			//A number is prime if it is indivisible by all primes before it
			for (int j = 0; i / primes[j] >= primes[j]; j++) {
				if (i % primes[j] == 0) {
					prime = false;
					break;
				}
			}
			
			if (prime) {
				primes[count++] = i;
			}
		}
		
		return primes[n-1];
	}

}
