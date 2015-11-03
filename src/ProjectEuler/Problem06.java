package ProjectEuler;

public class Problem06 {
	public static int sumSquare(){ // Sum of squares (1^2+2^2...)
		int runTot=0;
		for(int i=1; i<=100; i++){
			runTot += Math.pow(i,2);
		} // For
		return runTot;
	} // End sumSquare
	public static int squareSum(){ // Square of sums (1+2+3+...)^2
		int runTot=0;
		for(int i=1; i<=100; i++){
			runTot+=i;
		} // For
		return (int)Math.pow(runTot,2);
	} // End squareSum
	public static void main(String[] args){
		System.out.println(squareSum()-sumSquare());
	} // End main
} // End class
