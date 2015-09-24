package ProjectEuler;


public class Problem14 {
	public static int collatz(int seed){
		int count = 1; // init count at one as there will always be at least on number in the chain
		while (seed != 1){
			if (seed%2 == 0){ // check for evenness
				seed /= 2; // shorthand of seed = seed / 2
			} else { // if odd
				seed *= 3;
				seed++; // seed = 3*seed + 1
			} // end if/else
			count++;
		} // while
		return count;
	} // collatz
	
	
	public static int collatz2(long seed){
		int count = 0;
		while(seed > 1){
			System.out.print(seed + " ");
			if (seed%2==1) seed = 3*seed+1;
			else seed /= 2;
			count++;
		} // while
		count++;
		System.out.print(seed);
		System.out.println();
		return count;
	} // collatz2
	
	public static void main(String[] args){
		long bestSeed = -1, lengthChain = 0, longestChain = 0;
		for (long newSeed = 1; newSeed < 1000000; newSeed++){
			lengthChain = collatz2(newSeed);
			if (lengthChain > longestChain){
				longestChain = lengthChain;
				bestSeed = newSeed;
			} // if
		} // for
		
		System.out.println(bestSeed);
		
	} // main
} // class
