package ProjectEuler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "C:\\Users\\Richard\\workspace\\RandomStuff\\src\\ProjectEuler\\p022_names.txt";
		String line = null;
		
		
		try{
			FileReader fileReader = new FileReader(fileName);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			String[] names = line.split("\",\"");
			
			Arrays.sort(names);
			
			for(int i = 0; i < names.length; i++) System.out.println(names[i]);
			
			bufferedReader.close();
		} catch (FileNotFoundException e){
			System.out.println("Can't find");
		} catch (IOException ex){
			System.out.println("Can't read");
		}

	}

}
