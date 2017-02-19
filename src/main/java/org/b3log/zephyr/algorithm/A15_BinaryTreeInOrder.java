package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.BinaryNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yaya on 17-2-19.
 */
public class A15_BinaryTreeInOrder {
    public static void main(String[] args){
        A15_BinaryTreeInOrder binaryTreeInOrder=new A15_BinaryTreeInOrder();
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);

        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);

        List<BinaryNode<Integer>> result = binaryTreeInOrder.getRecursive(root);
        List<BinaryNode<Integer>> result2 = binaryTreeInOrder.getIterative(root);

        System.out.println(result.toString());
        System.out.println(result2.toString());
    }

    public List<BinaryNode<Integer>> getRecursive(BinaryNode root) {
        validateBinaryNode(root);

        return getInner(root);
    }

    private List<BinaryNode<Integer>> getInner(BinaryNode<Integer> root) {
        List<BinaryNode<Integer>> result = new LinkedList<BinaryNode<Integer>>();
        if (root != null) {
            result.addAll(getInner(root.getLeft()));
            result.add(root);
            result.addAll(getInner(root.getRight()));
        }
        return result;
    }

    public List<BinaryNode<Integer>> getIterative(BinaryNode<Integer> root) {
        validateBinaryNode(root);

        List<BinaryNode<Integer>> result = new LinkedList<BinaryNode<Integer>>();
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        //Define a pointer to track nodes
        BinaryNode current = root;
        while (!stack.empty() || current != null) {
            if (current != null) {
                //If it is not null, push to stack and go down the tree to left
                stack.push(current);
                current = current.getLeft();
            } else {
                //If no left child pop stack, process the node then let current point to the right
                BinaryNode node = stack.pop();
                result.add(node);
                current = node.getRight();
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
