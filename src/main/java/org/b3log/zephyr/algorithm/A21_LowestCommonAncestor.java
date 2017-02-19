package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.BinaryNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaya on 17-2-19.
 */
public class A21_LowestCommonAncestor {

    public static void main(String[] args){
        A21_LowestCommonAncestor lca=new A21_LowestCommonAncestor();
        BinaryNode<Integer> root = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
        BinaryNode<Integer> n5 = new BinaryNode<Integer>(5);
        BinaryNode<Integer> n6 = new BinaryNode<Integer>(6);
        root.setLeft(n2);
        root.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n4.setLeft(n6);

        BinaryNode result = lca.getRecursive(root, n5, n6);
        BinaryNode result2 = lca.getIterative(root, n5, n6);
        System.out.println(result.toString());
        System.out.println(result2.toString());
    }

    public BinaryNode getRecursive(BinaryNode root, BinaryNode n1, BinaryNode n2) {
        validateInput(root, n1, n2);
        return getRecursiveInner(root, n1, n2);
    }

    private BinaryNode getRecursiveInner(BinaryNode root, BinaryNode n1, BinaryNode n2) {
        if (root == null) {
            return null;
        } else {
            if (root == n1 || root == n2) {
                return root;
            }
            BinaryNode leftBranch = getRecursiveInner(root.getLeft(), n1, n2);
            BinaryNode rightBranch = getRecursiveInner(root.getRight(), n1, n2);
            if (leftBranch != null && rightBranch != null) {
                return root;
            }
            return leftBranch != null ? leftBranch : rightBranch;
        }
    }

    public BinaryNode getIterative(BinaryNode root, BinaryNode n1, BinaryNode n2) {
        validateInput(root, n1, n2);

        List<BinaryNode> pathToA = getPathTo(root, n1);
        List<BinaryNode> pathToB = getPathTo(root, n2);
        BinaryNode result = null;
        int size = Math.min(pathToA.size(), pathToB.size());
        for (int i = 0; i < size; i++) {
            if (pathToA.get(i) != pathToB.get(i)) {
                result = pathToA.get(i - 1);
                break;
            }
        }
        return result;
    }

    private static List<BinaryNode> getPathTo(BinaryNode root, BinaryNode target) {

        List<BinaryNode> path = new LinkedList<BinaryNode>();
        if (root == target) {
            path.add(target);
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            }
            if (root.getLeft() != null) {
                List<BinaryNode> pathTo = getPathTo(root.getLeft(), target);
                if (pathTo != null) {
                    path.add(root);
                    path.addAll(getPathTo(root.getLeft(), target));
                }
            }
            if (root.getRight() != null) {
                List<BinaryNode> pathTo = getPathTo(root.getRight(), target);
                if (pathTo != null) {
                    path.add(root);
                    path.addAll(pathTo);
                }
            }
        }
        return path;
    }

    private void validateInput(BinaryNode root, BinaryNode n1, BinaryNode n2) {
        if (root == null || n1 == null || n2 == null) {
            throw new IllegalArgumentException("You can't pass null elements as input.");
        }
    }
}