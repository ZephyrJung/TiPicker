package org.b3log.demo.algorithm;

/**
 * Created by Zephyr on 2017/2/18.
 * 计算二进制数字（字符串表示，位数需要一样）的和
 */
public class A03_SumBinaryNumbers {
    public static void main(String[] args){
        String n1="10101011";
        String n2="10101011";
        System.out.println(new A03_SumBinaryNumbers().sumBinaryNumbersCheating(n1,n2));
        System.out.println(new A03_SumBinaryNumbers().sumBinaryNumbersBasedOnPowersOfTwo(n1,n2));
    }

    public String sumBinaryNumbersCheating(String n1, String n2) {
        validateInput(n1, n2);

        int number1, number2;
        try {
            number1 = Integer.parseInt(n1, 2);
            number2 = Integer.parseInt(n2, 2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Error parsing input data, review your parameters, should be a valid binary number!");
        }
        int result = number1 + number2;
        return Integer.toBinaryString(result);
    }

    public String sumBinaryNumbersBasedOnPowersOfTwo(String n1, String n2) {
        validateInput(n1, n2);

        int result = 0;
        int length = Math.max(n1.length(), n2.length());
        for (int i = 0; i < length; i++) {
            result += getValueAt(n1, i) * Math.pow(2, length - i - 1);
            result += getValueAt(n2, i) * Math.pow(2, length - i - 1);
        }
        return Integer.toBinaryString(result);
    }

    private static int getValueAt(String binaryNumber, int index) {
        int value = binaryNumber.charAt(index) - 48;
        if (value < 0 || value > 1) {
            throw new IllegalArgumentException(
                    "Error parsing input data, review your parameters, should be a valid binary number!");
        }
        return value;
    }

    public String sumBinaryNumbersBasedOnCount(String n1, String n2) {
        validateInput(n1, n2);

        StringBuilder result = new StringBuilder();
        int lengthVal1 = n1.length();
        int lengthVal2 = n2.length();
        int length = Math.max(lengthVal1, lengthVal2);
        int carry = 0;
        int sum = 0;
        int remainder = 0;
        for (int i = 0; i < length; i++) {
            //This is a beautiful trick to avoid IndexOutOfBoundExceptions.
            int digit1 = i >= lengthVal1 ? 0 : n1.charAt(lengthVal1 - i - 1) - '0';
            int digit2 = i >= lengthVal2 ? 0 : n2.charAt(lengthVal2 - i - 1) - '0';

            if (digit1 < 2 && digit2 < 2) {
                sum = digit1 + digit2 + carry;
                carry = sum / 2;
                remainder = sum % 2;
                result.append((char) (remainder + '0'));
            } else {
                throw new IllegalArgumentException(
                        "Error parsing input data, review your parameters, should be a valid binary number!");
            }
        }
        if (carry != 0)
            result.append((char) (carry + '0'));
        return result.reverse().toString();
    }

    private void validateInput(String n1, String n2) {
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("n1 and n2 parameters can't be null");
        }
    }
}