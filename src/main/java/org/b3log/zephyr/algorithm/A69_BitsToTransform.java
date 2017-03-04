package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-4.
 * 计算数字二进制形式不同的个数
 */
public class A69_BitsToTransform {
    public static void main(String[] args){
        int numA = 78; // 1001110
        int numB = 99; // 1100011

        int numberOfDifferentBits = new A69_BitsToTransform().calculate(numA, numB);

        System.out.println(numberOfDifferentBits);
    }

    public int calculate(int numA, int numB) {
        int differentBits = 0;
        for (int XOR = numA ^ numB; XOR != 0; XOR = XOR & (XOR - 1)) {
            differentBits++;
        }
        return differentBits;
    }
}
