/**
 * 
 */
package cipher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class SimpleCaesar {
	private static String decrypt(String cipherText, int key){
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
		String cipherText = "WT MCI KOBH HC YBCK HVS GSQFSH CT HVS FOHZWBSG W AOM PS OPZS HC VSZD PIH HVS DFWQS KWZZ PS VWUV OBR WG BCH BSUCHWOPZS ZWTS VSFS WB PSFZWB VOG ZCGH WHG ZIGHFS OBR W KOBH GOBQHIOFM WB O ACFS QCBUSBWOZ QZWAOHS KWHV GSQIFWHM TCF AM TIHIFS W QOB DFCJWRS RSHOWZG CT DSFGCBBSZ DCZWQM GSQIFWHM OBR FCIHSG OBR QOB TIFBWGV MCI KWHV RCQIASBHOFM SJWRSBQS CT HVS FSOQV CT HVS CFUOBWNOHWCB HVS FSWQVGRCYHCF\r\n";
		String saveLocation = ".\\src\\cipher\\Caesar\\" + cipherText.substring(0, 4) + ".txt";
		StringBuilder plainText = new StringBuilder();
		plainText.append("%n");
		for(int key = 0; key < 26; key++){
			plainText.append(String.format("Key: " + key + "%n" + decrypt(cipherText, key) + "%n-_-%n"));
		}
		u.saveText(saveLocation, plainText.toString());
		String harryPT = u.findHarry(u.splitToPlainTexts(u.loadText(saveLocation)));
		
	}	
	

}
