package ProjectEuler;


public class Problem14 {
	
	public static int iterationsOfCollatz = 1;
	private static int collatz(long seed, boolean output){
		if(output)System.out.println(seed);
		if(seed==1){
			return 1;
		} else if (seed % 2 == 0){
			seed /= 2;
			iterationsOfCollatz++;
		} else {
			seed = (3*seed) + 1;
			iterationsOfCollatz++;
		} // else
		return collatz(seed, output);
	} // collatz
	
	public static void main(String[] args){
		int bestRun = 0, bestSeed = 0;
		for(long i = 1; i < 1000000; i++){
			iterationsOfCollatz = 1;
			collatz(i, false);
			if (bestRun < iterationsOfCollatz) bestRun = iterationsOfCollatz; bestSeed = (int)i;
		} // for
	System.out.println("Seed: "+ bestSeed);
	System.out.println("Run: " + bestRun);
	System.out.println(collatz(bestSeed, true));
	} // main
} // class

