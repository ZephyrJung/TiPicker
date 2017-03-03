package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by yaya on 17-3-3.
 * 矩阵旋转
 */
public class A54_RotateMatrix {

    public static void main(String[] args){
        int[][] matrix = {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 } };

        new A54_RotateMatrix().rotate(matrix);

        PrintUtil.printArray(matrix);

    }

    public void rotate(int[][] matrix) {
        validateInput(matrix);

        int length = matrix.length;
        for (int i = 0; i < length / 2; ++i) {
            int first = i;
            int last = length - 1 - i;
            for (int j = first; j < last; ++j) {
                int offset = j - first;
                int top = matrix[first][j];
                moveLeftToTop(matrix, first, last, j, offset);
                moveBottomToLeft(matrix, first, last, offset);
                moveRithToBottom(matrix, last, j, offset);
                moveTopToRight(matrix, last, j, top);
            }
        }
    }

    private void moveTopToRight(int[][] matrix, int last, int i, int top) {
        matrix[i][last] = top;
    }

    private void moveRithToBottom(int[][] matrix, int last, int i, int offset) {
        matrix[last][last - offset] = matrix[i][last];
    }

    private void moveBottomToLeft(int[][] matrix, int first, int last, int offset) {
        matrix[last - offset][first] = matrix[last][last - offset];
    }

    private void moveLeftToTop(int[][] matrix, int first, int last, int i, int offset) {
        matrix[first][i] = matrix[last - offset][first];
    }

    private void validateInput(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("You can't pass a null instance of matrix as parameter.");
        } else if (matrix.length == 0) {
            throw new IllegalArgumentException(
                    "You can't pass an empty instance of matrix as parameter.");
        } else if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException(
                    "You can't pass a matrix with different height and width.");
        }
    }
}