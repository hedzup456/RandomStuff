package ProjectEuler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Problem19 {
	private static boolean firstIsSunday(int month, int year){
		String x = "01/" + month + "/" + year;
		Date t;
		SimpleDateFormat inFt = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			t = inFt.parse(x);
			System.out.println(t);
			SimpleDateFormat outFt = new SimpleDateFormat("E");
			return (outFt.format(t).equals("Sun"));
		} catch (ParseException e){ System.out.println("you fucked up");}
		return false;
	} // firstIsSunday
	
	public static void main(String[] args) {
		int noOfSundays = 0;
		for (int year = 1901; year <= 2000; year++){
			for (int month = 1; month <= 12; month++){
				if (firstIsSunday(month, year)){
					noOfSundays++;
				}
			} // month
		} // year
	System.out.println(noOfSundays);
	
	} // main
} // class
