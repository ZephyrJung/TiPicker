package org.b3log.demo.algorithm;

import org.b3log.demo.structure.BinaryNode;

import java.util.List;

/**
 * Created by Zephyr on 2017/2/21.
 */
public class A36_AvlTreeMedian {
    private static final double DELTA = 0.1;
    A15_BinaryTreeInOrder binaryTreeInOrder;

    public static void main(String[] args){
        BinaryNode<Integer> root = new BinaryNode<Integer>(50);
        BinaryNode<Integer> n17 = new BinaryNode<Integer>(17);
        BinaryNode<Integer> n76 = new BinaryNode<Integer>(76);
        BinaryNode<Integer> n9 = new BinaryNode<Integer>(9);
        BinaryNode<Integer> n14 = new BinaryNode<Integer>(14);
        BinaryNode<Integer> n23 = new BinaryNode<Integer>(23);
        BinaryNode<Integer> n54 = new BinaryNode<Integer>(54);
        BinaryNode<Integer> n72 = new BinaryNode<Integer>(72);
        BinaryNode<Integer> n90 = new BinaryNode<Integer>(90);
        BinaryNode<Integer> n89 = new BinaryNode<Integer>(89);
        BinaryNode<Integer> n91 = new BinaryNode<Integer>(91);
        BinaryNode<Integer> n92 = new BinaryNode<Integer>(93);

        root.setLeft(n17);
        root.setRight(n76);
        n17.setLeft(n9);
        n9.setRight(n14);
        n17.setRight(n23);
        n76.setLeft(n54);
        n54.setRight(n72);
        n76.setRight(n90);
        n90.setLeft(n89);
        n90.setRight(n91);
        n91.setRight(n92);

        double median = new A36_AvlTreeMedian().find(root);
        System.out.println(median);
    }

    public A36_AvlTreeMedian() {
        this.binaryTreeInOrder = new A15_BinaryTreeInOrder();
    }

    public double find(BinaryNode<Integer> root) {
        if (root == null) {
            throw new IllegalArgumentException("You can't pass a null binary tree to this method.");
        }

        List<BinaryNode<Integer>> sortedElements = binaryTreeInOrder.getIterative(root);
        double median = 0;
        if (sortedElements.size() % 2 == 0) {
            median = (sortedElements.get(sortedElements.size() / 2).getData() + sortedElements.get(
                    sortedElements.size() / 2 - 1).getData()) / 2;
        } else {
            median = sortedElements.get(sortedElements.size() / 2).getData();
        }
        return median;
    }
}
