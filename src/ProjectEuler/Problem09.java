package ProjectEuler;

public class Problem09 {
	public static void pythagTrip(){
		int m, n, a = 0, b = 0, c = 0, sum = 0;
		int product = 0;
		
		for (m=2; m < 100; m++){
			for (n = 1; n < 100; n++){
				while(m > n){
					a = (m*m) - (n*n);
					b = (2*m) * n;
					c = (m*m) + (n*n);
					
					sum = a + b + c;
					
					if(sum==1000){
						product = a*b*c;
						
						System.out.println(a + ", " + b + ", " + c);
						System.out.println(product);
						break;
					} // if
					break;
				}// while
			} // n for
		} // m for
	} //pythagTrip

	public static void main(String[] args) {
		pythagTrip();
	} // Main
} // Class
