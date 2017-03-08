package org.b3log.demo.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by Zephyr on 2017/2/24.
 * 矩阵油漆桶，相邻的0填充为指定数字
 */
public class A42_FloodFill {

    public static void main(String[] args){
        int[][] picture = {
                { 1, 1, 1, 1, 1, 1, 1, 1},
                { 1, 0, 0, 0, 1, 1, 1, 1},
                { 1, 0, 0, 0, 1, 1, 1, 1},
                { 1, 1, 0, 1, 1, 1, 1, 1},
                { 1, 1, 1, 1, 0, 1, 1, 1},
                { 1, 1, 1, 0, 0, 1, 1, 1},
                { 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int colorToReplace = 0;
        int colorToPaint = 5;
        int x = 4;
        int y = 4;

        new A42_FloodFill().apply(picture, colorToReplace, colorToPaint, x, y);
        PrintUtil.printArray(picture);
    }

    public void apply(int[][] picture, int colorToReplace, int colorToPaint, int x, int y) {
        validatePicture(picture);

        int currentColor = getValueAt(picture, x, y);
        if (currentColor == colorToReplace) {
            picture[x][y] = colorToPaint;
            apply(picture, colorToReplace, colorToPaint, x + 1, y);
            apply(picture, colorToReplace, colorToPaint, x - 1, y);
            apply(picture, colorToReplace, colorToPaint, x, y + 1);
            apply(picture, colorToReplace, colorToPaint, x, y - 1);
        }
    }

    private void validatePicture(int[][] picture) {
        if (picture == null) {
            throw new IllegalArgumentException("You can't pass a null instance as picture");
        }
    }

    /**
     * Method created to avoid IndexOutOfBoundExceptions. This method return -1 if you try to access
     * an invalid position.
     */
    private static int getValueAt(int[][] picture, int x, int y) {
        if (x < 0 || y < 0 || x > picture.length || y > picture[x].length) {
            return -1;
        } else {
            return picture[x][y];
        }
    }
}