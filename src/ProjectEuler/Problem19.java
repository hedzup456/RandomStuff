package ProjectEuler;
/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

Extra knowledge says that there are 365 days in a year, 366 in a leap year.


How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/
public class Problem19 {
	private static int lastDay(int lengthMonth, int startBefore){
		lengthMonth %= 7;
		lengthMonth += startBefore;
		lengthMonth--;
		return lengthMonth;
	} // lastDay
	
	private static int firstDay(int lastMonthEnd){
		if (lastMonthEnd == 6) lastMonthEnd = 0;
		else lastMonthEnd++;
		return lastMonthEnd;
	}
	
	private static boolean isLeap(int year){
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
			return true;
		}else{
			return false;
		} // if
	} // isLeap
	
	public static void main(String[] args) {
	/*	final int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		// 01011901 was tue
		int noOfSundays = 0, prevMonthLast = 1;
		for (int year = 1901; year <= 2000; year++){
			System.out.println(year);
			for (int month = 0; month < 12; month++){
				System.out.println(month);
				int monthI = month;
				if (month == 1 && isLeap(year)) monthI++; 
				int last = lastDay(daysInMonth[monthI], prevMonthLast);
				int first = firstDay(last);
				if(first == 6) noOfSundays++;
				prevMonthLast = last;
			} // month
		} // year
	System.out.println(noOfSundays);
	*/
		System.out.println(lastDay(31, 1));
		System.out.println(firstDay(lastDay(31, 1)));
	} // main
} // class
