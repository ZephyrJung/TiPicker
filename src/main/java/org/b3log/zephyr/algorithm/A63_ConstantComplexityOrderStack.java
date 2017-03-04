package org.b3log.zephyr.algorithm;

import java.util.Stack;

/**
 * Created by yaya on 17-3-4.
 */
public class A63_ConstantComplexityOrderStack {

    public static void main(String[] args){
        Stack1 stack1=new Stack1();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(-1);
        stack1.pop();

        Stack2 stack2=new Stack2();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(-1);

        System.out.println(stack1.getMin());
        System.out.println(stack2.getMin());

    }

    public static class Stack1 extends Stack<MinValue> {

        public void push(int item) {
            int newMin = Math.min(item, getMin());
            super.push(new MinValue(item, newMin));
        }

        public int getMin() {
            if (isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().minValue;
            }
        }
    }

    static class MinValue {
        final int value;
        final int minValue;

        MinValue(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }

    public static class Stack2 extends Stack<Integer> {
        Stack<Integer> innerStack = new Stack<Integer>();

        public void push(int item) {
            if (item <= getMin()) {
                innerStack.push(item);
            }
            super.push(item);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == getMin()) {
                innerStack.pop();
            }
            return value;
        }

        public int getMin() {
            if (innerStack.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return innerStack.peek();
            }
        }
    }
}