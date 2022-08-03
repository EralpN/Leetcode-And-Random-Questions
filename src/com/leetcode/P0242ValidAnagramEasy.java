package com.leetcode;

import java.util.HashMap;

/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

 */

public class P0242ValidAnagramEasy
{
	public static void main(String[] args)
	{
		P0242ValidAnagramEasy anagram = new P0242ValidAnagramEasy();
		
		System.out.println(anagram.isAnagram("nagaram", "anagram"));
	}

	public boolean isAnagram(String s, String t)
	{
		if (s.length() != t.length())
		{
			return false;
		}
		
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		
		HashMap<Character, Integer> sMap = new HashMap<>();
		HashMap<Character, Integer> tMap = new HashMap<>();
		
		for (char sChar : sArray)
		{
			Integer num = sMap.putIfAbsent(sChar, 1);
			if (num != null)
			{
				sMap.put(sChar, num + 1);
			}
		}
		
		for (char tChar : tArray)
		{
			Integer num = tMap.putIfAbsent(tChar, 1);
			if (num != null)
			{
				tMap.put(tChar, num + 1);
			}
		}
		
		if (sMap.equals(tMap))
		{
			return true;
		}
		return false;
	}
}
