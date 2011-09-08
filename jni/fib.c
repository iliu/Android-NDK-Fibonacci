#include "com_liuapps_fibonacci_FibLib.h"

long fibN(long n) {
	if(n<=0) return 0;
	if(n==1) return 1;
	return fibN(n-1) + fibN(n-2);
}

long fibNI(long n) {
  long previous = -1;
  long result = 1;
  long i=0;
  int sum=0;
  for (i = 0; i <= n; i++) {
    sum = result + previous;
    previous = result;
    result = sum;
  }
  return result;
}

/* Signature of the JNI method as generated in header file  */
JNIEXPORT jlong JNICALL Java_com_liuapps_fibonacci_FibLib_fibN (JNIEnv *env, jclass obj, jlong  n) {
  return fibN(n);
}
/* Signature of the JNI method as generated in header file  */
JNIEXPORT jlong JNICALL Java_com_liuapps_fibonacci_FibLib_fibNI (JNIEnv *env, jclass obj, jlong  n) {
  return fibNI(n);
}
