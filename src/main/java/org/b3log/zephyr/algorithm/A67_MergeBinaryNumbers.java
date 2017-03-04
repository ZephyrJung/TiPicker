package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-4.
 */
public class A67_MergeBinaryNumbers {

    public static void main(String[] args){
        int n = 1024; //10000000000
        int m = 19; //10011

        int result = new A67_MergeBinaryNumbers().merge(n, m, 2, 6);

        System.out.println(result);
    }

    public int merge(int n, int m, int i, int j) {
        int maskFullOfOnes = ~0;

        int fullOfOnesBeforeJ = maskFullOfOnes << (j + 1);
        int fullOfOnesAfterI = ((1 << i) - 1);

        int allOnesExceptIandJ = fullOfOnesBeforeJ | fullOfOnesAfterI;

        int clearBitsBetweenIandJ = n & allOnesExceptIandJ;
        int moveMToTheCorrectPosition = m << i;

        return clearBitsBetweenIandJ | moveMToTheCorrectPosition;
    }
}
