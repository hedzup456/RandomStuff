package ProjectEuler;

public class Problem01 {
	public static void main(String[] args){
		int runningTotal = 0;
		for(int i = 0; i<=1000; i++){
			runningTotal = (i%3==0||i%5==0)?runningTotal+i:runningTotal;
		}// /for
		System.out.println(runningTotal);
	} // /main
} // /class
