package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-2-19.
 */
public class A26_Palindromes {

    public static void main(String[] args){
        System.out.println(new A26_Palindromes().evaluate("12321"));
        System.out.println(new A26_Palindromes().evaluate("123321"));
    }

    public boolean evaluate(String word) {
        if (word == null) {
            throw new IllegalArgumentException("You can't pass a null String as input.");
        }
        boolean result = true;
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                result = false;
                break;
            }
        }
        return result;
    }
}