package ProjectEuler;

public class Problem36 {
	private static String reverse(String s){
		return new StringBuilder(s).reverse().toString();
	}
	
	public static void main(String[] args) {
		int runTot = 0;
		for (int i = 0; i <= 1000000; i++){
			String iS = Integer.toString(i);
			String iSB = Integer.toBinaryString(i);
			if (iS.equals(reverse(iS)) && iSB.equals(reverse(iSB))) runTot += i;
		}
		System.out.println(runTot);
	}
}