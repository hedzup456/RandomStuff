package ProjectEuler;

public class Problem23 {
	private static boolean isAbundant(int seed){
		if (CommonMethods.sumOfDivisors(seed) > seed) return true;
		return false;
	}
	private static boolean[] genAbun(){
		boolean[] arr = new boolean[23123];
		for (int i = 0; i < 23123; i++){
			if (isAbundant(i+1)) arr[i] = true;
		}
		return arr;
	}
	private static int[] niceArray(boolean[] arr) {
		
		return new int[1];
	}
	
	public static void main(String[] args) {
		int total = 276;
		for(int tot = 25; tot < 28124; tot++){
			for(int num1 = 12; num1 < tot; num1++){
				for (int num2 = 12; num2 < tot; num2++){
					if(!(num1+num2 == tot && isAbundant(num1) && isAbundant(num2))) total += tot;
				}
			} // num 1 for
		} // tot for
		System.out.println(total);
	}

}
