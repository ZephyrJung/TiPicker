package org.b3log.demo.algorithm;

/**
 * Created by yaya on 17-2-19.
 */
public class A20_MultiplicationWithoutMultiply {

    public static void main(String[] args){
        System.out.println("3 * 5 = "+new A20_MultiplicationWithoutMultiply().calculate(3,5));
    }

    public int calculate(int n1, int n2) {
        int result = 0;
        boolean negative = (n1 < 0 && n2 >= 0) || (n2 < 0 && n1 >= 0);
        boolean positive = !negative;
        n1 = Math.abs(n1);
        for (int i = 0; i < n1; i++) {
            if (negative && n2 > 0 || positive && n2 < 0)
                result -= n2;
            else
                result += n2;
        }

        return result;
    }
}
