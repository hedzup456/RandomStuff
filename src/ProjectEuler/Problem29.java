package ProjectEuler;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem29 {

	public static void main(String[] args) {
		ArrayList<BigInteger> results = new ArrayList<BigInteger>();
		int lim = 100;
		for(int a = 2; a <= lim; a++){
			for(int b = 2; b <= lim; b++){
				BigInteger aB = BigInteger.valueOf(a);
				BigInteger t = aB.pow(b);
				if(results.contains(t)) continue;
				else results.add(t);
			}
		}
		System.out.println(results.size());
	}

}
