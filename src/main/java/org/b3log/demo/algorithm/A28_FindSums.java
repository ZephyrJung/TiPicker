package org.b3log.demo.algorithm;

import org.b3log.demo.structure.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yaya on 17-2-19.
 * 给出一个数组和一个值，找出数组中能够加出这个值的数
 */
public class A28_FindSums {

    public static void main(String[] args){
        int[] inputArray = { 5, 2, -17, 6, 1, 9 };
        int inputValue = -8;

        List<Pair<Integer, Integer>> result = new A28_FindSums().find(inputArray, inputValue);
        System.out.println(result.toString());
    }

    public List<Pair<Integer, Integer>> find(int[] numbers, int value) {
        validateInput(numbers);
        List<Pair<Integer, Integer>> sums = new LinkedList<Pair<Integer, Integer>>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == value) {
                    sums.add(new Pair(numbers[i], numbers[j]));
                }
            }
        }
        return sums;
    }

    public List<Pair<Integer, Integer>> findLinearComplexityOrder(int[] numbers, int n) {
        validateInput(numbers);
        List<Pair<Integer, Integer>> sums = new LinkedList<Pair<Integer, Integer>>();
        Map<Integer, Integer> partialElements = new HashMap<Integer, Integer>();
        for (int number : numbers) {
            if (partialElements.containsKey(number)) {
                sums.add(new Pair<Integer, Integer>(number, partialElements.get(number)));
            } else {
                partialElements.put(n - number, number);
            }
        }
        return sums;
    }

    private void validateInput(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("You can't pass a null array of numbers.");
        }
    }
}
