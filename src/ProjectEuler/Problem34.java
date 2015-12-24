/**
 * 
 */
package ProjectEuler;

/**
 * @author Richard
 *
 */
public class Problem34 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long fullTot = 0L;
		for (int targ = 3; targ < 7*CommonMethods.factorial(9); targ++){	// Eight times nine factorial isn't nine digits
			int i = targ;
			int tot = 0;
			int digit;
			while (i > 0){
				digit = i % 10;
				tot += CommonMethods.factorial(digit);
				i /= 10;
			}
			if (tot == targ){
				System.out.println(tot);
				fullTot += tot;
			}
		}
	System.out.println(fullTot);
	}
}
