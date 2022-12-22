package com.leetcode;

/*

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

 */
public class P0004MedianOfTwoSortedArraysHard {

	public static void main(String[] args) {
		P0004MedianOfTwoSortedArraysHard med = new P0004MedianOfTwoSortedArraysHard();

		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };

		System.out.println(med.findMedianSortedArrays(nums1, nums2));

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1Len = nums1.length;
		int nums2Len = nums2.length;
		int numsLen = nums1Len + nums2Len;
		int[] nums = new int[numsLen];

		int in1 = 0;
		int in2 = 0;
		int in = 0;

		double result;

		while (in < numsLen) {
			if (in1 < nums1Len && in2 < nums2Len) {
				if (nums1[in1] <= nums2[in2]) {
					nums[in] = nums1[in1];
					in++;
					in1++;
				} else {
					nums[in] = nums2[in2];
					in++;
					in2++;
				}
			} else if (in1 < nums1Len) {
				nums[in] = nums1[in1];
				in++;
				in1++;
			} else {
				nums[in] = nums2[in2];
				in++;
				in2++;
			}
		}

		if (numsLen % 2 == 0) {
			result = nums[numsLen / 2] + nums[(numsLen / 2) - 1];
			return result / 2;
		} else {
			return nums[numsLen / 2];
		}
	}
}
