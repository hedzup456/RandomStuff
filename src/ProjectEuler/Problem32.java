package ProjectEuler;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem32 {
	private static byte[] splitDigits(long n){
		String ns = String.valueOf(n);
		int dig = ns.length();
		byte[] toR = new byte[dig];
		for(int i = 0; i < dig; i++){
			char c = ns.charAt(i);
			toR[i] = (byte)Character.getNumericValue(c);
		}
		return toR;
	}
	
	public static boolean checkPandigital(long n){
		byte[] digits = splitDigits(n);
		Arrays.sort(digits);
		if (digits.length != 9) return false;
		for(int i = 0; i < 9; i++) if (digits[i] == i+2) return false;
		return true;
	}
	
	private static boolean idUnique(int a, int b){
		byte[] adig = splitDigits(a);
		byte[] bdig = splitDigits(b);
		
		for (int aa = 0; aa < adig.length; aa++){
			for (int bb = 0; bb < bdig.length; b++){
				if (adig[aa] == bdig[bb]) return false; 
			}
		}
		return true;
	}
	
	public static void main(String[] args) {		
		ArrayList<Integer> done = new ArrayList<Integer>();
		ArrayList<Long> doneAll = new ArrayList<Long>();
		for (int a = 0; a < 10000; a++){
			for (int b = 0; b < 10000; b++){
				long n = Long.parseLong("" + a + b + a*b);
				int res = a*b;
				if (idUnique(a, b) && n > 12345688 && n < 987654322 && // first possible and last possible pandigital numbers
					!doneAll.contains(n) && checkPandigital(n)){ // done doesn't contain the result and whether it's pandigital
					done.add(res);
					doneAll.add(n);
					}
				}
			}
		long sum = 0L;
		for (int p: done){
			sum += p;
		}
		System.out.println(sum);
	
	}
}
