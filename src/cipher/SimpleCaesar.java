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
		if (key < 0) key += 26;
		StringBuilder cipherText = new StringBuilder();
		plainText = plainText.toUpperCase();
		for(int i = 0; i < plainText.length(); i++){
			char p = plainText.charAt(i);
			char r = p;
			if(Character.isAlphabetic(p)){
				r = (char)(p + key);
				if(r < (int)'A') r -= 26;
				
			}
			cipherText.append(r);
		}
		return cipherText.toString();
	}
	private static int getKey(String pt){
		String keyLine = pt.split("\\r?\\n")[1];
		char c = keyLine.charAt(keyLine.length()-1);
		return Character.getNumericValue(c);		
	}
	
	public static void main(String[] args) {
		Utils u = new Utils();
		String cipherText = "";
		cipherText = "NALKN PKJPD APNKF WJLNK FAYPD WREJC ZNQCC AZPDA YNASS ASANA WXHAP KPWGA PDAOD ELSEP DAOOA JPEWH HUJKN AOEOP WJYAP DAYNA SSANA DWJZA ZPKPD AOKIW HELEN WPAOW PPDAZ AALSW PANNA JZAVR KQOWO LHWJJ AZWJZ SAXAC WJPDA OQNRA UFQOP WBPAN IEZJE CDPPD ANWZW NODKS AZWJW LLNKW YDEJC RAOOA HSDEY DKQNZ WPWXW OAEZA JPEBE AZWOW YKWOP CQWNZ YQPPA NSADA WZAZO KQPDP KWRKE ZZAPA YPEKJ SEPDW HHODE LHECD POKBB SAPDA JYKIL HAPAZ PDAOQ NRAUE JPDAJ ASHKY WPEKJ WBPAN ZWSJS EPDPD AHEOP AJEJC LKOPE JOPWH HAZSA XACWJ WOOAI XHEJC PDAAM QELIA JPBKN LDWOA PSKKB PDAKL ANWPE KJGAA LEJCW SWPYD BKNBQ NPDAN LWPNK HOEJP DAOGU WJZKJ PDASW PAN";
		//String saveLocation = ".\\src\\cipher\\Caesar\\" + cipherText.substring(0, 4) + ".txt";
		StringBuilder plainText = new StringBuilder();
		plainText.append("%n");
		System.out.println(decrypt(cipherText, -4));
		
		//for(int key = 0; key < 26; key++){
		//	plainText.append(String.format("Key: " + key + "%n" + decrypt(cipherText, key) + "%n-_-%n"));
		//}
		//u.saveText(saveLocation, plainText.toString());
		//String harryPT = u.findHarry(u.splitToPlainTexts(u.loadText(saveLocation)));
		
	}	
	

}
