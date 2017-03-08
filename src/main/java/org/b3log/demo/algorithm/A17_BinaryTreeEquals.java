package org.b3log.demo.algorithm;

import org.b3log.demo.structure.BinaryNode;

import java.util.Stack;

/**
 * Created by yaya on 17-2-19.
 */
public class A17_BinaryTreeEquals {

    public static void main(String[] args){
        A17_BinaryTreeEquals binaryTreeEquals=new A17_BinaryTreeEquals();
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);

        BinaryNode<Integer> root1 = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n11 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n21 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n31 = new BinaryNode<Integer>(3);
        root.setLeft(n11);
        root.setRight(n21);
        n1.setLeft(n31);

        System.out.println(binaryTreeEquals.areEqualsRecursive(root, root1));
        System.out.println(binaryTreeEquals.areEqualsIterative(root, root1));
    }

    public boolean areEqualsRecursive(BinaryNode tree1, BinaryNode tree2) {
        validateInput(tree1, tree2);
        return areEqualsInner(tree1, tree2);
    }

    private boolean areEqualsInner(BinaryNode tree1, BinaryNode tree2) {
        if (tree1 == null && tree2 != null || tree1 != null && tree2 == null) {
            return false;
        } else if (tree1 == null && tree2 == null) {
            return true;
        } else {
            return tree1.equals(tree2)
                    && areEqualsInner(tree1.getLeft(), tree2.getLeft())
                    && areEqualsInner(tree1.getRight(), tree2.getRight());
        }
    }

    public boolean areEqualsIterative(BinaryNode<Integer> tree1, BinaryNode<Integer> tree2) {
        validateInput(tree1, tree2);

        boolean equals = true;
        Stack<BinaryNode> stack1 = new Stack<BinaryNode>();
        Stack<BinaryNode> stack2 = new Stack<BinaryNode>();
        stack1.push(tree1);
        stack2.push(tree2);
        while (!stack1.isEmpty()) {
            BinaryNode node1 = stack1.pop();
            BinaryNode node2 = stack2.pop();
            if (!node1.equals(node2)) {
                equals = false;
                break;
            }
            addNodeToStack(stack1, node1.getLeft());
            addNodeToStack(stack1, node1.getRight());
            addNodeToStack(stack2, node2.getLeft());
            addNodeToStack(stack2, node2.getRight());
        }
        return equals;
    }

    private void addNodeToStack(Stack<BinaryNode> stack, BinaryNode node) {
        if (node != null) {
            stack.add(node);
        }
    }

    private void validateInput(BinaryNode tree1, BinaryNode tree2) {
        if (tree1 == null && tree2 == null) {
            throw new IllegalArgumentException("You can't compare two null trees");
        }
    }
}
