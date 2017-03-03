package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-3.
 */
public class A53_CompressString {

    public static void main(String[] args){
        String wordToCompress = "aabcccccaaa";
        String result = new A53_CompressString().compressRecursive(wordToCompress);
        System.out.println(result);
    }

    public String compress(String src) {
        validateInput(src);

        if (src.isEmpty() || src.length() == 1) {
            return src;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int repeatedCharCounter = 1;
        char previousChar = src.charAt(0);
        for (int i = 1; i < src.length(); i++) {
            char currentChar = src.charAt(i);

            if (isCharRepeated(previousChar, currentChar)) {
                repeatedCharCounter++;
            } else {
                addChar(stringBuilder, previousChar);
                if (repeatedCharCounter > 1) {
                    stringBuilder.append(repeatedCharCounter);
                    repeatedCharCounter = 1;
                }
                previousChar = currentChar;
            }
        }

        appendLastCharIfNeeded(stringBuilder, repeatedCharCounter, previousChar);

        return stringBuilder.toString();
    }

    public String compressAlternativeApproach(String src) {
        validateInput(src);

        if (src.isEmpty() || src.length() == 1) {
            return src;
        }
        int index = 0;
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < src.length()) {
            while (index < src.length() - 1) {
                if (src.charAt(index) == src.charAt(index + 1)) {
                    index++;
                    count++;
                } else {
                    stringBuilder.append(src.charAt(index));
                    if (count > 1) {
                        stringBuilder.append(count);
                    }
                    count = 1;
                    index++;
                    break;
                }
            }
            if (index == src.length() - 1) {
                if (src.charAt(index) != src.charAt(index - 1)) {
                    stringBuilder.append(src.charAt(index));
                } else {
                    stringBuilder.append(src.charAt(index));
                    if (count > 1) {
                        stringBuilder.append(count);
                    }
                }
                index++;
                break;
            }
        }
        return stringBuilder.toString();
    }

    private boolean isCharRepeated(char previousChar, char currentChar) {
        return currentChar == previousChar;
    }

    private void appendLastCharIfNeeded(StringBuilder stringBuilder, int repeatedCharCounter,
                                        char previousChar) {
        if (repeatedCharCounter > 1) {
            addChar(stringBuilder, previousChar);
            stringBuilder.append(repeatedCharCounter);
        }
    }

    /**
     * Tail recursive solution to this problem. The complexity order in time and space terms of this
     * recursive version is the same than te previous one.
     */
    public String compressRecursive(String src) {
        validateInput(src);

        if (src.length() <= 1) {
            return src;
        }

        return compressRecursiveInner(src, new StringBuilder(), 1, src.charAt(0), 1);
    }

    private String compressRecursiveInner(String src, StringBuilder sb, int i, char previousChar,
                                          int charCounter) {
        boolean thereIsNoMoreWordToCompress = i == src.length();
        if (thereIsNoMoreWordToCompress) {
            addChar(sb, previousChar);
            addCharCounterIfNeeded(sb, charCounter);
            return sb.toString();
        } else {
            if (isCharRepeated(src.charAt(i), previousChar)) {
                return compressRecursiveInner(src, sb, i + 1, previousChar, charCounter + 1);
            } else {
                addChar(sb, previousChar);
                addCharCounterIfNeeded(sb, charCounter);
                return compressRecursiveInner(src, sb, i + 1, src.charAt(i), 1);
            }
        }
    }

    private void addCharCounterIfNeeded(StringBuilder sb, int charCounter) {
        if (charCounter > 1) {
            sb.append(charCounter);
        }
    }

    private void addChar(StringBuilder sb, char previousChar) {
        sb.append(previousChar);
    }

    private void validateInput(String src) {
        if (src == null) {
            throw new IllegalArgumentException("You can't pass a null String as input parameter.");
        }
    }
}