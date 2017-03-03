package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.ListNode;
import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by yaya on 17-3-3.
 */
public class A60_PartitionList {

    public static void main(String[] args){
        ListNode<Integer> list = ListNode.createList(new int[] { 1, 2, 3 });

        ListNode<Integer> result = new A60_PartitionList().split(list, 0);

        PrintUtil.printList(result);
    }

    public ListNode<Integer> split(ListNode<Integer> list, int x) {
        validateInput(list);

        ListNode<Integer> before = null;
        ListNode<Integer> after = null;

        while (list != null) {
            ListNode<Integer> next = list.getNext();
            if (list.getData() < x) {
                list.setNext(before);
                before = list;
            } else {
                list.setNext(after);
                after = list;
            }
            list = next;
        }

        if (before == null) {
            return after;
        }

        ListNode<Integer> result = mergeLists(before, after);

        return result;
    }

    private ListNode<Integer> mergeLists(ListNode<Integer> before, ListNode<Integer> after) {
        ListNode<Integer> result = before;
        while (before.getNext() != null) {
            before = before.getNext();
        }
        before.setNext(after);
        return result;
    }

    private void validateInput(ListNode<Integer> list) {
        if (list == null) throw new IllegalArgumentException("You can't pass a null list as argument.");
    }
}
