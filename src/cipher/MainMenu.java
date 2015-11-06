package cipher;

public class MainMenu {

	public static void main(String[] args) {
		FrequencyAnalysis FA = new FrequencyAnalysis();
		
		String cipherText = "";
		cipherText = "FBFXD"
				+  "YOBSH TDHSX DKLXD HSVFZ YQFSO ZYRZC ULVVF XXCDC UFSLC OZYFX XDHSV FXFFT XCDPD QBYLT FDKSF ZVUXA DJCDS SHXXZ LYZYC FSVFI CXXHP PFXCU LXQFF YXFFY ZYMZV ZYZCB DKHXF TQLXX BYDCV OFLSU DRCDT LJFAZ SFVCV DYCLV CLOXD YDCVO FLSRU BDHSH XKSZF YAXLS FJFFI ZYPCU ZXCDC UFTXF OMFXA FCLZO FAZYK DLQDH CSLCZ OZYFX ULSAC DDQCL ZYQHC UZPUM LOHFV DHOAO FLACD LSSFX CDKTL EDSCL SPFCX DKYHS FTQFS PZYMF XCZPL CZDYX MZCLO RFSFL VUSFZ VUXAD JCDSL CFLSO ZFXCD IIDSC HYZCB AZXVS FFCFY NHZSZ FXZYK SFYVU LYAHX XFVCD SXDYO BSFNH FXCKH YAXKD SKHSC UFSZY MFXCZ PLCZD Y"
				;
		
				
		cipherText = cipherText.toUpperCase(); // Make ciphertext uppercase
		System.out.println("Ciphertext: " + cipherText);
		
		 // Single character only
		//FA.singCharAnal(cipherText); 		
		
		// Double characters
		// FA.doubCharAnal(cipherText);
		
		CEqualsFY CE = new CEqualsFY();
		String p = CE.genCTAlphabet(cipherText, 5, 7);
		System.out.println("ABCDEFGHIJKLMNOPQRSTUVWNXYZ");
		System.out.println(p);
	}

}
