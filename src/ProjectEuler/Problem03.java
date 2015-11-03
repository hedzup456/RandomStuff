package ProjectEuler;

public class Problem03 {
	public static int primeFactor(long number){
		int i; // So declared out of loop so returnd out of loop
		for (i=2; i<=number; i++){
			if (number % i ==0){
				number = number / i;
				i--;
			} //if
		} // for
		return i;
	} // primeFactor
	public static void main(String[] args){
		System.out.println(primeFactor(600851475143L));
	} // main
} // class
