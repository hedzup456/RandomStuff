/**
 * 
 */
package cipher;

public class SimpleCaesar {
	private static String decrypt(String cipherText, int key){
		if (key < 0) key += 26;
		StringBuilder plainText = new StringBuilder();
		cipherText = cipherText.toUpperCase();
		for(int i = 0; i < cipherText.length(); i++){
			char p = cipherText.charAt(i);
			char r = p;
			if(Character.isAlphabetic(p)){
				r = (char)(p - key);
				if(r < (int)'A') r += 26;
				
			}
			plainText.append(r);
		}
		return plainText.toString();
	}
	
	private static String encrypt(String plainText, int key){
		while (key < 0) key += 26;
		StringBuilder cipherText = new StringBuilder();
		plainText = plainText.toUpperCase();
		for(int i = 0; i < plainText.length(); i++){
			char p = plainText.charAt(i);
			char r = p;
			if(Character.isAlphabetic(p)){
				r = (char)(p + key);
				while(r < 'A') r += 26;
				while(r > 'Z') r -= 26;
				
			}
			cipherText.append(r);
		}
		return cipherText.toString();
	}
	
	public static void main(String[] args) {
		String cipherText = "";
		cipherText = "How hard was this cipher to crack? – Akela";
		System.out.println(encrypt(cipherText, 15));
		}
}
