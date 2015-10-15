/**
 * 
 */
package cipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Richard
 *
 */
public class Utils {

	public String loadText(String fileLoc) {
		/* 
		 * Open the file passed to it
		 * Search in the file for "Harry", "harry", or "HARRY"
		 * Output the one with the correct message 
		 */
		
		File file = new File(fileLoc);
		StringBuilder fileContents = new StringBuilder();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				fileContents.append(line + "\n");
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Can't open");
		} catch (IOException e) {
			System.out.println("Can't read");
		}
		return fileContents.toString();
	}
	public void saveText(String location, String text) {
		/*
		 * Write text passed as an argument to a file,
		 * file given as an argument.
		 */
		try {
			File file = new File(location);

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String[] splitToPlainTexts(String fileContents){
		return fileContents.split("\n-_-");
	}
	public String findHarry(String[] plainTexts) {
		String harry = "";
		for(int i = 0; i < plainTexts.length; i++) {
			String p = plainTexts[i];
			int len = plainTexts[i].length();
			if(len > 1) {
				String ss = p.substring(len-6, len-1).toUpperCase();
				if(ss.equals("HARRY")) harry = p;
			}
		}
		return harry;
	}
}
