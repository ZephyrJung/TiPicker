package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.BinaryNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yaya on 17-2-19.
 */
public class A14_BinaryTreePreOrder {

    public static void main(String[] args){
        A14_BinaryTreePreOrder binaryTreePreOrder=new A14_BinaryTreePreOrder();
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);

        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);

        List<BinaryNode> result = binaryTreePreOrder.getIterative(root);
        List<BinaryNode> result2 = binaryTreePreOrder.getRecursive(root);

        System.out.println(result.toString());
        System.out.println(result2.toString());
    }

    public List<BinaryNode> getRecursive(BinaryNode root) {
        validateBinaryNode(root);
        return getInner(root);
    }

    private List<BinaryNode> getInner(BinaryNode root) {
        List<BinaryNode> result = new LinkedList<BinaryNode>();
        if (root != null) {
            result.add(root);
            result.addAll(getInner(root.getLeft()));
            result.addAll(getInner(root.getRight()));
        }
        return result;
    }

    public List<BinaryNode> getIterative(BinaryNode root) {
        validateBinaryNode(root);
        List<BinaryNode> result = new LinkedList<BinaryNode>();
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryNode node = stack.pop();
            result.add(node);
            if (node.hasRight()) {
                stack.add(node.getRight());
            }
            if (node.hasLeft()) {
                stack.add(node.getLeft());
            }
        }

        return result;
    }

    private void validateBinaryNode(BinaryNode root) {
        if (root == null) {
            throw new IllegalArgumentException("You can't pass a null BinaryNode.");
        }
    }
}
