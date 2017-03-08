package org.b3log.demo.algorithm;

import org.b3log.demo.structure.ListNode;

import java.util.Stack;

/**
 * Created by yaya on 17-3-4.
 */
public class A62_PalindromeList {

    private final A22_ReverseLinkedList reverseLinkedList;

    public A62_PalindromeList() {
        this.reverseLinkedList = new A22_ReverseLinkedList();
    }

    public static void main(String[] args){
        ListNode<Integer> list = ListNode.createList(new int[] { 1, 2, 1 });

        boolean result = new A62_PalindromeList().checkIterative(list);

        System.out.println(result);
    }

    public boolean checkReversing(ListNode list) {
        validateInput(list);

        ListNode<Integer> reversedList = reverseLinkedList.reverseIterative(list);

        boolean isPalindrome = true;
        while (list != null) {
            isPalindrome = list.equals(reversedList);
            if (!isPalindrome) {
                break;
            }
            reversedList = reversedList.getNext();
            list = list.getNext();
        }
        return isPalindrome;
    }

    public boolean checkIterative(ListNode list) {
        validateInput(list);

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode fastPointer = list;
        ListNode slowPointer = list;
        while (fastPointer != null && fastPointer.getNext() != null) {
            stack.add(slowPointer);
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }

        if (fastPointer != null) {
            slowPointer = slowPointer.getNext();
        }

        boolean isPalindrome = true;
        while (slowPointer != null) {
            if (!stack.pop().equals(slowPointer)) {
                isPalindrome = false;
                break;
            }
            slowPointer = slowPointer.getNext();
        }
        return isPalindrome;
    }

    private void validateInput(ListNode<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("You can't pass a null list as parameter.");
        }
    }
}
