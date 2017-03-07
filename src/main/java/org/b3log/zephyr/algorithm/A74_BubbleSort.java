package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by yaya on 17-3-4.
 */
public class A74_BubbleSort extends SortingAlgorithm  {

    public static void main(String[] args){
        int[] arrays=new int[]{3,2,1,6,7,4,8};
        new A74_BubbleSort().sort(arrays);
        PrintUtil.printArray(arrays);
    }

    public void sort(int[] numbers) {
        validateInput(numbers);

        int length = numbers.length;
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        swap(numbers, j, j + 1);
                        swap = true;
                    }
                }
            }
        }
    }
}
