package ProjectEuler;

public class Problem12 {
	private static int genTriNum(int n){
		int runtot = 0;
		for(int i = 0; i<=n; i++){
			runtot += i;
		}// for
		return runtot;
	} // genTriNum
	
	private static int numOfFactors(int numToCheck){
		int numFactors = 0;
		for(int i = 1; i <= Math.pow(numToCheck, 0.5); i++){
			if (numToCheck%i == 0){
				numFactors+=2; // Not interested in what the factors are
			}
		} // for
		return numFactors;
	} // numOfFactors
	
	public static void main(String[] args){
		int numOfFactors = 0, i = 0;
		while(numOfFactors < 500){
			i++;
			numOfFactors = numOfFactors(genTriNum(i));
		} // while
		System.out.println(genTriNum(i));
	} // Main
} // class
