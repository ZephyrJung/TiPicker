package org.b3log.zephyr.algorithm;

import org.b3log.zephyr.structure.BinaryNode;
import org.b3log.zephyr.util.PrintUtil;

import java.util.List;

/**
 * Created by yaya on 17-2-19.
 * 有序数组转二叉搜索树
 */
public class A24_SortedArrayToBST {

    public static void main(String[] args){

        A24_SortedArrayToBST sortedArrayToBST=new A24_SortedArrayToBST();
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
        BinaryNode<Integer> result = sortedArrayToBST.transform(array);
        A15_BinaryTreeInOrder inOrder = new A15_BinaryTreeInOrder();
        List<BinaryNode<Integer>> resultList = inOrder.getIterative(result);
        Integer[] resultArray = new Integer[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i).getData();
        }
        PrintUtil.printArray(resultArray);
    }

    public BinaryNode<Integer> transform(Integer[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) {
            throw new IllegalArgumentException("You can't use a null or empty array.");
        }
        return transformToBST(sortedArray, 0, sortedArray.length - 1);
    }

    private static BinaryNode<Integer> transformToBST(Integer[] sortedArray, int bottom, int top) {
        int center = (top + bottom) / 2;
        if (sortedArray.length == 1) {
            return new BinaryNode<Integer>(sortedArray[0]);
        } else if (bottom > top) {
            return null;
        } else {
            BinaryNode node = new BinaryNode<Integer>(sortedArray[center]);
            node.setLeft(transformToBST(sortedArray, bottom, center - 1));
            node.setRight(transformToBST(sortedArray, center + 1, top));
            return node;
        }
    }
}
