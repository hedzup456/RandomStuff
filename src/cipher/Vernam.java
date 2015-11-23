/**
 * 
 */
package cipher;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Richard
 *
 */
public class Vernam {
	private static char[] getRandomKey(Scanner sc, int length){
		char[] key = new char[length];
		System.out.println("Press random keys for some time then press enter.");
		String keyFormer = sc.next();
		while(keyFormer.length() <= length){
			System.out.println("Again.");
			keyFormer += sc.next();
		}
		for(int index = 0; index < length; index++){
			int fromKF = (int)keyFormer.charAt(index);
			long mil = System.currentTimeMillis() %1000;
			char p = (char)(fromKF * mil%128);
			key[index] = p;			
		}
		return key;
	}
	private static void encrypt(Scanner sc, String P){
		char[] key = getRandomKey(sc, P.length());
		StringBuilder C = new StringBuilder();
		StringBuilder k = new StringBuilder();
		for(int i= 0; i < P.length(); i++){
			char c = (char)(key[i]^P.charAt(i));
			C.append(c);
			k.append(key[i]);
		}
		System.out.println("C:" + C.toString());
		System.out.println("K:" + k.toString());
	}
	private static void decrypt(Scanner sc,String P){
		System.out.println("Key: ");
		char[] key = sc.nextLine().toCharArray();
		StringBuilder C = new StringBuilder();
		for(int i= 0; i < P.length(); i++){
			char c = (char)(key[i]^P.charAt(i));
			C.insert(i, c);
		}
		System.out.println("P:" + C.toString());
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text:");
		String P = sc.nextLine();
		System.out.println("E/D:");
		char choice = sc.nextLine().charAt(0);
		if(choice == 'E') encrypt(sc, P);
		else if(choice == 'D') decrypt(sc, P);
		else System.out.println("Not valid");
		
		

	}

}
