package org.b3log.zephyr.util;

import org.b3log.zephyr.structure.ListNode;

import java.util.List;
import java.util.Set;

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

    public static void printArray(int[][] array){
        for(int i=0;i<array.length;i++){
            printArray(array[i]);
        }
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

    public static void printArray(String[] array){
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

    public static void printList(List list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).toString());
            if(i!=list.size()-1){
                System.out.print(",");
            }else{
                System.out.println();
            }
        }
    }

    public static void printLists(List list){
        for(int i=0;i<list.size();i++){
            printList((List)list.get(i));
        }
    }


    public static void printSet(Set<Integer> set){
        for(Integer i:set){
            System.out.print(i.toString()+" ");
        }
        System.out.println();
    }
}
