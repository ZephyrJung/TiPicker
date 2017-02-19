package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.BinaryNode;

import java.util.List;

/**
 * Created by yaya on 17-2-19.
 */
public class A18_IsBST {

    private A15_BinaryTreeInOrder binaryTreeInOrder = new A15_BinaryTreeInOrder();

    public static void main(String[] args){
        A18_IsBST isBST=new A18_IsBST();
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        n1.setLeft(root);
        n1.setRight(n2);
        System.out.println(isBST.checkIterative(root));
        System.out.println(isBST.checkRecursive(root));
    }

    public boolean checkRecursive(BinaryNode<Integer> root) {
        validateInput(root);
        return checkRecursiveInner(root);
    }

    private boolean checkRecursiveInner(BinaryNode<Integer> root) {
        if (root == null) {
            return true;
        } else {
            return (root.getLeft() == null || root.getData() >= root.getLeft().getData())
                    && (root.getRight() == null || root.getData() <= root.getRight().getData())
                    && checkRecursiveInner(root.getLeft())
                    && checkRecursiveInner(root.getRight());
        }
    }

    public boolean checkIterative(BinaryNode<Integer> root) {
        validateInput(root);
        List<BinaryNode<Integer>> nodesInOrder = binaryTreeInOrder.getRecursive(root);
        return isListOrdered(nodesInOrder);
    }

    private boolean isListOrdered(List<BinaryNode<Integer>> nodes) {
        if (nodes.size() == 1) {
            return true;
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).getData() > nodes.get(i + 1).getData()) {
                return false;
            }
        }
        return true;
    }

    private void validateInput(BinaryNode<Integer> root) {
        if (root == null) {
            throw new IllegalArgumentException("You can't pass null BinaryNode elements as parameter.");
        }
    }
}
