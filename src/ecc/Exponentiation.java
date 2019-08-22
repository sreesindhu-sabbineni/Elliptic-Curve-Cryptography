package ecc;

import java.math.BigInteger;
import ecc.MultiplyTwoPoints;

/**
 * EXPONENTIATION ALGORITHM
 * computes and returns curve point b as a BigInteger array
**/

public class Exponentiation {
	public static BigInteger[] exp(BigInteger[] a, BigInteger m, BigInteger d, BigInteger p) {
		BigInteger[] b = new BigInteger[2];
		b[0]=BigInteger.ONE;
		b[1]=BigInteger.ZERO;
		for(int i=m.bitLength()-1;i>=0;i--)
		{
			b=MultiplyTwoPoints.mul(b, b, d, p);
			if(m.testBit(i))
			{
				b=MultiplyTwoPoints.mul(b, a, d, p);
			}
		}
		return b;
	}

}
