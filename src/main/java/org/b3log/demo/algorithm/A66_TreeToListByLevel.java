package org.b3log.demo.algorithm;

import org.b3log.demo.structure.BinaryNode;
import org.b3log.zephyr.util.PrintUtil;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yaya on 17-3-4.
 */
public class A66_TreeToListByLevel {
    public static void main(String[] args){
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);

        List<BinaryNode> result = new A66_TreeToListByLevel().transform(root);

        PrintUtil.printList(result);
    }

    public List<BinaryNode> transform(BinaryNode tree) {
        if (tree == null) {
            return Collections.EMPTY_LIST;
        }

        List<BinaryNode> nodesByLevel = new LinkedList<BinaryNode>();
        Queue<BinaryNode> stack = new LinkedList<BinaryNode>();
        stack.add(tree);
        while (!stack.isEmpty()) {
            BinaryNode node = stack.remove();
            nodesByLevel.add(node);
            if (node.getLeft() != null) {
                stack.add(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.add(node.getRight());
            }
        }
        return nodesByLevel;
    }
}
