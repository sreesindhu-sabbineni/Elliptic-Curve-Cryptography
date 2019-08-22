package ecc;

import java.math.BigInteger;

/**
 * MULTIPLICATION ALGORITHM
 * Computes the multiplication of two points on the curve and returns the resultant curve point as a BigInteger array
 */

public class MultiplyTwoPoints {
	
	public static BigInteger[] mul(BigInteger[] a1, BigInteger[] a2, BigInteger d, BigInteger p )
	{
		BigInteger num1, den1,inv1,num2,den2,inv2;
		BigInteger[] a3 = new BigInteger[2];
		num1=(a1[0].multiply(a2[1])).add(a1[1].multiply(a2[0]));
		den1=((BigInteger.ONE).add(d.multiply(a1[0]).multiply(a2[0]).multiply(a1[1]).multiply(a2[1])));
		inv1=den1.modInverse(p);
		a3[0]=(num1.multiply(inv1)).mod(p);
		num2=(a1[1].multiply(a2[1])).subtract((a1[0].multiply(a2[0])));
		den2=((BigInteger.ONE).subtract(d.multiply(a1[0]).multiply(a2[0]).multiply(a1[1]).multiply(a2[1])));
		inv2=den2.modInverse(p);
		a3[1]=(num2.multiply(inv2)).mod(p);
		return a3;
	}
	
}
