/**
 * 
 */
package ProjectEuler;

/**
 * @author 	Richard
 * @since	14 Jan 2016
 *
 */
public class Problem37 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 10, tot = 0, count = 0;
		while (count < 11){
			if(checkForTruncatablePrime(i)){
				System.out.println(i);
				tot += i;
				count++;
			}
			i++;
		}
		System.out.println(tot);
	}
	private static boolean checkForTruncatablePrime(int i){
		if (CommonMethods.checkIfPrime(i)){
			return tryLeft(i) && tryRight(i);
		}
		return false;
	}
	private static boolean tryRight(int i){
		boolean isPossible = true;
		while (i > 10 && isPossible){
			i /= 10;
			isPossible = CommonMethods.checkIfPrime(i);
		}
		return isPossible;
	}
	private static boolean tryLeft(int i){
		boolean isPossible = true;
		while (i > 10 && isPossible){
			int length = Integer.toString(i).length()-1;
			int div = (int)Math.pow(10, length);
			i %= div;
			div /= 10;
			isPossible = CommonMethods.checkIfPrime(i);
		}
		return isPossible;
	}

}
