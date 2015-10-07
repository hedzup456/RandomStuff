package ProjectEuler;

public class CommonMethods {
	public static long totalDigits(String str){
		long total = 0;
		for(int index = 0; index < str.length(); index++){
			total += Character.getNumericValue(str.charAt(index));
		}
		return total;
	}
	public static int charVal(char x){
		x = Character.toLowerCase(x);
		switch (x){
		case 'a':
			return 1;
			
		case 'b':
			return 2;
			
		case 'c':
			return 3;
			
		case 'd':
			return 4;
			
		case 'e':
			return 5;
			
		case 'f':
			return 6;
			
		case 'g':
			return 7;
			
		case 'h':
			return 8;
			
		case 'i':
			return 9;
			
		case 'j':
			return 10;
			
		case 'k':
			return 11;
			
		case 'l':
			return 12;
			
		case 'm':
			return 13;
			
		case 'n':
			return 14;
			
		case 'o':
			return 15;
			
		case 'p':
			return 16;
			
		case 'q':
			return 17;
			
		case 'r':
			return 18;
			
		case 's':
			return 19;
			
		case 't':
			return 20;
			
		case 'u':
			return 21;
			
		case 'v':
			return 22;
			
		case 'w':
			return 23;
			
		case 'x':
			return 24;
			
		case 'y':
			return 25;
			
		case 'z':
			return 26;
		
		default:
			return 0;
		}
	}
	public static int sumOfDivisors(int seed){
		int total = 0, limit = seed;
		 for(int i=1;i<limit;i++){
		        if(seed%i==0){
		            if(i!=1){
		                if(i != seed/i) total += (i + seed/i);
		                else total += i;
		            } else total += i;
		            limit = seed/i;
		        }
		    }       
		    return total;
	} // sumOfDivisors
}

