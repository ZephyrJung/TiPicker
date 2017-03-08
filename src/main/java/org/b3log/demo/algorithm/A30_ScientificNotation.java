package org.b3log.demo.algorithm;

/**
 * Created by yaya on 17-2-19.
 */
public class A30_ScientificNotation {

    public static void main(String[] args){
        System.out.println(new A30_ScientificNotation().calculate("9.18E+09"));
    }

    public long calculate(String number) {
        if (number == null || !number.contains("E")) {
            throw new IllegalArgumentException("Invalid format for number " + number);
        }
        String[] splittedNumber = splitScientificNumber(number);
        double first = getLeftPart(splittedNumber[0]);
        int sign = getNumberSign(splittedNumber[1]);
        int pow = getPow(splittedNumber[1]);
        Double result = sign * first * Math.pow(10, pow);
        return result.longValue();
    }

    private int getPow(String s) {
        return Integer.parseInt(s.substring(1, s.length()));
    }

    private int getNumberSign(String s) {
        return s.charAt(0) == '+' ? 1 : -1;
    }

    private double getLeftPart(String s) {
        return Double.parseDouble(s);
    }

    private String[] splitScientificNumber(String number) {
        return number.split("E");
    }
}
