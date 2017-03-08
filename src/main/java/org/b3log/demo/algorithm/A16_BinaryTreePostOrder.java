package org.b3log.demo.algorithm;

import org.b3log.demo.structure.BinaryNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yaya on 17-2-19.
 */
public class A16_BinaryTreePostOrder {

    public static void main(String[] args){
        A16_BinaryTreePostOrder binaryTreePostOrder=new A16_BinaryTreePostOrder();
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);

        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);

        List<BinaryNode> result = binaryTreePostOrder.getRecursive(root);
        List<BinaryNode> result2 = binaryTreePostOrder.getIterative(root);

        System.out.println(result.toString());
        System.out.println(result2.toString());
    }

    public List<BinaryNode> getRecursive(BinaryNode root) {
        validateTree(root);
        return getInner(root);
    }

    private List<BinaryNode> getInner(BinaryNode root) {
        List<BinaryNode> result = new LinkedList<BinaryNode>();
        if (root != null) {
            result.addAll(getInner(root.getLeft()));
            result.addAll(getInner(root.getRight()));
            result.add(root);
        }
        return result;
    }

    public List<BinaryNode> getIterative(BinaryNode root) {
        validateTree(root);
        List<BinaryNode> result = new LinkedList<BinaryNode>();
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        stack.push(root);

        BinaryNode prev = null;
        while (!stack.empty()) {
            BinaryNode current = stack.peek();

            //Go down the tree. check if current node is leaf, if so, process it and pop stack, otherwise,
            //keep going down
            if (prev == null || prev.getLeft() == current || prev.getRight() == current) {
                //prev == null is the situation for the root node
                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                } else if (current.getRight() != null) {
                    stack.push(current.getRight());
                } else {
                    stack.pop();
                    result.add(current);
                }

                //Go up the tree from left node need to check if there is a right child
                //if yes, push it to stack otherwise, process parent and pop stack
            } else if (current.getLeft() == prev) {
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                } else {
                    stack.pop();
                    result.add(current);
                }

                //Go up the tree from right node after coming back from right node, process parent node
                //and pop stack.
            } else if (current.getRight() == prev) {
                stack.pop();
                result.add(current);
            }

            prev = current;
        }
        return result;
    }

    private void validateTree(BinaryNode root) {
        if (root == null) {
            throw new IllegalArgumentException("You can't pass a null BinaryNode.");
        }
    }
}
