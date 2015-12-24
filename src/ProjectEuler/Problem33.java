/**
 * 
 */
package ProjectEuler;

/**
 * @author Richard
 *
 */
public class Problem33 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num, n, den, d;	// Numerator and denominator
		char n1, n2, d1, d2; 	// Digits in each
		double res;	// Results (To test for equivalency
		int[] nums = new int[4];	// Numerators
		int[] dens = new int[4];	// Denominators
		int c = 0;
		for (den = 11; den < 100; den++){	// Count up denominators
			if (den % 10 != 0) for (num = 11; num < den; num++){	// Skip if denominator is mod10
				if (num % 10 != 0 && num/(float)den < 1){
					res = num/(float)den;
					String t = String.valueOf(num);	// Temp for char getting
					n1 = t.charAt(0);
					n2 = t.charAt(1);
					t = String.valueOf(den);
					d1 = t.charAt(0);
					d2 = t.charAt(1);
					if (n1 == d1){
						n = Character.getNumericValue(n2);
						d = Character.getNumericValue(d2);
					}else if (n1 == d2){
						n = Character.getNumericValue(n2);
						d = Character.getNumericValue(d1);
					}else if (n2 == d1){
						n = Character.getNumericValue(n1);
						d = Character.getNumericValue(d2);
					}else if (n2 == d2){
						n = Character.getNumericValue(n1);
						d = Character.getNumericValue(d1);
					}else {
						n = -1;
						d = 2;
					}
					if(n/(float)d == res){
						nums[c] = n;
						dens[c] = d;
						c++;
					}
					if(c >= 4) break;
				}
			}
		}
		num = 1;
		den = 1;
		for(int p: nums) num *= p;
		for(int p: dens) den *= p;
		
		System.out.println("" + num + "/" + den);	// Unsimplified
	}

}
