package ecc;

import java.math.BigInteger;
import ecc.*;

/**
 * POLLARD'S RHO ALGORITHM
 * for DISCRETE LOGARITHM PROBLEM 
 * computes the value of m given 2 points on the curve a, b where b=a^m.
 */

public class PollardsRho {
	public static BigInteger[] rho(BigInteger[] a, BigInteger[] b, BigInteger d, BigInteger p, BigInteger n)
	{
		BigInteger alphak,betak,alpha2k,beta2k;
		BigInteger[] value = new BigInteger[2];
		BigInteger[] zk = new BigInteger[2]; //point on the curve
		BigInteger[] z2k =  new BigInteger[2]; //z2k traverses twice as fast as zk
		BigInteger[] z0 = new BigInteger[2];
		alphak=BigInteger.ZERO;
		betak=BigInteger.ZERO;
		alpha2k=BigInteger.ZERO;
		beta2k=BigInteger.ZERO;
		z0[0]=BigInteger.ZERO;
		z0[1]=BigInteger.ONE;
		zk=z0;
		z2k=z0;
		value[1]=BigInteger.ZERO;
		BigInteger THREE=BigInteger.valueOf(3);
		while(true) {
		switch(zk[0].mod(THREE).intValue())
		{
		case 0:
		{
			zk=MultiplyTwoPoints.mul(b, zk, d, p);
			alphak=alphak.add(BigInteger.ONE);
			betak=betak;
			break;
		}
		case 1:
		{
			zk=MultiplyTwoPoints.mul(zk, zk, d, p);
			alphak=BigInteger.valueOf(2).multiply(alphak);
			betak=BigInteger.valueOf(2).multiply(betak);
			break;
		}
		case 2:
		{
			zk=MultiplyTwoPoints.mul(a, zk, d, p);
			alphak=alphak;
			betak=betak.add(BigInteger.ONE);
			break;
		}
		}
		for(int j=0; j<2; j++) {
		switch(z2k[0].mod(THREE).intValue()) {
		case 0:
		{
			z2k=MultiplyTwoPoints.mul(b, z2k, d, p);
			alpha2k=alpha2k.add(BigInteger.ONE);
			beta2k=beta2k;
			break;
		}
		case 1:
		{
			z2k=MultiplyTwoPoints.mul(z2k, z2k, d, p);
			alpha2k=BigInteger.valueOf(2).multiply(alpha2k);
			beta2k=BigInteger.valueOf(2).multiply(beta2k);
			break;
		}
		case 2:
		{
			z2k=MultiplyTwoPoints.mul(a, z2k, d, p);
			alpha2k=alpha2k;
			beta2k=beta2k.add(BigInteger.ONE);
			break;
		}
		}
		}
		value[1]=value[1].add(BigInteger.ONE);
		try {
		if((zk[0].compareTo(z2k[0])==0)&&zk[1].compareTo(z2k[1])==0) {
			BigInteger deno = (alphak.subtract(alpha2k)).modInverse(n);
			value[0]=((beta2k.subtract(betak)).multiply(deno)).mod(n);
			break;
		}
		}
		catch(ArithmeticException e) {
			System.out.println("The value of denominator is zero! Can't divide by zero!!");
			e.printStackTrace();
		}
		
		}
		return value;
	}


}
