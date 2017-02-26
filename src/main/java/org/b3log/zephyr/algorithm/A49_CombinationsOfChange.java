package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.util.PrintUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaya on 17-2-26.
 * 给出金额种类和指定金额，返回所有可能组合
 */
public class A49_CombinationsOfChange {

    private final A47_ReturnChange returnChange;

    public A49_CombinationsOfChange() {
        this.returnChange = new A47_ReturnChange();
    }

    public static void main(String[] args){
        int[] moneys = { 5, 10, 15, 50 };

        List<List<Integer>> combinations = new A49_CombinationsOfChange().get(moneys, 60);

        PrintUtil.printLists(combinations);

    }

    public List<List<Integer>> get(int[] availableChange, int value) {
        validateInputData(availableChange, value);

        List<List<Integer>> changeCombinations = new LinkedList<List<Integer>>();
        for (int i = 0; i < availableChange.length; i++) {
            int[] availableMoneys = Arrays.copyOfRange(availableChange, 0, availableChange.length - i);
            List<Integer> change = getChange(availableMoneys, value);
            changeCombinations.add(change);
        }
        return changeCombinations;
    }

    private List<Integer> getChange(int[] availableMoneys, int value) {
        return returnChange.calculate(availableMoneys, value);
    }

    private void validateInputData(int[] availableChange, int value) {
        if (availableChange == null || value <= 0) {
            throw new IllegalArgumentException(
                    "You can't pass a null array or a value minor or equals to zero as argument.");
        }
    }
}
