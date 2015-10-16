package cipher;

public class FrequencyAnalysis {

	public static void main(String[] args) {
		String cipherText = "aaacccbbbqru";
		
		cipherText = cipherText.toUpperCase().replaceAll("\\s+", ""); // Make ciphertext uppercase, then remove whitespace
		int[] freqOfChars = new int[36]; // i.e,frequency of 'A' is in index 0, 'B' in 1, through to 'Z' in 25. 0 through 9 are 26 through 35 respectively.
		for (int i = 0; i < 36; i++) freqOfChars[i] = 0; // Populate with default 0
		
		for (int i = 0; i < cipherText.length(); i++) {
			// For every letter in the ciphertext, add one to it's value in the frequency total.
			char l = cipherText.charAt(i);
			int charIndex;
			if (Character.isAlphabetic(l)) charIndex = (int)l - 65; // 'A' = 65, we need 0
			else charIndex = Character.getNumericValue(l)+ 26; // '0' = 0, we need 26
			freqOfChars[charIndex] += 1;
		} // FOR
		for (int i = 0; i < 36; i++) { // Output raw values
			if(i%3 == 0 && i != 0) System.out.print("\n"); // newline
			if (i < 26) System.out.print((char)(i+65) + ":" + freqOfChars[i] + "  "); // output
			else System.out.print("" + (i-26) + ":" + freqOfChars[i] + "  ");
		}
		double[] percentFOC = new double[36]; // Same indexing system as the one above
		for (int i = 0; i < 36; i++) percentFOC[i] = 00.0; // Populate with default 0
		
		int len = cipherText.length();
		for (int i = 0; i < 36; i++) percentFOC[i] = 100.0*freqOfChars[i]/len; // Calc/store the percentage
		
		System.out.println();
		for (int i = 0; i < 36; i++) { // Output raw values
			if(i%3 == 0 && i != 0) System.out.print("\n"); // newline
			if (i < 26) System.out.print((char)(i+65) + ":" + percentFOC[i] + "%" + "  "); // output
			else System.out.print("" + (i-26) + ":" + percentFOC[i] +  "%" + "  ");
		}
	}

}
