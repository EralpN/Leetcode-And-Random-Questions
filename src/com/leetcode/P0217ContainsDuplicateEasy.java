package com.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Input: nums = [1,2,3,1]
Output: true

Input: nums = [1,2,3,4]
Output: false

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

 */

public class P0217ContainsDuplicateEasy
{
	public static void main(String[] args)
	{
		P0217ContainsDuplicateEasy dupe = new P0217ContainsDuplicateEasy();
		int[] nums = {1,1,1,3,3,4,3,2,4,2};
		
		
		System.out.println(dupe.containsDuplicate(nums));

	}

	private boolean containsDuplicate(int[] nums)
	{
		boolean hasDuplicate = false;
		
		Set<Integer> tempSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		
		if (nums.length != tempSet.size())
		{
			hasDuplicate = true;
		}
		
		return hasDuplicate;
	}
}

