package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-3.
 */
public class A52_ReplaceSpaces {

    public static void main(String[] args){
        char[] input = new char[13];
        input[0] = 112;
        input[1] = 101;
        input[2] = 32;
        input[3] = 100;
        input[4] = 114;
        input[5] = 111;
        input[6] = 32;
        input[7] = 103;
        input[8] = 115;
        new A52_ReplaceSpaces().replace(input);
        System.out.println(input);
    }

    public void replace(char[] input) {
        validateInput(input);

        char[] result = new char[input.length];
        for (int i = 0, j = 0; i < input.length && j < input.length; i++, j++) {
            if (input[i] == ' ') {
                result[j++] = '%';
                result[j++] = '2';
                result[j] = '0';
            } else {
                result[j] = input[i];
            }
        }
        copyArray(result, input);
    }

    private void copyArray(char[] src, char[] destiny) {
        for (int i = 0; i < src.length; i++) {
            destiny[i] = src[i];
        }
    }

    /**
     * Iterative solution with a better performance in spce terms. In time terms, the complexity
     * order of this algorithm is still O(N), the execution time is 2N. In space terms, the
     * complexity order of this algorithm is now O(1) because we are not using any additional data
     * structure to keep a copy of the input array as we are doing in the previous solution.
     */
    public void replace2(char[] input) {
        validateInput(input);

        int i = getLastCharPosition(input);
        for (int j = input.length - 1; i >= 0 && j >= 0; i--, j--) {
            if (input[i] == ' ') {
                input[j--] = '0';
                input[j--] = '2';
                input[j] = '%';
            } else {
                input[j] = input[i];
            }
        }
    }

    private int getLastCharPosition(char[] input) {
        int lastCharPosition = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != '\0') {
                lastCharPosition = i;
            }
        }
        return lastCharPosition;
    }

    private void validateInput(char[] input) {
        if (input == null) {
            throw new IllegalArgumentException("You can't pass a null array as input parameter.");
        }
    }
}
