package ProjectEuler;

public class Problem23 {
	private static boolean isAbundant(int seed){
		if (CommonMethods.sumOfDivisors(seed) > seed) return true;
		return false;
	}
	public static void main(String[] args) {
		

	}

}
