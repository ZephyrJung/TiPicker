package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by Zephyr on 2017/2/18.
 */
public class A08_SplitArray {
    public static void main(String[] args){
        int[] array1=new int[]{-8,-2,1,4,-7,-1,5,9,-12,8,6};
        int[] array2=new int[]{-8,-2,1,4,-7,-1,5,9,-12,8,6};
        int[] array3=new int[]{-8,-2,1,4,-7,-1,5,9,-12,8,6};
        int[] array4=new int[]{-8,-2,1,4,-7,-1,5,9,-12,8,6};
        new A08_SplitArray().splitSorting(array1);
        new A08_SplitArray().splitSwappingIterative(array2);
        new A08_SplitArray().splitSwappingPartition(array3);
        new A08_SplitArray().splitSwappingRecursive(array4);
        PrintUtil.printArray(array1);
        PrintUtil.printArray(array2);
        PrintUtil.printArray(array3);
        PrintUtil.printArray(array4);
    }

    public void splitSorting(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array passed as parameter can't be null.");
        }

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    public void splitSwappingIterative(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array passed as parameter can't be null.");
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            boolean shouldChangeLeft = array[left] >= 0;
            boolean shouldChangeRight = array[right] < 0;
            if (shouldChangeLeft && shouldChangeRight) {
                swap(array, left, right);
                left++;
                right--;
            } else {
                if (!shouldChangeLeft) {
                    left++;
                } else if (!shouldChangeRight) {
                    right--;
                }
            }
        }
    }

    public void splitSwappingPartition(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array passed as parameter can't be null.");
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (array[left] < 0 && left < right) {
                left++;
            }
            while (array[right] >= 0 && left < right) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
    }

    public void splitSwappingRecursive(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array passed as parameter can't be null.");
        }

        if (array.length == 0) {
            return;
        }

        splitSwappingRecursiveInner(array, 0, array.length - 1);
    }

    private void splitSwappingRecursiveInner(int[] array, int left, int right) {
        if (left < right) {
            boolean shouldChangeLeft = array[left] >= 0;
            boolean shouldChangeRight = array[right] < 0;
            if (shouldChangeLeft && shouldChangeRight) {
                swap(array, left, right);
                splitSwappingRecursiveInner(array, left + 1, right - 1);
            } else {
                if (!shouldChangeLeft) {
                    splitSwappingRecursiveInner(array, left + 1, right);
                } else if (!shouldChangeRight) {
                    splitSwappingRecursiveInner(array, left, right - 1);
                }
            }
        }
    }

    private void swap(int[] array, int left, int right) {
        int aux = array[right];
        array[right] = array[left];
        array[left] = aux;
    }
}