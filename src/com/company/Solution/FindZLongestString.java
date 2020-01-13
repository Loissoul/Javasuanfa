package com.company.Solution;

import java.lang.reflect.Array;
import java.util.*;

public class FindZLongestString {
//    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
//    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
//    L   C   I   R
//    E T O E S I I G
//    E   D   H   N
//    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
//    请你实现这个将字符串进行指定行数变换的函数：
//
//    string convert(string s, int numRows);
//    示例 1:
//
//    输入: s = "LEETCODEISHIRING", numRows = 3
//    输出: "LCIRETOESIIGEDHN"
//    示例 2:
//
//    输入: s = "LEETCODEISHIRING", numRows = 4
//    输出: "LDREOEIIECIHNTSG"
//    解释:
//
//    L     D     R
//    E   O E   I I
//    E C   I H   N
//    T     S     G

    public String convert2(String s, int numRows) {
        if(numRows <=1 || s == null || s.length() < numRows) return s;

        char[] charArr = new  char[s.length()];
        int page = 0;
        int perArrSize = numRows * 2 - 2;
        for (int i = 0; i < numRows; i ++) {

            charArr[page++] = s.charAt(i);
            int gap = perArrSize - 2 * i;

            for (int j = gap + i; j < s.length(); j += gap) {

                if (gap != 0) {
                    charArr[page++] = s.charAt(j);
                }

                gap = perArrSize - gap; //差距相加为间隔 perArrSize
            }
        }

        return new String(charArr);

    }

    public String convert(String s, int numRows) {
        String result = s;

        if (s.length()> 1 && numRows > 1) {
            result =  "";
            Map<Integer, List> map = new HashMap<>();


            for(int i = 0; i < s.length(); i++) {
                for (int j = 0; j < numRows; j++) {
                    List<String> perArray = new ArrayList<String>();

                    if (map.containsKey(j)) {
                        perArray = map.get(j);
                    } else {
                        map.put(j, perArray);
                    }

                    int yu = i % (numRows + numRows - 2);
                    if (yu >= numRows) {
                        yu = (numRows + numRows - 2) - yu;
                    }

                    if (yu == j) {
                        System.out.println("1111" + s.substring(i, i+1));
                        perArray.add(s.substring(i, i+1));
                        map.replace(j, perArray);
                        System.out.println("map: " + map);
                        break;
                    }
                }
            }

            for (int j = 0; j < numRows; j++) {
                if (map.containsKey(j)) {
                    List<String> perArray = map.get(j);
                    for (int i = 0; i < perArray.size(); i++ ) {
                        String per = perArray.get(i);
                        result = result + per;
                    }
                }

            }

        }
        return result;

    }


    public String convert1(String s, int numRows) {
        if(s==null||numRows<=1||s.length()<=numRows) return s;
        int divsor=numRows*2-2;                             //字符间隔
        int STRLEN=s.length();
        char[] words=new char[STRLEN];
        int p=0;
        for(int i=0;i<STRLEN;i=i+divsor){                   //第一行
            words[p++]=s.charAt(i);
        }
        for (int i = 0; i < numRows - 2; i++) {             //中间各行
            for(int j=i+1,k=divsor-(i+1);j<STRLEN;j=j+divsor,k=k+divsor){
                //中间各行都是在一个周期（T=divsor）内插入两个字符
                words[p++]=s.charAt(j);
                if(k<STRLEN) words[p++]=s.charAt(k);
            }
        }
        for(int i=numRows-1;i<STRLEN;i=i+divsor){           //最后一行
            words[p++]=s.charAt(i);
        }
        return String.copyValueOf(words);
    }



}
