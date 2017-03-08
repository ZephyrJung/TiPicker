package org.b3log.demo.algorithm;

import org.b3log.demo.structure.ListNode;

/**
 * Created by yaya on 17-3-4.
 */
public class A64_GetTheElementInTheMiddleOfTheList {
    public static void main(String[] args){
        A64_GetTheElementInTheMiddleOfTheList getTheElementInTheMiddleOfTheList=new A64_GetTheElementInTheMiddleOfTheList();
        ListNode<Integer> list = ListNode.createList(new int[] { 1, 2, 3, 4 });
        ListNode<Integer> middleElement = getTheElementInTheMiddleOfTheList.get(list);
        ListNode<Integer> list2 = ListNode.createList(new int[] { 1, 2, 3, 4 });
        ListNode<Integer> middleElement2 = getTheElementInTheMiddleOfTheList.get2(list);
        System.out.println(middleElement.getData());
        System.out.println(middleElement2.getData());
    }

    public ListNode<Integer> get(ListNode<Integer> list) {
        validateInput(list);

        int size = getListSize(list);
        int middleElementPosition = size % 2 != 0 ? size / 2 : (size / 2) - 1;
        ListNode middleElement = list;
        for (int i = 0; i < middleElementPosition; i++) {
            middleElement = middleElement.getNext();
        }
        return middleElement;
    }

    private int getListSize(ListNode<Integer> list) {
        int size = 0;
        ListNode currentNode = list;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    public ListNode<Integer> get2(ListNode<Integer> list) {
        validateInput(list);

        ListNode<Integer> currentNode = list;
        ListNode<Integer> fastNode = list.getNext();
        while (fastNode != null && fastNode.getNext() != null) {
            currentNode = currentNode.getNext();
            fastNode = fastNode.getNext().getNext();
        }
        return currentNode;
    }

    private void validateInput(ListNode list) {
        if (list == null) {
            throw new IllegalArgumentException("You can't pass a null instance of list");
        }
    }
}
