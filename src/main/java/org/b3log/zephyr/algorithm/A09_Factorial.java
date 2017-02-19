package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-2-19.
 * 计算阶乘
 */
public class A09_Factorial {
    public static void main(String[] args){
        A09_Factorial factorial=new A09_Factorial();
        System.out.println(factorial.getIterative(5));
        System.out.println(factorial.getRecursive(5));
        System.out.println(factorial.getTailRecursive(5));
    }

    public int getIterative(int n) {
        validateInput(n);

        int result = 1;
        for (int i = n; i >= 2; i--) {
            result *= i;
        }
        return result;
    }

    public int getRecursive(int n) {
        validateInput(n);

        if (n == 0) {
            return 1;
        } else {
            return n * getRecursive(n - 1);
        }
    }

    public int getTailRecursive(int n) {
        validateInput(n);
        return getTailRecursiveInner(n, 1);
    }

    private int getTailRecursiveInner(int n, int acc) {
        if (n == 0) {
            return acc;
        } else {
            return getTailRecursiveInner(n - 1, acc * n);
        }
    }

    private void validateInput(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative numbers factorial is not defined.");
        }
    }
}