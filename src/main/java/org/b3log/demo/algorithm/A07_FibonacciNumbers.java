package org.b3log.demo.algorithm;

/**
 * Created by Zephyr on 2017/2/18.
 */
public class A07_FibonacciNumbers {

    public static void main(String[] args){
        A07_FibonacciNumbers fn=new A07_FibonacciNumbers();
        for(int i=1;i<=10;i++){
            long result=0;
            switch(i%3){
                case 0:result=fn.getRecursive(i);break;
                case 1:result=fn.getIterative(i);break;
                case 2:result=fn.getRecursiveWithCaching(i);break;
                default:System.out.println("impossible!");
            }
            System.out.print(result+" ");
        }
    }

    public long getRecursive(long n) {
        validateInput(n);
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return getRecursive(n - 1) + getRecursive(n - 2);
        }
    }

    public long getIterative(long n) {
        validateInput(n);

        if (n <= 2) {
            return 1;
        }
        long previous = 1;
        long current = 1;
        long element = 0;
        for (long i = 3; i <= n; i++) {
            element = previous + current;
            previous = current;
            current = element;
        }
        return element;
    }

    private static long[] elements = new long[1000];

    public long getRecursiveWithCaching(int n) {
        validateInput(n);

        if (n <= 2) {
            return 1;
        } else if (elements[n - 3] != 0) {
            return elements[n - 3];
        }
        elements[n - 3] = getRecursiveWithCaching(n - 1) + getRecursiveWithCaching(n - 2);
        return elements[n - 3];
    }

    private void validateInput(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("You can't use negative values as parameter.");
        }
    }
}