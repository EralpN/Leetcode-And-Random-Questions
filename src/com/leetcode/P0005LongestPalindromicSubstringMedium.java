package com.leetcode;

/*

Given a string s, return the longest palindromic substring in s.


Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
 

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.

 */
public class P0005LongestPalindromicSubstringMedium
{

	public static void main(String[] args)
	{
		P0005LongestPalindromicSubstringMedium pal = new P0005LongestPalindromicSubstringMedium();
		System.out.println(pal.longestPalindrome("babad"));
		System.out.println(pal.longestPalindrome("ac"));
		System.out.println(pal.longestPalindrome("abcba"));
		System.out.println(pal.longestPalindrome("abb"));
		System.out.println(pal.longestPalindrome("cbbd"));
		System.out.println(pal.longestPalindrome("aacabdkacaa"));
	}

	public String longestPalindrome(String s)
	{
		char[] chars = s.toCharArray();
		int len = chars.length;
		String highestEven = "";
		String highestOdd = "" + chars[0];

		if (len == 1)
		{
			return highestOdd;
		}
		
		if (len >= 2)
		{
			for (int i = 0, j = 1; j < len; i++, j++)
			{
				int iTemp = i;
				int jTemp = j;
				String tempHighest = "";

				while (!(iTemp < 0 || len <= jTemp))
				{
					if (chars[iTemp] == chars[jTemp])
					{
						tempHighest = chars[iTemp] + tempHighest + chars[jTemp];
						if (tempHighest.length() > highestEven.length())
						{
							highestEven = tempHighest;
						}
					}
					else
					{
						break;
					}
					iTemp--;
					jTemp++;
				}

			}
		}
		if (len >= 3)
		{
			for (int i = 0, j = 2; j < len; i++, j++)
			{
				int iTemp = i;
				int jTemp = j;
				String tempHighest = "" + chars[i + 1];

				while (!(iTemp < 0 || len <= jTemp))
				{
					if (chars[iTemp] == chars[jTemp])
					{
						tempHighest = chars[iTemp] + tempHighest + chars[jTemp];
						if (tempHighest.length() > highestOdd.length())
						{
							highestOdd = tempHighest;
						}
					}
					else
					{
						break;
					}
					iTemp--;
					jTemp++;
				}

			}
		}
		if (highestOdd.length() > highestEven.length())
		{
			return highestOdd;
		}
		return highestEven;
	}
}
