package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-4.
 */
public class A78_AutoBoxingTrick {
    public static void main(String[] args){
        A78_AutoBoxingTrick autoBoxingTrick=new A78_AutoBoxingTrick();
        System.out.println(autoBoxingTrick.compare(1, 1));
        System.out.println(autoBoxingTrick.compare(1000, 1000));
    }
    public boolean compare(Integer n1, Integer n2) {
        return n1 == n2;
    }
}
