package org.b3log.demo.algorithm;

import org.b3log.demo.structure.BinaryNode;

/**
 * Created by yaya on 17-3-4.
 */
public class A65_IsTreeBalanced {
    public static void main(String[] args){
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n3.setLeft(n4);

        boolean isBalanced = new A65_IsTreeBalanced().check(root);
        System.out.println(isBalanced);
    }

    public boolean check(BinaryNode root) {
        if (root == null) {
            return true;
        } else {
            int heightDifference = getRootHeight(root.getLeft()) - getRootHeight(root.getRight());
            return Math.abs(heightDifference) <= 1;
        }
    }

    private int getRootHeight(BinaryNode tree) {
        if (tree == null) {
            return 0;
        } else {
            return 1 + Math.max(getRootHeight(tree.getLeft()), getRootHeight(tree.getRight()));
        }
    }
}
