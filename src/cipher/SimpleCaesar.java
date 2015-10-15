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
	


	
	public static void main(String[] args) {
		Utils u = new Utils();
		String cipherText = "LMIZ XPQT, \r\n" + 
				" \r\n" + 
				"PWE KWCTL Q XIAA CX BPM WXXWZBCVQBG BW EWZS WV BPQA? Q PIL I KZIKS IB IVWBPMZ WN BPM VWBMA GWC NWCVL QV UWVBUIZBZM. QB TWWSA TQSM BPM WTLMAB QBMU QV BPM XIKSMB IVL Q BPWCOPB QB UQOPB JM I OWWL XTIKM BW ABIZB. QB UISMA AWUM AMVAM WN BPM JCKPMVEITL ZMNMZMVKM QV BPM TIBMZ VWBM GWC AMVB. \r\n" + 
				" \r\n" + 
				"QB LQLV'B MFXTIQV BPM XIZQA TQVS AW Q AMVB I BMIU QVBW BPIB VMQOPJWCZPWWL BW OIBPMZ QVBMT JCB BPMG LQLV'B KWUM CX EQBP DMZG UCKP. EM LQL OMB WVM ZMXWZB BPIB BPM PWCAM PIL JMMV WEVML JG I OMZUIV NIUQTG JMNWZM BPM EIZ, JCB BPIB QB PIL JMMV BISMV WDMZ JG IV AA WNNQKMZ QV VQVMBMMV NWZBG WVM. ACZMBM ZMKWZLA ACOOMAB BPIB BPM NIUQTG KIUM NZWU EMQUIZ QV ICOCAB VQVMBMMV BPQZBG AMDMV, EPQKP QA ACOOMABQDM OQDMV BPM BQUQVO IVL BPM OMWOZIXPG, AW Q PIDM AMVB BPM BMIU BW JCKPMVEITL BW AMM EPIB BPMG KIV NQVL. \r\n" + 
				" \r\n" + 
				"Q IU RCUXQVO BW KWVKTCAQWVA PMZM, JCB BPM XWZBZIQB AIZIP UMVBQWVA PIA BW JM BPM UWVI TQAI. Q PIDM JMMV BZGQVO BW OMB IKKMAA BW QB, JCB BPM NZMVKP ICBPWZQBQMA IZM AXWWSML. BPM BPMNB WN BPM XIQVBQVO JG XMZCOOQI JIKS QV VQVMBMMV MTMDMV PIA UILM BPMU DMZG AMVAQBQDM. BPM VIUM KPICLZWV EIA UMVBQWVML UWZM BPIV WVKM, IVL Q VMML AWUM BQUM BW TWWS QVBW BPM PQABWZG. \r\n" + 
				" \r\n" + 
				"QN GWC PIDM IVG QVNTCMVKM IB ITT IB BPM UCAMCU Q BPQVS EM VMML I XZWXMZ MFIUQVIBQWV WN BPM XIQVBQVO, IVL Q VMML BW SVWE EPIB PIXXMVML BW QB LCZQVO BPM EIZ. \r\n" + 
				" \r\n" + 
				"ITT BPM JMAB, \r\n" + 
				" \r\n" + 
				"PIZZG\r\n";
		String saveLocation = ".\\src\\cipher\\Caesar\\" + cipherText.substring(0, 4) + ".txt";
		StringBuilder plainText = new StringBuilder();
		for(int key = 0; key < 26; key++){
			plainText.append(String.format("Key: " + key + "%n" + decrypt(cipherText, key) + "%n-_-%n"));
		}
		u.saveText(saveLocation, plainText.toString());
		System.out.print(u.findHarry(u.splitToPlainTexts(u.loadText(saveLocation))));
	}	
	

}
