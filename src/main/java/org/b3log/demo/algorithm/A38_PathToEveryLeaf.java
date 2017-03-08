package org.b3log.demo.algorithm;

import org.b3log.demo.structure.BinaryNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zephyr on 2017/2/24.
 */
public class A38_PathToEveryLeaf {

    public static void main(String[] args){
        BinaryNode<Integer> root = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4);
        BinaryNode<Integer> n5 = new BinaryNode<Integer>(5);
        root.setLeft(n2);
        root.setRight(n3);
        n3.setLeft(n4);
        n3.setRight(n5);

        List<List<BinaryNode>> paths = new A38_PathToEveryLeaf().calculate(root);
        System.out.println("输出比较复杂请debug观看");
    }

    public List<List<BinaryNode>> calculate(BinaryNode<Integer> root) {
        if (root == null) {
            throw new IllegalArgumentException("You can't pass a null instance of BinaryNode");
        }
        return calculatePathToLeafs(root, new LinkedList<BinaryNode>());
    }

    private static List<List<BinaryNode>> calculatePathToLeafs(BinaryNode<Integer> root,
                                                               List<BinaryNode> path) {
        List<List<BinaryNode>> paths = new LinkedList<List<BinaryNode>>();
        if (root == null) {
            return paths;
        } else if (root.getLeft() == null && root.getRight() == null) {
            path.add(root);
            paths.add(path);
            return paths;
        } else {
            path.add(root);
            paths.addAll(calculatePathToLeafs(root.getLeft(), new LinkedList<BinaryNode>(path)));
            paths.addAll(calculatePathToLeafs(root.getRight(), new LinkedList<BinaryNode>(path)));
            return paths;
        }
    }
}