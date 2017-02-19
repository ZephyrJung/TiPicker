package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-2-19.
 * 整数转换为字符串
 */
public class A11_IntToString {

    public static void main(String[] args){
        System.out.println(new A11_IntToString().transform(-23423));
    }

    public String transform(int number) {
        boolean isNegative = false;
        StringBuilder sb = new StringBuilder();
        if (number == 0) {
            return "0";
        } else if (number < 0) {
            isNegative = true;
        }
        number = Math.abs(number);

        while (number > 0) {
            sb.append(number % 10);
            number /= 10;
        }

        if (isNegative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}