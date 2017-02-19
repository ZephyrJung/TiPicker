package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-2-19.
 * 判断两个字符串是否属于一个全排列组合中
 */
public class A29_AreAnagrams {

    public static void main(String[] args){
        System.out.println(new A29_AreAnagrams().check("abc","cba"));
    }

    public boolean check(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("You can't use null Strings as input.");
        }
        if (a.length() != b.length()) {
            return false;
        }
        int[] lettersA = getLettersAsArray(a);
        int[] lettersB = getLettersAsArray(b);

        int valuesA = getSumOfArray(lettersA);
        int valuesB = getSumOfArray(lettersB);

        return valuesA == valuesB;
    }

    private static int getSumOfArray(int[] array) {
        int count = 0;
        for (int n : array) {
            count += n;
        }
        return count;
    }

    private static int[] getLettersAsArray(String word) {
        int[] letters = new int[128];
        for (char c : word.toCharArray()) {
            letters[c] = letters[c] + 1;
        }
        return letters;
    }
}
