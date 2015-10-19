package cipher;

public class FrequencyAnalysis {

	public static void main(String[] args) {
		String cipherText = "WT MCI KOBH HC YBCK HVS GSQFSH CT HVS FOHZWBSG W AOM PS OPZS HC VSZD PIH HVS DFWQS KWZZ PS VWUV OBR WG BCH BSUCHWOPZS ZWTS VSFS WB PSFZWB VOG ZCGH WHG ZIGHFS OBR W KOBH GOBQHIOFM WB O ACFS QCBUSBWOZ QZWAOHS KWHV GSQIFWHM TCF AM TIHIFS W QOB DFCJWRS RSHOWZG CT DSFGCBBSZ DCZWQM GSQIFWHM OBR FCIHSG OBR QOB TIFBWGV MCI KWHV RCQIASBHOFM SJWRSBQS CT HVS FSOQV CT HVS CFUOBWNOHWCB HVS FSWQVGRCYHCF ";
		
		cipherText = cipherText.toUpperCase(); // Make ciphertext uppercase
		System.out.println("Ciphertext: " + cipherText);
		
		 // Single character only
		int[] freqOfChars = new int[36]; // i.e,frequency of 'A' is in index 0, 'B' in 1, through to 'Z' in 25. 0 through 9 are 26 through 35 respectively.
		for (int i = 0; i < 36; i++) freqOfChars[i] = 0; // Populate with default 0
		
		for (int i = 0; i < cipherText.length(); i++) {
			// For every letter in the ciphertext, add one to it's value in the frequency total.
			char l = cipherText.charAt(i);
			
			int charIndex;
			if (Character.isWhitespace(l)) continue;  // If the character is whitespace, continue the next iteration of the loop
			else if (Character.isAlphabetic(l)) charIndex = (int)l - 65; // 'A' = 65, we need 0
			else charIndex = Character.getNumericValue(l)+ 26; // '0' = 0, we need 26
			freqOfChars[charIndex] += 1;
		} // FOR

		double[] percentFOC = new double[36]; // Same indexing system as the one above
		for (int i = 0; i < 36; i++) percentFOC[i] = 00.0; // Populate with default 0
		
		int len = cipherText.length();
		for (int i = 0; i < 36; i++) percentFOC[i] = 100.0*freqOfChars[i]/len; // Calc/store the percentage
		
		for (int i = 0; i < 36; i++) { // Output percentage values
			if(i%3 == 0 && i != 0) System.out.print("\n"); // newline
			if (i < 26) System.out.printf((char)(i+65) + ":%05.2f%s" + "  ", percentFOC[i], "%"); // output
			else System.out.printf("" + (i-26) + ":%05.2f%s" + "  ", percentFOC[i], "%");
		}
		double high = 0.0;
		int highI = 0;
		for (int i = 0; i < 36; i++) {
			if(percentFOC[i] > high) {
				high = percentFOC[i];
				highI = i;
			}
		}
		System.out.println();
		String p;
		if (highI < 26) p = "" + (char)(highI+65);
		else p = "" + (highI-26);
		System.out.println("Most likely to be E: " + p);
		System.out.println("For a pure transposition cipher they key is likely to be " + ((int)p.charAt(0) - (int)'E'));
		
		// Single character analysis only.
		
		
		// Double characters
		
		int[] freqOfDoubChar = new int[36];
		for (int i = 0; i < 36; i++) freqOfDoubChar[i] = 0; // Populate array with 0.
		
		int totDoubChar = 0; // Stores the number of double characters
		for (int i = 0; i < cipherText.length()-1; i++) {
			char c1 = cipherText.charAt(i);
			char c2 = cipherText.charAt(i+1);
			
			System.out.println(c1 + "+" + c2);
			if (c1 == c2) {
				int xI;
				if (Character.isAlphabetic(c1)) xI = (int)c1 - 65; // 'A' = 65, we want 0
				else xI = Character.getNumericValue(c1); // '1' = 1
				
				freqOfDoubChar[xI]++;
				totDoubChar++;
			}
		}
		
		for (int i = 0; i < 36; i++) percentFOC[i] = 100.0*freqOfDoubChar[i]/totDoubChar; // Calc/store the percentage
		
		System.out.println();
		System.out.println("Double Character percentages: ");
		for (int i = 0; i < 36; i++) { // Output percentage values
			if(i%3 == 0 && i != 0) System.out.print("\n"); // newline
			if (i < 26) System.out.printf("" + ((char)(i+65)) + ((char)(i+65)) + ":%05.2f%s" + "  ", percentFOC[i], "%"); // output
			else System.out.printf("" + (i-26) + (i-26) + ":%05.2f%s" + "  ", percentFOC[i], "%");
		}
		
		
	}

}
