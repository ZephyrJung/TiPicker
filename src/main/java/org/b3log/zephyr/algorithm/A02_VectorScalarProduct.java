package org.b3log.zephyr.algorithm;

/**
 * Created by Zephyr on 2017/2/18.
 * 计算数量积(a1*a2+b1*b2+c1*c2)
 */
public class A02_VectorScalarProduct {

    public static void main(String[] args){
        System.out.println(new A02_VectorScalarProduct().calculateScalarProduct(
                new Vector(1,2,3),new Vector(2,3,4))
        );
    }

    public int calculateScalarProduct(Vector v1, Vector v2) {
        validateInput(v1, v2);

        int v1Size = v1.size();
        int v2Size = v2.size();
        if (v1Size != v2Size) {
            throw new IllegalArgumentException("Vectors should be contains the same number of elements.");
        }

        int result = 0;
        for (int i = 0; i < v1Size; i++) {
            result += v1.getAt(i) * v2.getAt(i);
        }
        return result;
    }

    private void validateInput(Vector v1, Vector v2) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("This method doesn't accept null vectors");
        }
    }
}

class Vector {

    private final int[] elements;

    public Vector(int... elements) {
        if (elements == null) {
            elements = new int[0];
        }
        this.elements = elements;
    }

    public int getAt(int index) {
        return elements[index];
    }

    public int size() {
        return elements.length;
    }
}