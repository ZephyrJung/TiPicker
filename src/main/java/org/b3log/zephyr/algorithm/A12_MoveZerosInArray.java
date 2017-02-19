package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by yaya on 17-2-19.
 */
public class A12_MoveZerosInArray {

    public static void main(String[] args){
        int[] array = { 1, 0, 2, -3, 0, 0, 0, 0, -1 };
        int[] array2 = { 1, 0, 2, -3, 0, 0, 0, 0, -1 };
        new A12_MoveZerosInArray().moveUsingTwoPointers(array);
        new A12_MoveZerosInArray().moveSorting(array);
        PrintUtil.printArray(array);
        PrintUtil.printArray(array2);
    }

    public void moveSorting(int[] array) {
        validateArray(array);

        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if ((array[i] < array[i + 1] && array[i + 1] > 0)) {
                    swap(array, i, i + 1);
                    swap = true;
                }
            }
        }
        swap=true;
        while (swap) {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if ((array[i] > array[i + 1] && array[i + 1] < 0)) {
                    swap(array, i, i + 1);
                    swap = true;
                }
            }
        }
    }

    public void moveUsingTwoPointers(int[] array) {
        validateArray(array);

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] == 0 && array[right] != 0) {
                swap(array, left, right);
            }
            if (array[left] != 0) {
                left++;
            }
            if (array[right] == 0) {
                right--;
            }
        }
    }

    private void validateArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("You can't pass a null array as argument.");
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
