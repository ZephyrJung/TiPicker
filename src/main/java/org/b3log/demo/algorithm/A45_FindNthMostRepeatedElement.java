package org.b3log.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaya on 17-2-26.
 */
public class A45_FindNthMostRepeatedElement {

    public static void main(String[] args){
        int[] numbers = { 1, 1, 2, 3, 4, 5, 2, 2, 2, 4, 4, 6, 7, 4, 9, 214, 4, 5, };
        int result = new A45_FindNthMostRepeatedElement().find(numbers, 1);
        System.out.println(result);
    }

    public int find(int[] numbers, int position) {
        validateInput(numbers, position);
        Integer result = null;
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int i : numbers) {
            if (counter.get(i) == null) {
                counter.put(i, 1);
            } else {
                counter.put(i, counter.get(i) + 1);
            }
        }
        for (Integer candidate : counter.keySet()) {
            if (counter.get(candidate) == position) {
                result = candidate;
                break;
            }
        }
        validateResult(result);
        return result;
    }

    private void validateInput(int[] numbers, int position) {
        if (numbers == null || position <= 0) {
            throw new IllegalArgumentException(
                    "You can't pass null arrays or position values minor than 0 as parameter.");
        }
    }

    private void validateResult(Integer result) {
        if (result == null) {
            throw new IllegalArgumentException(
                    "There are no elements repeated n times in the array passed as argument");
        }
    }
}