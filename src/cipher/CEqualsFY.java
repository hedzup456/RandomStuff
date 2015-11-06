package cipher;

public class CEqualsFY {
	public String genPlaintext(String cipherText, double a,  double b){
		StringBuilder pt = new StringBuilder();
		String letters = "abcdefghijklmnopqrstuvwxyz";
		
		for (int i = 0; i < cipherText.length(); i++){
			char C = cipherText.charAt(i);
			C = Character.toLowerCase(C);
			if(Character.isAlphabetic(C)){
				int Ci = letters.indexOf(C) + 1;
				int pi;
				do{
					double pd = Ci/a - b/a;
					pi = (int)pd;
					Ci += 26;
				} while(pi <= 0 || pi >= 26);
				pt.append("" + letters.charAt(pi-1));
			}
		}
		return pt.toString();
	}
	public String genCTAlphabet(String cipherText, double a, double b){
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder ciphertextAlphabet = new StringBuilder("                          ");
		int i = 0;
		while (ciphertextAlphabet.toString().indexOf(' ') != -1 && i < cipherText.length()){
			char C = cipherText.charAt(i);
			if (ciphertextAlphabet.indexOf(""+(getCharFromNum(getNumberOfLetter(C)))) != -1){
				i++;
				continue;
			} else {
				int numC = getNumberOfLetter(C);
				double pd;
				do{
					pd = numC/a - b/a;
					numC += 26;
				}while(pd%1 != 0);
				int nump = (int) pd-1;
				nump %= 26;
				char pTC = getCharFromNum(nump+1);
				ciphertextAlphabet.setCharAt(alphabet.indexOf(C), pTC);
				i++;
			}
		}
		return ciphertextAlphabet.toString();
	}
	private char getCharFromNum(int n){
		char r = ' ';
		switch (n){
		case  1: r ='a'; break;
		case  2: r ='b'; break;
		case  3: r ='c'; break;
		case  4: r ='d'; break;
		case  5: r ='e'; break;
		case  6: r ='f'; break;
		case  7: r ='g'; break;
		case  8: r ='h'; break;
		case  9: r ='i'; break;
		case 10: r ='j'; break;
		case 11: r ='k'; break;
		case 12: r ='l'; break;
		case 13: r ='m'; break;
		case 14: r ='n'; break;
		case 15: r ='o'; break;
		case 16: r ='p'; break;
		case 17: r ='q'; break;
		case 18: r ='r'; break;
		case 19: r ='s'; break;
		case 20: r ='t'; break;
		case 21: r ='u'; break;
		case 22: r ='v'; break;
		case 23: r ='w'; break;
		case 24: r ='x'; break;
		case 25: r ='y'; break;
		case 26: r ='z'; break;
		}
		return r;
	}
	private int getNumberOfLetter(char c){
		int r = -1;
		switch (Character.toLowerCase(c)){
		case 'a': r =  1; break;
		case 'b': r =  2; break;
		case 'c': r =  3; break;
		case 'd': r =  4; break;
		case 'e': r =  5; break;
		case 'f': r =  6; break;
		case 'g': r =  7; break;
		case 'h': r =  8; break;
		case 'i': r =  9; break;
		case 'j': r = 10; break;
		case 'k': r = 11; break;
		case 'l': r = 12; break;
		case 'm': r = 13; break;
		case 'n': r = 14; break;
		case 'o': r = 15; break;
		case 'p': r = 16; break;
		case 'q': r = 17; break;
		case 'r': r = 18; break;
		case 's': r = 19; break;
		case 't': r = 20; break;
		case 'u': r = 21; break;
		case 'v': r = 22; break;
		case 'w': r = 23; break;
		case 'x': r = 24; break;
		case 'y': r = 25; break;
		case 'z': r = 26; break;
		}
		return r;
	}
}
