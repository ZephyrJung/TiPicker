package org.b3log.zephyr.algorithm;

/**
 * Created by Zephyr on 2017/2/18.
 */
public class A05_DivideUsingSubtraction {

    public static void main(String[] args){
        System.out.println(new A05_DivideUsingSubtraction().divideIterative(10,7));
        System.out.println(new A05_DivideUsingSubtraction().divideRecursive(99,7));
    }

    public float divideIterative(int dividend, int divider) {
        validateInput(divider);
        float result = 0;
//        while (dividend > divider) {
//            dividend -= divider;
//            result++;
//        }
        float decimalPart = (float) dividend / (float) divider;
        result += decimalPart;
        return result;
    }

    public float divideRecursive(int dividend, int divider) {
        validateInput(divider);
        if (dividend == 0) {
            return 0f;
        } else if (dividend < divider) {
            return (float) dividend / (float) divider;
        } else {
            return 1f + divideRecursive(dividend - divider, divider);
        }
    }

    private void validateInput(int divider) {
        if (divider == 0) {
            throw new IllegalArgumentException(
                    "You can't divide using 0 as divider. That operation is not defined");
        }
    }
}
