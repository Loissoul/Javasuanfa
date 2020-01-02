package com.company.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LongestSubString {

    //输入: "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public  int lengthOfLongestSubstring(String s) {

        int maxNum = 0;
        int leftIndex = 0;
        char[] cArr = s.toCharArray();

        if (cArr.length > 0) {
            if (cArr.length == 1) {
                return 1;
            }
            for (int i = 0; i < cArr.length; i++) {
                Integer num = 0;
                for (int j = leftIndex; j < i; j++) {

                    if (cArr[j] == cArr[i]) {

                        maxNum = Math.max(maxNum, i - leftIndex);
                        leftIndex = j+1;

                        break;
                    }
                }
            }

        }
        return Math.max(cArr.length - leftIndex, maxNum);
    }

}
