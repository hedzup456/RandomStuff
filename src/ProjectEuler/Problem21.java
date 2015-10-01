package ProjectEuler;

public class Problem21 {
	private static int sumOfDivisors(int seed){
		int total = 0;
		for(int i = 1; i < (seed/2); i++){
			if (seed%i == 0) total += i;
		}
		return total;
	} // sumOfDivisors
	public static void main(String[] args) {
		int total = 0;
		for(int number = 1; number < 10000; number++){
			int sOD = sumOfDivisors(number);
			if
		}
	}

}
