package ProjectEuler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Problem22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileAddr= "https://raw.githubusercontent.com/hedzup456/RandomStuff/master/src/ProjectEuler/p22_names.txt";
		String line = null;
		
		
		try{
			URL url = new URL(fileAddr);
			Scanner s = new Scanner(url.openStream());
			
			line = s.nextLine();
			line = line.replaceAll("\"", "");
			String[] names = line.split(",");
			System.out.println("Got text");
			Arrays.sort(names);

			s.close();
			
			long total = 0;
			for(int i = 0; i < names.length; i ++){
				int nameScore = 0;
				for(int j = 0; j < names[i].length(); j++){
					char x = names[i].charAt(j);
					nameScore += CommonMethods.getCharVal(x);
				} // for j
				nameScore = nameScore * (i+1);
				total += nameScore;
			} // for i
			System.out.println(total);
		} catch (MalformedURLException e){
			System.out.println("Oops.");
		} catch (IOException e){
			System.out.println("Oops.");
		}

	}

}
