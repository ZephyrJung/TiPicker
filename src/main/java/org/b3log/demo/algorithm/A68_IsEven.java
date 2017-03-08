package org.b3log.demo.algorithm;

/**
 * Created by yaya on 17-3-4.
 */
public class A68_IsEven {
    public static void main(String[] args){
        System.out.println(new A68_IsEven().check(2));
        System.out.println(new A68_IsEven().check(3));
    }
    public boolean check(int n) {
        return (n & 1) != 1;
    }
}
