package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.ListNode;
import org.b3log.zephyr.util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaya on 17-3-3.
 */
public class A57_RemoveListDuplicatedElements {

    public static void main(String[] args){
        ListNode<Integer> head = ListNode.createList(new int[] { 0, 1, 0, 2, 2, 3, 4, 4 });
        new A57_RemoveListDuplicatedElements().remove2(head);
        PrintUtil.printList(head);
    }

    public void remove(ListNode<Integer> head) {
        validateInput(head);

        Set<Integer> elements = new HashSet<Integer>();
        ListNode<Integer> currentNode = head;
        ListNode<Integer> prevNode = null;
        while (currentNode != null) {
            if (elements.contains(currentNode.getData())) {
                prevNode.setNext(currentNode.getNext());
            } else {
                elements.add(currentNode.getData());
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    public void remove2(ListNode<Integer> head) {
        validateInput(head);

        ListNode<Integer> node = head;
        while (node != null) {
            removeNextNodesWithValue(node);
            node = node.getNext();
        }
    }

    private void validateInput(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException("You can't pass a null ListNode as instance.");
        }
    }

    private void removeNextNodesWithValue(ListNode<Integer> srcNode) {
        ListNode<Integer> prevNode = srcNode;
        ListNode<Integer> currentNode = srcNode.getNext();
        while (currentNode != null) {
            if (currentNode.getData().equals(srcNode.getData())) {
                prevNode.setNext(currentNode.getNext());
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }
}