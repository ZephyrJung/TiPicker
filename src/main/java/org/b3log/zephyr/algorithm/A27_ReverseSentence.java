package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-2-19.
 */
public class A27_ReverseSentence {

    private static final String WORD_SEPARATOR = " ";

    public static void main(String[] args){
        System.out.println(new A27_ReverseSentence().reverse("a b c d e f g h i j k l m n"));
    }

    public String reverse(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Input param can't be null.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = sentence.split(WORD_SEPARATOR);
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]);
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
