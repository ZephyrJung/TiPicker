package org.b3log.zephyr.util;

import org.b3log.zephyr.structure.ListNode;

import java.util.List;

/**
 * Created by yaya on 17-2-19.
 */
public class PrintUtil {
    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            if(i+1!=array.length) {
                System.out.print(array[i] + " ");
            }else{
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }

    public static void printArray(Integer[] array){
        for(int i=0;i<array.length;i++){
            if(i+1!=array.length) {
                System.out.print(array[i] + " ");
            }else{
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }

    public static void printList(ListNode node){
        while(node!=null){
            System.out.print(node.toString());
            if(node.getNext()!=null){
                System.out.println(",");
            }else{
                System.out.println();
            }
            node=node.getNext();
        }
    }

    public static void printList(List<String> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).toString());
            if(i!=list.size()-1){
                System.out.print(",");
            }else{
                System.out.println();
            }
        }
    }

}
