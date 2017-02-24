package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by Zephyr on 2017/2/24.
 * 给出一个数组，依次计算每个元素的另外两个元素的积
 */
public class A39_MultiplyArrayElements {

    public static void main(String[] args){
        int[] array = { 1, 2, 3 };

        int[] result = new A39_MultiplyArrayElements().multiply(array);

        PrintUtil.printArray(result);
    }

    public int[] multiply(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("You can't pass a null array as input.");
        }
        if (input.length == 0) {
            return input;
        }

        int[] front = new int[input.length];
        int[] rear = new int[input.length];
        int[] output = new int[input.length];

        front[0] = 1;
        rear[input.length - 1] = 1;
        for (int i = 1; i < input.length; i++) {
            front[i] = front[i - 1] * input[i - 1];
        }
        for (int i = input.length - 2; i >= 0; i--) {
            rear[i] = rear[i + 1] * input[i + 1];
        }
        for (int i = 0; i < input.length; i++) {
            output[i] = front[i] * rear[i];
        }
        return output;
    }
}