package org.b3log.demo.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by yaya on 17-3-4.
 */
public class A79_MergeSort extends SortingAlgorithm {

    private int[] numbers;
    private int[] helper;
    private int number;

    public static void main(String[] args){
        int[] arrays=new int[]{3,2,1,6,7,4,8};
        new A76_InsertionSort().sort(arrays);
        PrintUtil.printArray(arrays);
    }

    @Override public void sort(int[] numbers) {
        validateInput(numbers);

        this.numbers = numbers;
        number = numbers.length;
        this.helper = new int[number];
        mergeSort(0, number - 1);
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        while (j <= high) {
            numbers[k] = helper[j];
            k++;
            j++;
        }
    }
}
