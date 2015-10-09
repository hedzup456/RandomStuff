package ProjectEuler;

public class Problem26 {
	public static int recurringLength(String str, int d){
		int length, trueLength= 0;
		for (length = 1; length < d; length++){
			boolean temp = false;
			for (int index = 0; index < str.length(); index++){
				if (index == length || index + length >= str.length()){
					break; // Break out of the index testing loop if the index has reached the length to test
				} // if
				temp = (str.charAt(index) == str.charAt(index + length));
			} // for index
			if(temp) trueLength = length;
		} // for length
		return trueLength;
	} // recurringLenth

	public static void main(String[] args) {
		int lim = 30, bestIndx = 0, bestRec = 0;
		int[] pr = CommonMethods.genPrimes(lim);
		for(int i = 0; i < pr.length; i++){ // for each prime
			String oneOvrI = Double.toString(1.0/pr[i]);
			int rec = recurringLength(oneOvrI, pr[i]);
			if(rec > bestRec){
				bestRec = rec;
				bestIndx = i;
			} // if
		} //for i
		System.out.println(pr[bestIndx]);
	} // Main method
} // Class
