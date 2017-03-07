package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by yaya on 17-3-4.
 */
public class A75_SelectionSort extends SortingAlgorithm {

    public static void main(String[] args){
        int[] arrays=new int[]{3,2,1,6,7,4,8};
        new A75_SelectionSort().sort(arrays);
        PrintUtil.printArray(arrays);
    }

    @Override public void sort(int[] numbers) {
        validateInput(numbers);

        int arraySize = numbers.length;
        for (int i = 0; i < arraySize - 1; i++) {

            int index = i;
            for (int j = i + 1; j < arraySize; j++) {
                if (numbers[j] < numbers[index]) index = j;
            }

            swap(numbers, i, index);
        }
    }
}
