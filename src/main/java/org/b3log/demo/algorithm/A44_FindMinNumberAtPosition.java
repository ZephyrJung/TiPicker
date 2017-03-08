package org.b3log.demo.algorithm;

import org.b3log.demo.structure.BinaryNode;

import java.util.List;

/**
 * Created by Zephyr on 2017/2/24.
 */
public class A44_FindMinNumberAtPosition {

    private final A15_BinaryTreeInOrder inOrder;

    public A44_FindMinNumberAtPosition() {
        this.inOrder = new A15_BinaryTreeInOrder();
    }

    public static void main(String[] args){
        BinaryNode<Integer> root = new BinaryNode<Integer>(8);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> n10 = new BinaryNode<Integer>(10);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n6 = new BinaryNode<Integer>(6);
        BinaryNode<Integer> n14 = new BinaryNode<Integer>(14);
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
        BinaryNode<Integer> n7 = new BinaryNode<Integer>(7);
        BinaryNode<Integer> n13 = new BinaryNode<Integer>(13);

        root.setLeft(n3);
        root.setRight(n10);
        n3.setLeft(n1);
        n3.setRight(n6);
        n6.setLeft(n4);
        n6.setRight(n7);
        n10.setRight(n14);
        n14.setLeft(n13);

        int result = new A44_FindMinNumberAtPosition().find(root, 1);
        System.out.println(result);
    }

    public Integer find(BinaryNode<Integer> root, int position) {
        validateInputData(root, position);
        List<BinaryNode<Integer>> orderedElements = getOrderedElements(root);
        validatePosition(position, orderedElements);
        return orderedElements.get(position - 1).getData();
    }

    private List<BinaryNode<Integer>> getOrderedElements(BinaryNode root) {
        return inOrder.getRecursive(root);
    }

    private void validatePosition(int position, List<BinaryNode<Integer>> orderedElements) {
        if (position > orderedElements.size()) {
            throw new IllegalArgumentException(
                    "The number of elements in the tree is minor than the position requested.");
        }
    }

    private void validateInputData(BinaryNode<Integer> root, int position) {
        if (root == null || position < 0) {
            throw new IllegalArgumentException("You can't pass null binary trees or negative positions.");
        }
    }
}
