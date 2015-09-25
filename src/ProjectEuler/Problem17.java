package ProjectEuler;
/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage
*/


public class Problem17 {
	public static String text = "";
	public static void digits(int x, int y, int z){
		switch (x){
		case 1:
			text += (y==z && z==0)?"onehundred":"onehundredand";
			break;
		case 2:
			text += (y==z && z== 0)?"twohundred":"twohundredand";
			break;
		case 3:
			text += (y==z && z== 0)?"threehundred":"threehundredand";			
			break;
		case 4:
			text += (y==z && z== 0)?"fourhundred":"fourhundredand";
			break;
		case 5:
			text += (y==z && z== 0)?"fivehundred":"fivehundredand";
			break;
		case 6:
			text += (y==z && z== 0)?"sixhundred":"sixhundredand";
			break;
		case 7:
			text += (y==z && z== 0)?"sevenhundred":"sevenhundredand";
			break;
		case 8:
			text += (y==z && z== 0)?"eighthundred":"eighthundredand";
			break;
		case 9:
			text += (y==z && z== 0)?"ninehundred":"ninehundredand";
			break;
		case 0:
			break;
		} // Case x	
		if(y == 1 && z!=0){
			switch(z){
			case 1:
				text += "eleven";
				break;
			case 2:
				text += "twelve";
				break;
			case 3:
				text += "thirteen";			
				break;
			case 4:
				text += "fourteen";
				break;
			case 5:
				text += "fifteen";
				break;
			case 6:
				text += "sixteen";
				break;
			case 7:
				text += "seventeen";
				break;
			case 8:
				text += "eighteen";
				break;
			case 9:
				text += "nineteen";
				break;
			} // Switch 
		} // If
		
		switch(y){
		case 2:
			text += "twenty";
			break;
		case 3:
			text += "thirty";
			break;
		case 4:
			text += "fourty";
			break;
		case 5:
			text += "fifty";
			break;
		case 6:
			text += "sixty";
			break;
		case 7:
			text += "seventy";
			break;
		case 8:
			text += "eighty";
			break;
		case 9:
			text += "ninety";
			break;
		} // Switch y
		} // digits
		
	public static void main(String[] args){
		// TODO Auto-generated method stub
		digits(1, 1, 2);
		System.out.println(text);
		
	}

} // class
