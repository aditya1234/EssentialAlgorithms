package primes;

public class FindNPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]); // Set in run configurations
		
		System.out.println("args[0] = " + n);
		int[] primeList = findPrimes(n);
		
		for (int i = 0; i < n; i++) {
			System.out.println(primeList[i]);
		}
	}
	
	public static int[] findPrimes(int n) {
		int[] primes = new int[n];
		
		int count = 0;
		primes[count++] = 2;
		
		for (int i = 3 ; count < n; i++) { // Try every number from 1 - n
			boolean prime = true;
			
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
		
		primes[0] = 1;
		
		return primes;
	}
}
