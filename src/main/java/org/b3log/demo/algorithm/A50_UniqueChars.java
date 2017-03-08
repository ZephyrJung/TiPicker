package org.b3log.demo.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaya on 17-2-26.
 * 判断单词是否无重复字母
 */
public class A50_UniqueChars {

    public  static void main(String[] args){
        System.out.println(new A50_UniqueChars().evaluate2("pedro"));
        System.out.println(new A50_UniqueChars().evaluate("pedroe"));
    }

    public boolean evaluate(String input) {
        validateInput(input);

        Set<Integer> charsCounter = new HashSet<Integer>();
        for (char c : input.toCharArray()) {
            if (charsCounter.contains((int) c)) {
                return false;
            } else {
                charsCounter.add((int) c);
            }
        }
        return true;
    }

    public boolean evaluate2(String input) {
        validateInput(input);

        int[] chars = new int[256];
        for (char c : input.toCharArray()) {
            if (chars[c] >= 1) {
                return false;
            } else {
                chars[c]++;
            }
        }
        return true;
    }

    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("You can't pass a null instance as parameter.");
        }
    }
}