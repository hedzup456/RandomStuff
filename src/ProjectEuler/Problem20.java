package ProjectEuler;

import java.math.BigInteger;

public class Problem20 {
	private static void factorial(int seed){
		for (; seed > 0; seed--){
			BigInteger seedBI = BigInteger.valueOf(seed);
			factorial = factorial.multiply(seedBI);
		}		
	} // factorial
	private static BigInteger factorial = new BigInteger("1");
	
	public static void main(String[] args) {
		factorial(100);
		System.out.println(factorial);
		System.out.println(CommonMethods.totalDigits(factorial.toString()));	
	}

}
