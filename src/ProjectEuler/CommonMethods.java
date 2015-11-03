package ProjectEuler;

public class CommonMethods {
	public static long totalDigits(String str){
		long total = 0;
		for(int index = 0; index < str.length(); index++){
			total += Character.getNumericValue(str.charAt(index));
		}
		return total;
	} // End totalDigits
	public static int[] genPrimes(int limit){
		boolean isPrime[] = new boolean[limit+1];
		
		for(int i = 2; i <= limit; i++){
			isPrime[i] = true; // Set default values, ignoring indexes 0 and 1 as both are inapplicable to primes
		} // for i
		for (int i = 2; i*i <= limit; i++){ // Only need to check to sqrt(limit)
			// For each number, mark all multiples of it as not-prime, starting with the lowest number
			for (int j = 2; i*j <= limit; j++){ // Starting with double the number, going until the limit is exceeded, mark as false
				isPrime[i*j] = false;
			} // for j
		} // for i
		String x = new String();
		for (int i = 2; i <= limit; i++){
			if(isPrime[i]) x += i + ",";
		} // for i
		x = x.substring(0, x.length()-1);
		String[]  xA= x.split(",");
		int[] tR = new int[xA.length];
		for(int i = 0; i < xA.length; i++) tR[i] = Integer.parseInt(xA[i]);
		return tR;
	} // End genPrimes
	public static int getCharVal(char x){
		x = Character.toLowerCase(x);
		switch (x){
		case 'a':
			return 1;
			
		case 'b':
			return 2;
			
		case 'c':
			return 3;
			
		case 'd':
			return 4;
			
		case 'e':
			return 5;
			
		case 'f':
			return 6;
			
		case 'g':
			return 7;
			
		case 'h':
			return 8;
			
		case 'i':
			return 9;
			
		case 'j':
			return 10;
			
		case 'k':
			return 11;
			
		case 'l':
			return 12;
			
		case 'm':
			return 13;
			
		case 'n':
			return 14;
			
		case 'o':
			return 15;
			
		case 'p':
			return 16;
			
		case 'q':
			return 17;
			
		case 'r':
			return 18;
			
		case 's':
			return 19;
			
		case 't':
			return 20;
			
		case 'u':
			return 21;
			
		case 'v':
			return 22;
			
		case 'w':
			return 23;
			
		case 'x':
			return 24;
			
		case 'y':
			return 25;
			
		case 'z':
			return 26;
		
		default:
			return 0;
		}
	}
	public static int sumOfDivisors(int seed){
		int total = 0, limit = seed;
		 for(int i=1;i<limit;i++){
		        if(seed%i==0){
		            if(i!=1){
		                if(i != seed/i) total += (i + seed/i);
		                else total += i;
		            } else total += i;
		            limit = seed/i;
		        }
		    }       
		    return total;
	} // sumOfDivisors
	public static boolean checkIfPrime(long numCheck) {
		if(numCheck <= 1) return false;
		long sqrtNumcheck = (long)Math.pow(numCheck, 0.5) + 1;
		for(int i = 2; i < sqrtNumcheck; i++) {
			if (numCheck%i == 0) return false; // If at any point it's divisible it can't be prime
		}
		return true; // Return true if false has not been returned yet
	}
}

