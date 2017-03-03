package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.ListNode;
import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by yaya on 17-3-3.
 */
public class A59_DeleteListNode {

    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<Integer>(0);
        ListNode<Integer> n1 = new ListNode<Integer>(1);
        ListNode<Integer> n2 = new ListNode<Integer>(2);
        head.setNext(n1);
        n1.setNext(n2);

        new A59_DeleteListNode().delete(n1);
        PrintUtil.printList(head);
    }

    public void delete(ListNode node) {
        validateInputData(node);

        if (node.getNext() == null) {
            return;
        }
        ListNode next = node.getNext();
        node.setData(next.getData());
        node.setNext(next.getNext());
    }

    private void validateInputData(ListNode node) {
        if (node == null) {
            throw new IllegalArgumentException(
                    "You can't pass a null instance of ListNode as parameter.");
        }
    }
}
