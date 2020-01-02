package com.company.Solution;

public class FindMedianSortedArrays {
//
//    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
//    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
//    你可以假设 nums1 和 nums2 不会同时为空。
//
//    示例 1:
//
//    nums1 = [1, 3]
//    nums2 = [2]
//
//    则中位数是 2.0
//    示例 2:
//
//    nums1 = [1, 2]
//    nums2 = [3, 4]
//
//    则中位数是 (2 + 3)/2 = 2.5

    public double findMedianSortedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;

        double result1 =  (double)getKth(nums1, 0, n - 1, nums2, 0, m - 1, left);

        double result2 =  (double) getKth(nums1, 0, n - 1, nums2, 0, m - 1, right);
        System.out.println("result1: " +  result1);
        System.out.println("result2: " +  result2);

        return  (result1 + result2) * 0.5;
    }


    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);

        if (len1 == 0 ) return  nums2[start2 + k - 1];

        if (k == 1) return  Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return  getKth(nums1, start1, end1, nums2, j+1, end2, k-(j - start2 + 1));
        } else {
            return  getKth(nums1, i + 1, end1, nums2, start2, end2, k-(i - start1 + 1));
        }
    }







    //二分法
    public static int binary(int[] arr, int data) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            //这一步会造成溢出  当min和max的值过大的时候
//            mid = (min + max) / 2;

//            mid = min + (max - min) / 2;

            mid = min + ((max - min) >>> 1) ; //官方位运算
            if (arr[mid] > data) {
                max = mid - 1;
            } else if(arr[mid] < data) {
                min = mid + 1;
            } else  {
                return mid;
            }
        }

        return -1;
    }






}
