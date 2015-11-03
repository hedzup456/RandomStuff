package ProjectEuler;

import java.util.HashSet;

/* Find all numbers that are abundant below the limit
 * Find all the numbers made by adding those numbers
 * Find all the numbers NOT in the list above and sum them
 */


public class Problem23 {
	private static boolean isAbundant(int seed){
		if (CommonMethods.sumOfDivisors(seed) > seed) return true;
		return false;
	}
	private static boolean sumOfTwoAbundant(int n, HashSet<Integer> abundant){
		for(Integer i: abundant){
			if(abundant.contains(n-i)) return true;
		}
		return false;
	}	
	public static void main(String[] args) {
		long total = 0;
		HashSet<Integer> abundant = new HashSet<Integer>();
		for(int i = 2; i < 28124; i++){
			if(isAbundant(i)) abundant.add(i);
		}
		for (int i = 1; i < 28124; i++){
			if(!sumOfTwoAbundant(i, abundant)) total += i;
		}
		
		System.out.println(total);
	}

}
