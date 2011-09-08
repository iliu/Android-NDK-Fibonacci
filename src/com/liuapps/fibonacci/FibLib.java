package com.liuapps.fibonacci;

public class FibLib {
	public static long fibJ (long input) {
		if (input <= 0)
			return 0;
		if (input == 1)
			return 1;
		return fibJ(input-1) +fibJ(input-2);
	}

	public static long fibJI (long input) {
		long previous = -1;
		long result = 1;
		for ( int i = 0; i <= input; i++ ){
			long sum = result + previous; 
			previous = result;
			result = sum;
		}
		return result;
	}

	// Native implementation
	static {
		System.loadLibrary("fib");  
	}

	// Native implementation - recursive
	public static native long fibN(long n);  

	// Native implementation - iterative
	public static native long fibNI(long n);
}
