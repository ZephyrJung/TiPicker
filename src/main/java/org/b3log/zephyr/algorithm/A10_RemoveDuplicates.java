package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

import java.util.*;

/**
 * Created by yaya on 17-2-19.
 * 数组去重
 */
public class A10_RemoveDuplicates {

    public static void main(String[] args){
        Integer[] array = { 1, 1, 5, 6, 2, 3 };
        Integer[] array2= {1,1,1,1,1};
        PrintUtil.printArray(new A10_RemoveDuplicates().removeUsingSet(array2));
        PrintUtil.printArray(new A10_RemoveDuplicates().removeUsingSorting(array));
    }

    public Integer[] removeUsingSet(Integer[] numbers) {
        validateArray(numbers);

        Set<Integer> uniqueElements = new HashSet<Integer>();
        for (int i : numbers) {
            uniqueElements.add(i);
        }
        return uniqueElements.toArray(new Integer[uniqueElements.size()]);
    }

    public Integer[] removeUsingSorting(Integer[] numbers) {
        validateArray(numbers);
        if (numbers.length == 1) {
            return numbers;
        }

        Collections.sort(Arrays.asList(numbers));
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < numbers.length - 1; i++) {
            if (!numbers[i].equals(numbers[i + 1])) {
                result.add(numbers[i]);
            }
        }
        result.add(numbers[numbers.length-1]);//add the last one
        return result.toArray(new Integer[result.size()]);
    }

    private void validateArray(Integer[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("You can't pass a null array");
        }
    }
}