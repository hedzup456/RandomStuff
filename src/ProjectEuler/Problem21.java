package ProjectEuler;

public class Problem21 {
	private static int sumOfDivisors(int seed){
		int total = 0;
		for(int i = 1; i <= (seed/2); i++){
			if (seed%i == 0){
				total += i;
			}
		}
		return total;
	} // sumOfDivisors
	
	private static boolean isAmicable(int number){
		int sOD1 = sumOfDivisors(number);
		int sOD2 = sumOfDivisors(sOD1);
	
		if (sOD2 == number && sOD1 != sOD2) return true;
		return false;
	} // isAmicable
	
	public static void main(String[] args) {
		int total = 0;
		for (int i = 1; i < 10000; i++){
			if (isAmicable(i)) total += i;
		}
		System.out.println(total);
	} // main
} // class
