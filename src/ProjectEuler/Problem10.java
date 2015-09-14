package ProjectEuler;

public class Problem10 {
	private static int[] calcPrimes(int max){
		boolean[] isComposite = new boolean[max + 1]; 
	    for (int i = 2; i * i <= max; i++) {
	        if (!isComposite [i]) {
	            for (int j = i; i * j <= max; j++) {
	                isComposite [i*j] = true;
	            } // for j
	        } // if
	    } // for i
	    int numPrimes = 0; // number of primes
	    for (int i = 2; i <= max; i++) {
	        if (!isComposite [i]) numPrimes++;
	    } // for i
	    int [] primes = new int [numPrimes];
	    int index = 0;
	    for (int i = 2; i <= max; i++) {
	        if (!isComposite [i]) primes [index++] = i;
	    } // for i
	    return primes;
	} // calcPrimes
	

	public static void main(String[] args){
		int[] primes = calcPrimes(2000000);
		long sum = 0L;
		for(int iterator = 0; iterator < primes.length; iterator++){
			sum += primes[iterator];
		} // for
		System.out.println(sum);
	} // Main
} // Class
