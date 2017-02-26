package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.BinaryNode;

/**
 * Created by yaya on 17-2-26.
 */
public class A46_BinaryTreeSerialization {

    public A46_BinaryTreeSerialization() {
        index = 0;
    }


    public  static void main(String[] args){
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
        root.setLeft(n1);
        root.setRight(n2);
        n2.setLeft(n3);

        String serializedTree = new A46_BinaryTreeSerialization().serialize(root);
        BinaryNode<Integer> deserializedTree = new A46_BinaryTreeSerialization().deserialize(serializedTree);
    }

    public String serialize(BinaryNode root) {
        validateInputTree(root);
        return serializeInner(root);
    }

    private String serializeInner(BinaryNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append("#");
        } else {
            stringBuilder.append(root.getData());
            stringBuilder.append(serializeInner(root.getLeft()));
            stringBuilder.append(serializeInner(root.getRight()));
        }
        return stringBuilder.toString();
    }

    static int index = 0;

    /**
     * Recursive algorithm based a static index to recreate the original tree properly. The
     * complexity order of this algorithm is O(N) where N is the number of chars in the input String.
     */
    public BinaryNode<Integer> deserialize(String tree) {
        validateInput(tree);

        if (index >= tree.length()) {
            return null;
        } else {
            char currentChar = tree.charAt(index);
            if (currentChar == '#') {
                index++;
                return null;
            } else {
                BinaryNode<Integer> node = new BinaryNode<Integer>(currentChar - 48);
                index++;
                node.setLeft(deserialize(tree));
                node.setRight(deserialize(tree));
                return node;
            }
        }
    }

    private void validateInputTree(BinaryNode root) {
        if (root == null) {
            throw new IllegalArgumentException("You can't pass a null instance of tree to serialize.");
        }
    }

    private void validateInput(String tree) {
        if (tree == null) {
            throw new IllegalArgumentException("You can't pass a null instance of tree to deserialize.");
        }
    }
}
