package org.b3log.demo.algorithm;

import org.b3log.zephyr.util.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaya on 17-2-19.
 * 字符串字符全排列
 */
public class A25_Anagrams {
    public static void main(String[] args){
        A25_Anagrams anagrams=new A25_Anagrams();
        String input = "abcd";
        List<String> result = anagrams.get(input);
        PrintUtil.printList(result);
    }
    public List<String> get(String input) {
        List<String> result = null;
        if (input == null) {
            throw new IllegalArgumentException("You can't pass a null String as input.");
        } else if (input.isEmpty()) {
            result = new LinkedList<String>();
        } else {
            result = getAnagramsInner("", input);
        }
        return result;
    }

    private List<String> getAnagramsInner(String prefix, String word) {
        List<String> anagrams = new LinkedList<String>();
        int n = word.length();
        if (n == 0) {
            anagrams.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                //Add the old prefix the new letter
                String newPrefix = prefix + word.charAt(i);
                //Skip the current letter for the next word
                String newWord = word.substring(0, i) + word.substring(i + 1, n);
                anagrams.addAll(getAnagramsInner(newPrefix, newWord));
            }
        }
        return anagrams;
    }
}
