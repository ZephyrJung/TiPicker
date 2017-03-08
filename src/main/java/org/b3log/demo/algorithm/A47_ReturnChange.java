package org.b3log.demo.algorithm;

import org.b3log.zephyr.util.PrintUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaya on 17-2-26.
 * 给出一个金额数组和一个指定金额，计算最少钱个数的组合结果
 */
public class A47_ReturnChange {

    public static void main(String[] args){
        int[] moneys = { 5, 10, 15, 50 };

        List<Integer> change = new A47_ReturnChange().calculate(moneys, 80);

        PrintUtil.printList(change);
    }

    public List<Integer> calculate(int[] moneys, int billAmount) {
        validateInputData(moneys, billAmount);

        List<Integer> change = new LinkedList<Integer>();
        while (billAmount > 0 && moneys.length > 0) {
            for (int i = moneys.length - 1; i >= 0; i--) {
                if (billAmount - moneys[i] >= 0) {
                    change.add(moneys[i]);
                    billAmount -= moneys[i];
                    break;
                }
            }
        }
        return change;
    }

    private void validateInputData(int[] moneys, int billAmount) {
        if (moneys == null || moneys.length == 0 || billAmount <= 0) {
            throw new IllegalArgumentException(
                    "Review your parameters used as input, you can't use a null or empty array of moneys or "
                            + "a bill amount equals or less than zero.");
        }
    }
}