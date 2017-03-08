package org.b3log.demo.algorithm;

/**
 * Created by Zephyr on 2017/2/18.
 * 合并有序数组（数组应当有序，否则结果错误）
 */
public class A06_MergeSortedArrays {
    public static void main(String[] args){
        int[] result=new A06_MergeSortedArrays().merge(new int[]{1,3,5},new int[]{2,4,6});
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
    public int[] merge(int[] array1, int[] array2) {
        validateArrays(array1, array2);

        int[] result = new int[array1.length + array2.length];

        int i = 0, j = 0, k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < array1.length) {
            result[k++] = array1[i++];
        }
        while (j < array2.length) {
            result[k++] = array2[j++];
        }
        return result;
    }

    private void validateArrays(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("You can't use null arrays as parameters.");
        }
    }
}