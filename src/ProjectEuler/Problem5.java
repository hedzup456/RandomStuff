package ProjectEuler;

public class Problem5 {
	public static void main(String[] args){
		int n = 20;
		while(true){
			if(n%20==0 && n%19==0 && n%18==0 && n%17==0 && n%16==0 && n%15==0 && n%14==0 && n%13==0 && n%12==0 && n%11==0){
				System.out.println(n);
				break;
			} // End if
			n++;
		} // End while
	} // End main
} // End class
