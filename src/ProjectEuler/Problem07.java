package ProjectEuler;

public class Problem07 {
	public static boolean isPrime(int numToCheck){
		for (int i=2; i<= Math.sqrt(numToCheck); i++){
			if(numToCheck%i==0){
				return false;
			} // End if
		} // End for
		return true; // If not false, must be true. LOGIC
	} // End isPrime
	
	public static void main(String[] args){
		int highestKnown = 1;
		for(int count = 0; count < 10001; ){ // CHANGE COUNT <= x
			for(int i = highestKnown+1; i<Integer.MAX_VALUE;i++){
				if(isPrime(i)){
					count++; // Found one more prime
					System.out.println(i); // Output the prime
					highestKnown = i;
					break;
				} // End prime checking if
			} // End loop
		} // End counting loop
	} // End main
} // End class
