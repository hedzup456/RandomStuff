package cipher;

public class FrequencyAnalysis {
	private void output(double[] freqPerc, String type){ // Just output the thingy to the console
		for (int i = 0; i < 36; i++) { // Output percentage values
			if(i%3 == 0 && i != 0) System.out.print("\n"); // newline
			if (i < 26) System.out.printf((char)(i+65) + ":%05.2f%s" + "  ", freqPerc[i], "%"); // output
			else System.out.printf("" + (i-26) + ":%05.2f%s" + "  ", freqPerc[i], "%");
		}
		System.out.println();
		System.out.println("Highest chance of E (" + type + "): " + mostFreq(freqPerc));
		System.out.println();
	}
	private int[] populateZero(int[] x){
		for(int i = 0; i < x.length; i++) x[i] = 0;
		return x;
	}
	private double[] populateZero(double[] x){
		for(int i = 0; i < x.length; i++) x[i] = 0.0;
		return x;
	}
	private char mostFreq(double[] rV){
		double high = 0.0;
		int highI = 0;
		for (int i = 0; i < 36; i++) {
			if(rV[i] > high) {
				high = rV[i];
				highI = i;
			}
		}
		if (highI < 26) return (char)(highI+65);
		else return (char)(highI+22); // '0' = 48 = 26+22. '1' = 49 = 27+22. Etc
	}	
	private double[] rawToPerc(int len, int[] freq){
		double[] p = populateZero(new double[36]);
		for (int i = 0; i < 36; i++) p[i] = 100.0*freq[i]/len; // Calc/store the percentage (100*[f/n] = 100f/n)
		return p;
	}
	
	public void singCharAnal(String ciph){
		int[] freqOfChars = populateZero(new int[36]);
		for (int i = 0; i < ciph.length(); i++) {
			// For every letter in the ciphertext, add one to it's value in the frequency total.
			char l = ciph.charAt(i);
			
			int charIndex;
			if (Character.isWhitespace(l)) continue;  // If the character is whitespace, continue the next iteration of the loop
			else if (Character.isAlphabetic(l)) charIndex = (int)l - 65; // 'A' = 65, we need 0
			else charIndex = Character.getNumericValue(l)+ 26; // '0' = 0, we need 26
			freqOfChars[charIndex] += 1;
		} // FOR
		output(rawToPerc(ciph.length(), freqOfChars), "single");
	}
	
	public void doubCharAnal(String ciph){
		int[] doubCharFreq = populateZero(new int[36]);
		int totOfDoubleChars = 0;
		for (int i = 0; i < ciph.length()-1; i++) {
			char c1 = ciph.charAt(i);
			char c2 = ciph.charAt(i+1);
			
			if (c1 == c2) {
				int xI;
				if (Character.isAlphabetic(c1)) xI = (int)c1 - 65; // 'A' = 65, we want 0
				else xI = Character.getNumericValue(c1); // '1' = 1
				
				doubCharFreq[xI]++;
				totOfDoubleChars++;
			}
		}
		output(rawToPerc(totOfDoubleChars, doubCharFreq), "double");
	}
}
