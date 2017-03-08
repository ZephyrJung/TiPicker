package org.b3log.demo.algorithm;

import org.b3log.demo.structure.ListNode;

/**
 * Created by yaya on 17-3-4.
 * 对应相加并翻转数位
 */
public class A61_SumLists {

    public static void main(String[] args){
        ListNode<Integer> n1 = ListNode.createList(new int[] { 5, 5, 1 });
        ListNode<Integer> n2 = ListNode.createList(new int[] { 4, 1, 3 });

        int result = new A61_SumLists().sumReverse(n1, n2);
        System.out.println(result);
    }

    public int sumReverse(ListNode<Integer> n1, ListNode<Integer> n2) {
        validateInput(n1, n2);

        int n1Value = calculateReverseNumber(n1);
        int n2Value = calculateReverseNumber(n2);
        return n1Value + n2Value;
    }

    private int calculateReverseNumber(ListNode<Integer> list) {
        int value = 0;
        int i = 0;
        while (list != null) {
            value += list.getData() * Math.pow(10, i);
            list = list.getNext();
            i++;
        }
        return value;
    }

    public int sum(ListNode<Integer> n1, ListNode<Integer> n2) {
        validateInput(n1, n2);

        int n1Value = calculateNumber(n1);
        int n2Value = calculateNumber(n2);
        return n1Value + n2Value;
    }

    private int calculateNumber(ListNode<Integer> list) {
        int value = 0;
        int digits = getListSize(list) - 1;
        while (list != null) {
            value += list.getData() * Math.pow(10, digits);
            list = list.getNext();
            digits--;
        }
        return value;
    }

    private int getListSize(ListNode<Integer> list) {
        int size = 0;
        while (list != null) {
            list = list.getNext();
            size++;
        }
        return size;
    }

    private void validateInput(ListNode<Integer> n1, ListNode<Integer> n2) {
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("You can't pass a null list as parameter.");
        }
    }
}
