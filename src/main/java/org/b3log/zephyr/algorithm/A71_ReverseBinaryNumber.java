package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-4.
 */
public class A71_ReverseBinaryNumber {

    private A70_ReverseOrderOfBinaryNumber reverseOrder;

    public A71_ReverseBinaryNumber() {
        reverseOrder = new A70_ReverseOrderOfBinaryNumber();
    }

    public static void main(String[] args){
        int input = 63; // 111111

        int result = new A71_ReverseBinaryNumber().reverse(input);

        System.out.println(result);
    }

    public int reverse(int input) {
        int result = 1;
        do {
            result <<= 1;
            result |= (input & 1) == 1 ? 0 : 1;
            input >>= 1;
        } while (input != 0);
        result = reverseBitsOrder(result);
        result = removeFirstOne(result);
        return result;
    }

    private int removeFirstOne(int number) {
        return number >> 1;
    }

    private int reverseBitsOrder(int number) {
        return reverseOrder.reverse(number);
    }
}
