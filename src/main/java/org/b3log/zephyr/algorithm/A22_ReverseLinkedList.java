package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.ListNode;
import org.b3log.zephyr.util.PrintUtil;

/**
 * Created by yaya on 17-2-19.
 */
public class A22_ReverseLinkedList {

    public static void main(String[] args){
        A22_ReverseLinkedList reverseLinkedList=new A22_ReverseLinkedList();
        ListNode<Integer> head = new ListNode<Integer>(1);
        ListNode<Integer> n2 = new ListNode<Integer>(2);
        ListNode<Integer> n3 = new ListNode<Integer>(3);
        ListNode<Integer> n4 = new ListNode<Integer>(4);
        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        ListNode reversedList = reverseLinkedList.reverseIterative(head);
        ListNode reversedList2 = reverseLinkedList.reverseRecursive(head);//这个方法看起来有点问题
        PrintUtil.printList(reversedList);
        PrintUtil.printList(reversedList2);
    }

    public ListNode reverseIterative(ListNode list) {
        validateInput(list);

        if (list.getNext() == null) {
            return list;
        }

        ListNode head = null;
        ListNode current = list;
        while (current != null) {
            ListNode save = current;
            current = current.getNext();
            save.setNext(head);
            head = save;
        }
        return head;
    }

    public ListNode<Integer> reverseRecursive(ListNode list) {
        validateInput(list);
        return reverseRecursiveInner(list);
    }

    private ListNode<Integer> reverseRecursiveInner(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        } else {
            ListNode reversedList = reverseRecursiveInner(head.getNext());
            head.getNext().setNext(head);
            head.setNext(null);
            return reversedList;
        }
    }

    private void validateInput(ListNode list) {
        if (list == null) {
            throw new IllegalArgumentException("You can't pass a null list as parameter.");
        }
    }
}
