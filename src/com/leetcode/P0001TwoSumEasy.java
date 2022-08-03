package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.

 */

public class P0001TwoSumEasy
{
	public static void main(String[] args)
	{
		P0001TwoSumEasy twoSum1 = new P0001TwoSumEasy();
		int[] nums = {3,2,4};
		int target = 6;
		System.out.println(Arrays.toString(twoSum1.twoSum(nums, target)));
	}
	
//	public int[] twoSum(int[] nums, int target)
//	{
//		int[] newNums = new int[2];
//		for (int i = 0; i < nums.length; i++)
//		{
//			if (target > i)
//			{
//				newNums[0] = i;
//				int numToSearch = target - nums[i];
//				for (int j = 0; j < nums.length; j++)
//				{
//					if (i != j)
//					{
//						if (nums[j] == numToSearch)
//						{
//							newNums[1] = j;
//							return newNums;
//						}
//					}
//				}
//			}
//			
//		}
//		return null;
//	}
	
	public int[] twoSum(int[] nums, int target)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] newNums = new int[2];
		for (int i = 0; i < nums.length; i++)
		{
			if (!map.containsKey(nums[i]))
			{
				map.put(nums[i], i);
			}
			else
			{
				if (target == 2 * nums[i])
				{
					newNums[0] = map.get(nums[i]);
					newNums[1] = i;
					return newNums;
				}
			}
		}
		
		for (int i = 0; i < nums.length; i++)
		{
			int diff = target - nums[i];
			if (map.containsKey(diff) && map.get(diff) != i)
			{
				newNums[0] = i;
				newNums[1] = map.get(diff);
				return newNums;
			}
		}
		
		return null;
	}
}
