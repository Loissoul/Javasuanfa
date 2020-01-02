package com.company.Solution;

public class LongestPalindrome {
//    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//    示例 1：
//
//    输入: "babad"
//    输出: "bab"
//    注意: "aba" 也是一个有效答案。
//    示例 2：
//
//    输入: "cbbd"
//    输出: "bb"


    //解法1 最简单的暴力解法，拆分成对应的所有字符串  时间复杂度 O(n^3)

    //解法2 中心扩展算法 可以从中心展开   左右寻找 O(n^2)

    public String longestPalingrome(String s) {

        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            //两个中心，一个中心，两种情况，两种情况的时候取其最大的
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;

        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return  R - L - 1;
    }


    //判断String是不是回文字符串
    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(len - i -1)) {
                return false;
            }
        }
        return true;
    }


}
