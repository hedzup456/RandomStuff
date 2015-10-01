package ProjectEuler;

public class CommonMethods {
	public static long totalDigits(String str){
		long total = 0;
		for(int index = 0; index < str.length(); index++){
			total += Character.getNumericValue(str.charAt(index));
		}
		return total;
	}
}
