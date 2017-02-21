package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zephyr on 2017/2/21.
 */
public class A35_AsteriskRegularExpression {

    public static void main(String[] args){
        String pattern = "p*d";
        String[] words = { "posd", "pisdfd", "pat", "pdor", "pwdd" };

        String[] result = new A35_AsteriskRegularExpression().evaluate(words, pattern);
        PrintUtil.printArray(result);
    }

    public String[] evaluate(String[] words, String pattern) {
        if (words == null || pattern == null) {
            throw new IllegalArgumentException("You can't use null instances as input.");
        }

        List<String> result = new LinkedList<String>();
        for (String word : words) {
            if (matchAsteriskRegularExpression(word, pattern)) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    private static boolean matchAsteriskRegularExpression(String word, String pattern) {
        if (word.isEmpty() && pattern.isEmpty()) {
            return true;
        } else if (word.isEmpty() || pattern.isEmpty()) {
            return false;
        } else if (pattern.charAt(0) == '*') {
            boolean matchRestOfWord = matchAsteriskRegularExpression(word.substring(1), pattern);
            boolean matchRestOfPattern = matchAsteriskRegularExpression(word, pattern.substring(1));
            return matchRestOfWord || matchRestOfPattern;
        } else {
            boolean partialMatch = word.charAt(0) == pattern.charAt(0);
            return partialMatch && matchAsteriskRegularExpression(word.substring(1),
                    pattern.substring(1));
        }
    }
}
