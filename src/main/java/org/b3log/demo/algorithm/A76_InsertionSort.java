package org.b3log.demo.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by yaya on 17-3-4.
 */
public class A76_InsertionSort extends SortingAlgorithm {
    public static void main(String[] args){
        int[] arrays=new int[]{3,2,1,6,7,4,8};
        new A76_InsertionSort().sort(arrays);
        PrintUtil.printArray(arrays);
    }

    @Override public void sort(int[] numbers) {
        validateInput(numbers);

        int i;
        for (i = 1; i < numbers.length; i++) {
            int tmp = numbers[i];
            int j = i;
            while (j > 0 && numbers[j - 1] > tmp) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = tmp;
        }
    }
}