package ProjectEuler;

import java.math.BigInteger;

public class Problem16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger num = BigInteger.valueOf(2);
		num = num.pow(1000);		
		String numb = num.toString();
		System.out.println(num);
		int runTot = 0;

		for(int i = 0; i < numb.length(); i++){
			runTot += Character.getNumericValue(numb.charAt(i));
		}
		System.out.println(runTot);
	}

}
