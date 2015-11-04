package ProjectEuler;

public class Problem30 {

	public static void main(String[] args) {
		long rT = 0;
		/*	x*9^5 = x*59049 :. we need 5 digits.
		 * 	5*59045 = 295245 :. we can make a six digit number with 5 digts
		 * 	^*59045 = 354294 
		 */
		for(int i = 2; i <= 354294; i++){
			int totOfFifDig = 0;
			String iS = Integer.toString(i);
			for (int x = 0; x < iS.length(); x++){
				int dig = Character.getNumericValue(iS.charAt(x)); 
				totOfFifDig += (int)Math.pow(dig, 5);
			}
			if (totOfFifDig == i) rT += i;
		}
		System.out.println(rT);
		

	}

}
