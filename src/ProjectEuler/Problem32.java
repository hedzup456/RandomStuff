package ProjectEuler;

import java.util.ArrayList;

public class Problem32 {	
	public static void main(String[] args) {		
		ArrayList<Integer> done = new ArrayList<Integer>();
		long sum = 0L;
		for (int a = 1; a < 10000; a++){
			for (int b = 1; b < 10000; b++){
				try{
					String n = "" + a + b + a*b;
					int res = a*b;
					if (n.length() == 9 && n.contains("1") && n.contains("2")
							&& n.contains("3") && n.contains("4") && n.contains("5") && n.contains("6") && n.contains("7") && n.contains("8") && n.contains("9")
							&& !done.contains(a*b)){
						done.add(res);
						sum += res;
					}
				} catch(NumberFormatException e){}
			}
		}
		System.out.println(sum);
	}
}
