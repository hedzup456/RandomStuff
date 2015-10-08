package ProjectEuler;

import java.math.BigInteger;

public class Problem25 {	
	public static void main(String[] args){
		BigInteger num = new BigInteger("2");
		BigInteger num1 = new BigInteger("1");
		BigInteger temp = new BigInteger("1");
		int index = 3;
		while(num.toString().length() < 1000){
			if(index < 10){
				System.out.println(num);
			}
			
			temp = num;
			num = num.add(num1);
			num1 = temp;
			
			index++;
		}
		System.out.println(index);
	}
}
