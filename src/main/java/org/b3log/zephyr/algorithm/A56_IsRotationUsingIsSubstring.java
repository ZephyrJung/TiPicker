package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-3.
 */
public class A56_IsRotationUsingIsSubstring {

    public static void main(String[] args){
        A56_IsRotationUsingIsSubstring isRotation=new A56_IsRotationUsingIsSubstring();
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotation.check(s1, s2));

        s1 = "waterbottle";
        s2 = "pedro";
        System.out.println(isRotation.check(s1, s2));
    }

    public boolean check(String s1, String s2) {
        validateInput(s1, s2);

        if (haveSameLength(s1, s2)) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private boolean isSubstring(String s1s2, String s2) {
        return s1s2.contains(s2);
    }

    private void validateInput(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("You can't pass null instances of s1 or s2 as parameter.");
        }
    }

    private boolean haveSameLength(String s1, String s2) {
        return s1.length() == s2.length();
    }
}
