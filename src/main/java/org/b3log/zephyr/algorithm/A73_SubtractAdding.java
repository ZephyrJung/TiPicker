package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-4.
 */
public class A73_SubtractAdding {
    public static void main(String[] args){
        int inputA = -30;
        int inputB = -35;

        int result = new A73_SubtractAdding().subtract(inputA, inputB);

        System.out.println(result);
    }
    public int subtract(int inputA, int inputB) {
        return inputA + negate(inputB);
    }

    private int negate(int number) {
        int increment = number > 0 ? -1 : 1;
        int result = 0;
        while (number != 0) {
            result += increment;
            number += increment;
        }
        return result;
    }
}
