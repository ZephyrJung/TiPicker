package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by Zephyr on 2017/2/24.
 * 螺旋遍历矩阵
 */
public class A41_GoThroughMatrixInSpiral {

    public static void main(String[] args){
        int[][] matrix = {
                {  1,  2,  3,  4,  5,  6 },
                { 20, 21, 22, 23, 24,  7 },
                { 19, 32, 33, 34, 25,  8 },
                { 18, 31, 36, 35, 26,  9 },
                { 17, 30, 29, 28, 27, 10 },
                { 16, 15, 14, 13, 12, 11 }
        };

        int[] result = new A41_GoThroughMatrixInSpiral().go(matrix);

        PrintUtil.printArray(result);
    }


    public int[] go(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("You can't pass a null insantece as input.");
        }
        if (matrix.length == 0) {
            return new int[0];
        }

        //Calculate sizes
        int m = matrix.length;
        int n = matrix[0].length;
        int resultIndex = 0;
        int[] result = new int[m * n];

        int x = 0;
        int y = 0;

        //We are going to iterate over m and n subtracting 2 in each iteration.
        while (m > 0 && n > 0) {

            //If one row/column left, no circle can be formed
            //Special cases where the size of the matrix is odd
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result[resultIndex++] = matrix[x][y];
                    y++;
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result[resultIndex++] = matrix[x][y];
                    x++;
                }
                break;
            }

            //Process a circle

            //top - move right. Move n positions -1 to the right
            for (int i = 0; i < n - 1; i++) {
                result[resultIndex++] = matrix[x][y];
                y++;
            }

            //right - move down. Move n positions -1 to down.
            for (int i = 0; i < m - 1; i++) {
                result[resultIndex++] = matrix[x][y];
                x++;
            }

            //bottom - move left. Move n positions -1 left
            for (int i = 0; i < n - 1; i++) {
                result[resultIndex++] = matrix[x][y];
                y--;
            }

            //left - move up. ove n postitions .1 up
            for (int i = 0; i < m - 1; i++) {
                result[resultIndex++] = matrix[x][y];
                x--;
            }

            //Increment x and y pointers.
            x++;
            y++;
            //Update sizes to reduce the diameter.
            m = m - 2;
            n = n - 2;
        }
        return result;
    }
}
