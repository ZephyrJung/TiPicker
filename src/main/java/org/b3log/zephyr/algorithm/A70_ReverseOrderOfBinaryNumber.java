package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-4.
 */
public class A70_ReverseOrderOfBinaryNumber {
    public static void main(String[] args){
        int input = 13; // 1101
        int result = new A70_ReverseOrderOfBinaryNumber().reverse(input);
        System.out.println(result);
    }
    public int reverse(int number) {
        int result = 0;
        while (number != 0) {
            result <<= 1;
            result |= number & 1;
            number >>= 1;
        }
        return result;
    }
}
