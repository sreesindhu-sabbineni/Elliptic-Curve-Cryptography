package ecc;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		long[] k = new long[1000];
		long sum = 0;
		for(int N=0;N<1000;N++) {
		
		BigInteger[] a = new BigInteger[2];
		
		/** Input set 1 values **/
//		a[0]=BigInteger.valueOf(12);
//		a[1]=BigInteger.valueOf(61833);
//		k[N]= CheckAllFuncs.check(a, BigInteger.valueOf(154), BigDecimal.valueOf(Math.pow(2, 16)-17).toBigInteger(), BigInteger.valueOf(16339));
		
		/** Input set 2 values **/
//		a[0] = BigInteger.valueOf(5);	
//		a[1] = BigInteger.valueOf(261901);
//		k[N]= CheckAllFuncs.check(a, BigInteger.valueOf(294), BigDecimal.valueOf(Math.pow(2, 18)-5).toBigInteger(), BigInteger.valueOf(65717));
		
		/** Input set 3 values **/
//		a[0]=BigInteger.valueOf(3); 
//		a[1]=BigInteger.valueOf(111745);
//		k[N]= CheckAllFuncs.check(a, BigInteger.valueOf(47), BigDecimal.valueOf(Math.pow(2, 20)-5).toBigInteger(), BigInteger.valueOf(262643));
		
		/** Input set 4 values **/
		a[0] = BigInteger.valueOf(4); 
		a[1] = BigInteger.valueOf(85081);
		k[N]= CheckAllFuncs.check(a, BigInteger.valueOf(314), BigDecimal.valueOf(Math.pow(2, 22) - 17).toBigInteger(), BigInteger.valueOf(1049497));
		
		}
	for(int i=0;i<k.length;i++) {
		sum = sum + k[i];
	}
	/*System.out.println(sum);*/
	System.out.println("Average number of steps, k = "+sum/k.length);
	
	}

}
