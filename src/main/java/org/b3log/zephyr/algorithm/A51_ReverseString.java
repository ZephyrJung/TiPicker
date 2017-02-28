package org.b3log.zephyr.algorithm;

/**
 * Created by Zephyr on 2017/2/28.
 */
public class A51_ReverseString {

    public static void main(String[] args){
        String result = new A51_ReverseString().reverseIterative("Pedro");
        System.out.println(result);
    }

    public String reverseIterative(String input) {
        validateInput(input);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }

    public String reverseRecursive(String input) {
        validateInput(input);
        return reverseRecursiveInner(input, input.length() - 1, new StringBuilder());
    }

    private String reverseRecursiveInner(String input, int i, StringBuilder stringBuilder) {
        if (i < 0) {
            return stringBuilder.toString();
        } else {
            stringBuilder.append(input.charAt(i--));
            return reverseRecursiveInner(input, i, stringBuilder);
        }
    }

    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("You can't pass a null String as input parameter.");
        }
    }
}