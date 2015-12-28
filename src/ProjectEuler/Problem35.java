package ProjectEuler;

import java.util.ArrayList;

public class Problem35 {

	public static void main(String[] args) {
		ArrayList<Integer> CircPrimes = new ArrayList<Integer>();
		for (int i = 100; i <= 1000000; i++){ // Given circular primes up to 100 (97 last prime before 100)
			if (!CircPrimes.contains(i) && CommonMethods.checkIfPrime(i)){
			// Check for circularity
				String iToS = String.valueOf(i);
				int[] poss = new int[iToS.length()];
				poss[0] = i;	// First case would be i
				boolean circ = true;
				for (int j = 1; j < iToS.length(); j++){
					iToS = iToS.substring(1) + iToS.charAt(0);	// Rotate by one digit
					if(CommonMethods.checkIfPrime(Integer.parseInt(iToS))) poss[j] = Integer.parseInt(iToS);
					else {	// Set flag to false (1<= option not prime and break out of the loop
						circ = false;
						break;
					}
				}
				if(circ) for (int p: poss) CircPrimes.add(p); // Add all variants of the circular primes to the arraylist
			}			
		}
		System.out.println(CircPrimes.size()+13);	// 13 circ primes below 100, from brief

	}

}
