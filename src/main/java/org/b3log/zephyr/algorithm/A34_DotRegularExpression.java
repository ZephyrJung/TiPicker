package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zephyr on 2017/2/21.
 */
public class A34_DotRegularExpression {

    public static void main(String[] args){
        String pattern = "p.d";
        String[] words = { "pod", "pid", "pat", "por", "pwd" };

        String[] result = new A34_DotRegularExpression().evaluate(words, pattern);
        PrintUtil.printArray(result);
    }

    public String[] evaluate(String[] words, String pattern) {
        if (words == null || pattern == null) {
            throw new IllegalArgumentException("You can't pass null objects as input.");
        }
        List<String> result = new ArrayList<String>();
        for (String word : words) {
            if (matchDotRegularExpression(word, pattern)) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    private static boolean matchDotRegularExpression(String word, String pattern) {
        if (Math.abs(word.length() - pattern.length()) > 1) {
            return false;
        } else if (word.isEmpty() && pattern.isEmpty()) {
            return true;
        } else if (pattern.charAt(0) == '.') {
            return matchDotRegularExpression(word.substring(1), pattern.substring(1));
        } else {
            boolean partialMatch = word.charAt(0) == pattern.charAt(0);
            return partialMatch && matchDotRegularExpression(word.substring(1), pattern.substring(1));
        }
    }
}
