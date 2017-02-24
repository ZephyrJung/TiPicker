package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by Zephyr on 2017/2/24.
 * 冒泡排序
 */
public class A40_MoveElementsToPositions {

    public static void main(String[] args){
        int[] input = { 2, 3, 1, 0 };

        new A40_MoveElementsToPositions().move(input);

        PrintUtil.printArray(input);
    }

    public void move(int[] array) {
        validateInput(array);
        int size = array.length;
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < size - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap = true;
                    swapElements(array, i, i + 1);
                }
            }
        }
    }

    private void validateInput(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("You can't pass a null array as input.");
        }
        int arraySize = array.length;
        for (int i = 0; i < arraySize; i++) {
            checkIfElementIsInsideTheValidInterval(array[i], arraySize);
        }
    }

    private void checkIfElementIsInsideTheValidInterval(int number, int length) {
        if (number < 0 || number >= length) {
            throw new IllegalArgumentException("Input array contains an invalid element: " + number);
        }
    }

    private void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
