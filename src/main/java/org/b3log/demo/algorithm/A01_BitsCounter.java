package org.b3log.demo.algorithm;

/**
 * Created by Zephyr on 2017/2/18.
 * 计算数的二进制形式中1的个数
 */
public class A01_BitsCounter {

    public static void main(String args[]){
        A01_BitsCounter bitsCounter=new A01_BitsCounter();
        for(int i=1;i<10;i++){
            System.out.println(i+":"+Integer.toBinaryString(i)+" "+bitsCounter.countBitsToOneBasedOnString(i)+","+bitsCounter.countBitsToOneBasedOnBinaryOperators(i));
        }
    }

    //基于字符串计算位数
    public int countBitsToOneBasedOnString(int n) {
        int result = 0;
        String binaryNumber = Integer.toBinaryString(n);
        for (char c : binaryNumber.toCharArray()) {
            result += c == '1' ? 1 : 0;
        }
        return result;
    }
    //基于位运算
    public int countBitsToOneBasedOnBinaryOperators(int n) {
        int result = 0;
        while (n > 0) {
            result += (n & 1) == 1 ? 1 : 0;
            n = n >> 1;
        }
        return result;
    }
}
