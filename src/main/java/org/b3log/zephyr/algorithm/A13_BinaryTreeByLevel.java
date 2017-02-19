package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.BinaryNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yaya on 17-2-19.
 */
public class A13_BinaryTreeByLevel {

    public static void main(String[] args){
        A13_BinaryTreeByLevel binaryTreeByLevel=new A13_BinaryTreeByLevel();
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
        BinaryNode<Integer> n5 = new BinaryNode<Integer>(5);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        n2.setLeft(n5);

        List<BinaryNode> result = binaryTreeByLevel.getUsingQueue(root);
        List<BinaryNode> result2 = binaryTreeByLevel.getWithoutAdditionalDataStructures(root);

        System.out.println(result.toString());
        System.out.println(result2.toString());
    }

    public List<BinaryNode> getUsingQueue(BinaryNode root) {
        validateBinaryNode(root);

        List<BinaryNode> result = new LinkedList<BinaryNode>();
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode binaryNode = queue.remove();
            result.add(binaryNode);
            if (binaryNode.getLeft() != null) queue.add(binaryNode.getLeft());
            if (binaryNode.getRight() != null) queue.add(binaryNode.getRight());
        }
        return result;
    }

    public List<BinaryNode> getWithoutAdditionalDataStructures(BinaryNode root) {
        validateBinaryNode(root);

        List<BinaryNode> result = new LinkedList<BinaryNode>();
        int depth = getDepth(root);
        for (int i = 1; i <= depth; i++) {
            result.addAll(getNodesForLevel(root, i));
        }
        return result;
    }

    private void validateBinaryNode(BinaryNode root) {
        if (root == null) {
            throw new IllegalArgumentException("You can't use null BinaryNodes as argument.");
        }
    }

    private int getDepth(BinaryNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getDepth(root.getLeft()), getDepth(root.getRight()));
        }
    }

    private List<BinaryNode> getNodesForLevel(BinaryNode root, int level) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        } else {
            List<BinaryNode> result = new LinkedList<BinaryNode>();
            StringBuilder stringBuilder = new StringBuilder();
            if (level == 1) {
                result.add(root);
            } else {
                result.addAll(getNodesForLevel(root.getLeft(), level - 1));
                result.addAll(getNodesForLevel(root.getRight(), level - 1));
            }
            return result;
        }
    }
}