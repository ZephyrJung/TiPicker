package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaya on 17-3-3.
 * 说是如果元素为0则所在行列均置为0，可是看这个结果似乎不大对
 */
public class A55_RewriteRowAndColumnsWithZeros {

    public static void main(String[] args){
        int[][] matrix = {
                { 1, 1, 0 ,0, 1},
                { 1, 0, 1 ,1, 0},
                { 1, 1, 1 ,1, 1},
                { 1, 1, 1 ,1, 0},
                { 1, 1, 1 ,1, 0}
        };

        new A55_RewriteRowAndColumnsWithZeros().rewrite(matrix);
        PrintUtil.printArray(matrix);
    }

    public void rewrite(int[][] matrix) {
        validateInput(matrix);

        Set<Integer> rowsToSkip = new HashSet<Integer>();
        Set<Integer> columnsToSkip = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (shouldPaintRowAndColumn(matrix, i, j, rowsToSkip, columnsToSkip)) {
                    rewriteRow(matrix, i, rowsToSkip);
                    rewriteColumn(matrix, j, columnsToSkip);
                }
            }
        }
    }

    private void rewriteRow(int[][] matrix, int i, Set<Integer> rowsToSkip) {
        rowsToSkip.add(i);
        for (int x = 0; x < matrix.length; x++) {
            matrix[i][x] = 0;
        }
    }

    private void rewriteColumn(int[][] matrix, int j, Set<Integer> columnsToSkip) {
        columnsToSkip.add(j);
        for (int y = 0; y < matrix[j].length; y++) {
            matrix[y][j] = 0;
        }
    }

    private boolean shouldPaintRowAndColumn(int[][] matrix, int i, int j, Set<Integer> rowsToSkip,
                                            Set<Integer> columnsToSkip) {
        return matrix[i][j] == 0 && !rowsToSkip.contains(i) && !columnsToSkip.contains(j);
    }

    private void validateInput(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("You can't pass a null insntace as input parameter.");
        }
    }
}