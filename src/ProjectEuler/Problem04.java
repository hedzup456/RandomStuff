package ProjectEuler;

public class Problem04 {
	public static boolean numTest(int number){
		String reverse = "";
		String string = Integer.toString(number);
		int length = string.length();
		for (int i = length-1; i>=0; i--){
			reverse=reverse+string.charAt(i);
		} // for
		return (string.equals(reverse))?true:false;
	} // numTest
	
	public static void main(String[] args){
		int ans = 0;
		for(int a=100;a < 1000; a++){
			for(int b=100;b < 1000; b++){
				ans = (numTest(a*b) && ans<a*b)?a*b:ans;
			} // for b
		} // for a
		System.out.println(ans);
	} // main
} // Class
