package org.b3log.demo.algorithm;

import org.b3log.zephyr.util.PrintUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zephyr on 2017/2/24.
 * 给出一个集合，返回这个集合的全部子集
 */
public class A43_CombinationOfIntegers {

    public static void main(String[] args){
        Set<Integer> input = new HashSet<Integer>();
        input.add(1);
        input.add(2);
        input.add(3);

        Set<Set<Integer>> result = new A43_CombinationOfIntegers().calculate(input);

        for(Set<Integer> set:result){
            PrintUtil.printSet(set);
        }

    }

    public Set<Set<Integer>> calculate(Set<Integer> originalSet) {
        validateInputSet(originalSet);

        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        //Base class returns the empty set.
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        //Take the first element in head.
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        //Generate a hash set without the first element
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        //Recursive call to iterate over every combination generated with the rest list.
        for (Set<Integer> set : calculate(rest)) {
            //Add every element and the head, the old set and the new set.
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    private void validateInputSet(Set<Integer> inputSet) {
        if (inputSet == null) {
            throw new IllegalArgumentException("You can't pass a null set as input.");
        }
    }
}