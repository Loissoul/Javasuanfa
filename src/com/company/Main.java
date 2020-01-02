package com.company;

import com.company.Solution.FindMedianSortedArrays;
import com.company.Solution.TwoSum;
import com.company.Solution.LongestSubString;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Main.test3();

    }

    static void testTowSum () {
        TwoSum twoSum = new TwoSum();
        int[] array = {1,2,3,4,5};
        int[] result = twoSum.towSum(array,9);
        System.out.println("1111" + Arrays.toString(result));

    }

    static void test2() {
        LongestSubString test = new LongestSubString();
        String s = "abcabcbb";


        System.out.println("result: " +  test.lengthOfLongestSubstring(s));

    }

    static void test3() {

        FindMedianSortedArrays test = new FindMedianSortedArrays();
        int[] array1 = {1};
        int[] array2 = {2,3,4,5,6};



        System.out.println("result: " +  test.findMedianSortedArray(array1, array2));

    }

}
