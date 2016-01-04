/**
 * 
 */
package cipher;

/**
 * @author Richard
 *
 */
public class NumberCipher {

	private static int[] encrypt(String plain, int key){
		plain = plain.toUpperCase();
		System.out.println(plain);
		int[] cip = new int[plain.length()];
		int j = 0;
		for (int i = 0; i < plain.length(); i++){
			char p = plain.charAt(i);
			if (Character.isAlphabetic(p)){
				int num = plain.charAt(i) - 64;
				num += key;
				cip[j] = num;
				j++;
			}
		}
		return cip;
	}
	public static void main(String[] args) {
		boolean grouped = true;
		int[] cip = encrypt("Akela says well done, super communicator! ", 41);
		if (grouped){
			for (int i = 0; i < cip.length; i++) if (i%5 == 0) System.out.print(" " + cip[i]);
			else System.out.print("" + cip[i]);
		} else for(int i = 0; i < cip.length; i++) System.out.print(cip[i] + " ");
			
	}

}
