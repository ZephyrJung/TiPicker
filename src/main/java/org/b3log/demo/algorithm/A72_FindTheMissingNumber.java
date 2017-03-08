package org.b3log.demo.algorithm;

/**
 * Created by yaya on 17-3-4.
 */
public class A72_FindTheMissingNumber {
    public static void main(String[] args){
        int[] numbers = { 0, 1, 2, 4 };

        int missingNumber = new A72_FindTheMissingNumber().find(numbers);

        System.out.println(missingNumber);
    }

    public int find(int[] numbers) {
        validateInput(numbers);

        int length = numbers.length;
        int idealSum = length * (length + 1) / 2;
        int sum = calculateSum(numbers);

        int missingNumber = idealSum - sum;
        return missingNumber;
    }

    private int calculateSum(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    private void validateInput(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("You can't pass a null instance of numbers.");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException("You can't pass an empty array");
        }
    }
}
