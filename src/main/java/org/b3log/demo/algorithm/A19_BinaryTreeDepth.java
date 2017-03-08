package org.b3log.demo.algorithm;

import org.b3log.demo.structure.BinaryNode;

/**
 * Created by yaya on 17-2-19.
 */
public class A19_BinaryTreeDepth {
    public static void main(String[] args){
        A19_BinaryTreeDepth binaryTreeDepth=new A19_BinaryTreeDepth();
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
        n4.setLeft(n5);

        System.out.println(binaryTreeDepth.get(root));
    }
    public int get(BinaryNode root) {
        if (root == null) {
            throw new IllegalArgumentException("You can't pass a null BinaryNode as parameter");
        }
        return getInner(root);
    }

    private int getInner(BinaryNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getInner(root.getLeft()), getInner(root.getRight()));
        }
    }
}
