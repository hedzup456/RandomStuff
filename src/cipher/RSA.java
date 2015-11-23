/**
 * 
 */
package cipher;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author Richard
 *
 */
public class RSA {
	private static BigInteger genPr(BigInteger e){
		BigInteger r = BigInteger.probablePrime(160, new Random());
		while (r.equals(e)) r = BigInteger.probablePrime(160,  new Random());
		return r;
	}
	
	private static BigInteger gcd(BigInteger a, BigInteger b){
		if(b.equals(BigInteger.ZERO)) return a;
		else return gcd(b, a.mod(b));
	}
	private static long encrypt(BigInteger publicKey, char P, BigInteger N){
		int Pt = ((int)P);
		BigInteger C = BigInteger.valueOf(Pt).modPow(publicKey, N);
		return C.intValue();
	}
	private static char decrypt(BigInteger privateKey, long C, BigInteger N){
		BigInteger P = BigInteger.valueOf(C).modPow(privateKey, N);
		int x = P.intValue();
		while(x > 90) x -= 90;
		while(x < 65) x += 65;
		return (char)x;
	}
	
	public static void main(String[] args) {
		BigInteger P = genPr(BigInteger.ZERO);
		BigInteger Q = genPr(P);
		
		BigInteger N = P.multiply(Q);
		BigInteger totient = (P.subtract(BigInteger.ONE)).multiply(Q.subtract(BigInteger.ONE));
		
		BigInteger publicKey = new BigInteger("0");
		if(BigInteger.valueOf(65537L).gcd(totient).equals(BigInteger.ONE)) publicKey = BigInteger.valueOf(65537L);
		else publicKey = BigInteger.valueOf(32377);
		
		BigInteger privateKey = gcd(publicKey, totient);
		
		
		long a = encrypt(publicKey, 'F', N);
		char b = decrypt(privateKey, a, N);
		System.out.println("" + a + " " + b);
	
		
	}
}
