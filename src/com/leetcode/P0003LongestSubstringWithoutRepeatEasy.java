package com.leetcode;

import java.util.HashSet;

/*

Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */
public class P0003LongestSubstringWithoutRepeatEasy {

	public static void main(String[] args) {
		P0003LongestSubstringWithoutRepeatEasy len = new P0003LongestSubstringWithoutRepeatEasy();

		System.out.println(len.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(len.lengthOfLongestSubstring("bbbbb"));
		System.out.println(len.lengthOfLongestSubstring("pwwkew"));
		System.out.println(len.lengthOfLongestSubstring("dvdf"));
	}

	public int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		int index = 0;
		int count = 0;
		int longest = 0;
		HashSet<Character> set = new HashSet<>();

		for (Character c : chars) {
			if (set.add(c)) {
				count++;
				if (count > longest) {
					longest = count;
				}
			} else {
				set.clear();
				int tempCount = index - count + 1;
				count = 0;
				for (int i = tempCount; i <= index; i++) {
					if (set.add(chars[i])) {
						count++;
					} else {
						set.clear();
						i = tempCount;
						tempCount++;
						count = 0;
					}
				}
			}
			index++;
		}

		return longest;
	}
}
