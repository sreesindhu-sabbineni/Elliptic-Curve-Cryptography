package ecc;

import java.math.BigInteger;
import java.util.Random;

import ecc.*;

public class CheckAllFuncs {
public static long check(BigInteger[] a, BigInteger d, BigInteger p, BigInteger n) {
	//Random Number Generator for 'm'
	Random rand = new Random();
	BigInteger m = new BigInteger(n.bitLength(),rand).mod(n);
	BigInteger[] b = Exponentiation.exp(a, m, d, p);
	BigInteger[] value = PollardsRho.rho(a, b, d, p, n);
	//Exception Handling for rho method failure
	try {
		if(value[0].compareTo(m)==0) {
			
		}
	}
	catch(RuntimeException e) {
		System.out.println("m and m' are not equal");
		e.printStackTrace();
	}
	return value[1].longValue();
	
}
}
