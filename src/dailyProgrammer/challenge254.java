/**
 * 
 */
package dailyProgrammer;

/**
 * @author 	Richard
 * @since	19 Feb 2016
 *
 */
public class challenge254 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pTAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ctAlphabet = "zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA";
		for (String plaintext: args){
			char[] cText = new char[plaintext.length()];
			for (int i = 0; i < plaintext.length(); i++){
				char pT = plaintext.charAt(i);
				if (Character.isAlphabetic(pT)){
					cText[i] = ctAlphabet.charAt(pTAlphabet.indexOf(pT));
				} else {
					cText[i] = pT;
				}
			}
			
			System.out.println(new String(cText));
		}

	}

}
