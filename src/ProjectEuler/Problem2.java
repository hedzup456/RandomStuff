package ProjectEuler;

public class Problem2 {
	public static int fib(int n){
		return (n<=1)?n:(fib(n-1)+fib(n-2));
	} // End fib
	public static void main(String[] args){
		int highest, i, currFib, runTot;
		runTot = i = highest = 0;
		do{
			i++;
			highest = currFib = fib(i);
			runTot = (currFib%2==0)?runTot+currFib:runTot;
		}while(highest < 4000000); // End do/while
		System.out.println(runTot);
	} // End main
} // End class
