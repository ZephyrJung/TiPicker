package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-2-26.
 * 给出一个字符数组和一个单词，检查这个单词的所有字母是否一一包含在了字符数组中
 */
public class A48_WordSearch {

    public static void main(String[] args){
        char[][] matrix = {
                { 'a', 'a', 'c', 'd', 'e' }, { 'a', 'd', 'a', 'r', 'c' }, { 'a', 'd', 'a', 'c', 'c' },
                { 'b', 'a', 'c', 'o', 'o' }
        };

        boolean result = new A48_WordSearch().contains(matrix, "pedro");
        System.out.println(result);
    }

    public boolean contains(char[][] wordSearch, String word) {
        validateInputData(wordSearch, word);

        for (int i = 0; i < wordSearch.length; i++) {
            for (int j = 0; j < wordSearch[i].length; j++) {
                if (matches(wordSearch, i, j, word.charAt(0))) {
                    if (isWordInWordSearchInner(wordSearch, word, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean isWordInWordSearchInner(char[][] wordSearch, String word, int x, int y) {
        if (word.isEmpty()) {
            return true;
        } else {
            boolean firstLetter = matches(wordSearch, x, y, word.charAt(0));
            if (firstLetter) {
                boolean left = isWordInWordSearchInner(wordSearch, word.substring(1), x - 1, y);
                boolean right = isWordInWordSearchInner(wordSearch, word.substring(1), x + 1, y);
                boolean bottom = isWordInWordSearchInner(wordSearch, word.substring(1), x, y + 1);
                boolean top = isWordInWordSearchInner(wordSearch, word.substring(1), x, y - 1);
                boolean topLeft = isWordInWordSearchInner(wordSearch, word.substring(1), x - 1, y - 1);
                boolean topRight = isWordInWordSearchInner(wordSearch, word.substring(1), x + 1, y - 1);
                boolean bottomLeft = isWordInWordSearchInner(wordSearch, word.substring(1), x - 1, y + 1);
                boolean bottomRight = isWordInWordSearchInner(wordSearch, word.substring(1), x + 1, y + 1);

                return left || right || bottom || top || topLeft || topRight || bottomLeft || bottomRight;
            }
            return false;
        }
    }

    private static boolean matches(char[][] wordSearch, int x, int y, char c) {
        if (x < 0 || x >= wordSearch.length || y < 0 || y >= wordSearch[x].length) {
            return false;
        } else {
            return wordSearch[x][y] == c;
        }
    }

    private void validateInputData(char[][] wordSearch, String word) {
        if (word == null || wordSearch == null) {
            throw new IllegalArgumentException("You can't pass null instances as parameter.");
        }
    }
}