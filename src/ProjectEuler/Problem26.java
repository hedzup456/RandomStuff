package ProjectEuler;

public class Problem26 {
	/*public static int recurringLength(String str, int d){
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
*/
	// Not my solution. Taken from
	// http://www.programminglogic.com/solution-to-problem-26-on-project-euler/
	// Adapted from C to Java
	public static void main(String[] args){
  int i,value,max,counter,max2,z;
  max=0;
  max2 = Integer.MIN_VALUE;
  for (i=7;i<1000;i++){
    counter=0;
    value = 10%i;
    z=1000;
    while (value != 1 && z>0){
      value = value *10;
      value = value % i;
      counter++;
      z--;
    }
    if (counter>max && z>1){
      max=counter;
      max2=i;
    }
  }
  System.out.printf("%d\n",max2);
}
} // Class
