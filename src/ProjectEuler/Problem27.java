package ProjectEuler;


public class Problem27 {

	public static void main(String[] args) {
		System.out.println("Working");
		// n^2 + an + b
		int numberOfConsecutivePrimes = 0, noConPrimea = 0, noConPrimeb = 0;
		for (int a = -1000; a <= 1000; a++) {
			for (int b = -1000; b <= 1000; b++) {
				int n = 0, count = 0;
				long result = (int)Math.pow(n, 2)+(a*n) + b;	
				while (CommonMethods.checkIfPrime(result)) {
					n++;
					count++;
					result = (int)Math.pow(n, 2)+(a*n) + b;
				}
				if (numberOfConsecutivePrimes < count) {
					numberOfConsecutivePrimes = count;
					noConPrimea = a;
					noConPrimeb = b;
				}
			}
		}
		System.out.println("a: " + noConPrimea + " b: " + noConPrimeb);
		System.out.println(noConPrimea*noConPrimeb);
	}
}
