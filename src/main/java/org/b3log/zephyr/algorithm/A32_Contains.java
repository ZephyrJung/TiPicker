package org.b3log.zephyr.algorithm;

/**
 * Created by Zephyr on 2017/2/21.
 */
public class A32_Contains {
    public static void main(String[] args){
        String word1 = "drso";
        String word2 = "Pedro";

        boolean result = new A32_Contains().evaluate(word1, word2);
        System.out.println(result);
    }

    public boolean evaluate(String w1, String w2) {
        if (w1 == null || w2 == null) {
            throw new IllegalArgumentException("You can't pass null strings as input.");
        }
        boolean contains = false;
        for (int i = 0; i < w2.length() - 1; i++) {
            if (w2.charAt(i) == w1.charAt(0)) {
                for (int j = 0; j < w1.length(); j++) {
                    if ((i + j) < w2.length() && w1.charAt(j) == w2.charAt(i + j) && j == w1.length() - 1) {
                        contains = true;
                        break;
                    }
                }
            }
        }
        return contains;
    }
}
