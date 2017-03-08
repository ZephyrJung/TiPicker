package org.b3log.demo.algorithm;

/**
 * Created by Zephyr on 2017/2/21.
 */
public class A33_SimpleRegularExpression {

    public static void main(String[] args){
        String input = "aaa";
        String regularExpression = ".a*";
        boolean result = new A33_SimpleRegularExpression().evaluate(input, regularExpression);
        System.out.println(result);
    }

    public boolean evaluate(String source, String pattern) {
        if (source == null || pattern == null) {
            throw new IllegalArgumentException("You can't pass a null strings as input");
        }
        if (pattern.length() == 0) return source.length() == 0;
        // Length 1 is special case
        if (pattern.length() == 1 || pattern.charAt(1) != '*') {
            if (source.length() < 1 || (pattern.charAt(0) != '.' && source.charAt(0) != pattern.charAt(
                    0))) {
                return false;
            }
            return evaluate(source.substring(1), pattern.substring(1));
        } else {
            int len = source.length();

            int i = -1;
            while (i < len && (i < 0 || pattern.charAt(0) == '.' || pattern.charAt(0) == source.charAt(
                    i))) {
                if (evaluate(source.substring(i + 1), pattern.substring(2))) return true;
                i++;
            }
            return false;
        }
    }
}
