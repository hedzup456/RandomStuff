package dailyProgrammer;

import java.util.Arrays;
import java.util.Collections;

/*
 * 	Daily Programmer tasks
 * 	2015-12-28
 * 	https://redd.it/3yiy2d
 */

public class challenge247 {
	private static boolean arrayConString(String[] a, String s){
		for (String ss: a) if (ss.equals(s)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		String[][] names = {
				{"Sean"},
				{"Winnie"},
				{"Brian", "Amy"},
				{"Samir"},
				{"Joe", "Bethany"},
				{"Bruno", "Anna", "Matthew", "Lucas"},
				{"Gabriel", "Martha", "Philip"},
				{"Andre"},
				{"Danielle"},
				{"Leo", "Christina"},
				{"Paula"},
				{"Mary", "Jane"},
				{"Anderson"},
				{"Priscilla"},
				{"Regis", "Julianna", "Arthur"},
				{"Mark", "Marina"},
				{"Alex", "Andrea"}
		};
		String[] givers = new String[30];
		String[] recievers = new String[30];
		int g = 0;
		for (String[] a: names)	for (String s: a){
				givers[g] = s;
				g++;
		}
		recievers = givers.clone();
		boolean goAgain = true;
		while (goAgain){
			goAgain = false;
			Collections.shuffle(Arrays.asList(recievers));
			for(int i = 0; i < givers.length; i++) for(String[] a:names){
				if (arrayConString(a, givers[i]) && arrayConString(a, recievers[i])) goAgain = true;
			}
		}
		for(int i = 0; i < givers.length; i++){
			System.out.println(givers[i] + " -> " + recievers[i]);
		}
	}

}
