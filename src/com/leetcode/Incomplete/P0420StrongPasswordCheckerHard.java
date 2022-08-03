package com.leetcode.Incomplete;

/*

A password is considered strong if the below conditions are all met:

It has at least 6 characters and at most 20 characters.
It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
It does not contain three repeating characters in a row (i.e., "...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.

In one step, you can:
Insert one character to password,
Delete one character from password, or
Replace one character of password with another character.
 

Example 1:
Input: password = "a"
Output: 5

Example 2:
Input: password = "aA1"
Output: 3

Example 3:
Input: password = "1337C0d3"
Output: 0
 

Constraints:
1 <= password.length <= 50
password consists of letters, digits, dot '.' or exclamation mark '!'.

 */

public class P0420StrongPasswordCheckerHard
{

	public static void main(String[] args)
	{
		P0420StrongPasswordCheckerHard passCheck = new P0420StrongPasswordCheckerHard();
		System.out.println(passCheck.strongPasswordChecker("a")); // 5
		System.out.println(passCheck.strongPasswordChecker("aA1")); // 3
		System.out.println(passCheck.strongPasswordChecker("1337C0d3")); // 0
		System.out.println(passCheck.strongPasswordChecker("aaaB1")); // 1
		System.out.println(passCheck.strongPasswordChecker("aaaabbbbccccddeeddeeddeedd")); // 8
		System.out.println(passCheck.strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc")); // 8
		System.out.println(passCheck.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaaaaaaa")); // 12
		System.out.println(passCheck.strongPasswordChecker("asd1sDasdasdasdasdasaaa")); // 3
		System.out.println(passCheck.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); //36
		System.out.println(passCheck.strongPasswordChecker("aaaabbaaabbaaa123456A")); // 3
		System.out.println(passCheck.strongPasswordChecker("FFFFFFFFFFFFFFF11111111111111111111AAA")); // 23
	}

	public int strongPasswordChecker(String password)
	{
		char[] pass = password.toCharArray();
		int sLenC = sLengthCheck(pass);
		int lLenC = lLengthCheck(pass);
		int ascC = hasLowerCase(pass) + hasUpperCase(pass) + hasNumber(pass);
		int repC = hasRepeat(pass);
		
		
		if (lLenC > 0)
		{
			if ((repC - (lLenC / 3)) > lLenC)
			{
				return Math.max(lLenC, repC - (lLenC / 3)) + ascC;
			}
			return lLenC + Math.max(ascC, repC - (lLenC / 3));
		}
		
		return Math.max(Math.max(sLenC, ascC), repC);
	}

	public int sLengthCheck(char[] pass)
	{
		if (pass.length < 6)
		{
			return 6 - pass.length;
		}
		
		return 0;
	}
	
	public int lLengthCheck(char[] pass)
	{
		if (pass.length > 20)
		{
			return pass.length - 20;
		}
		
		return 0;
	}

	public int hasLowerCase(char[] pass)
	{
		for (char c : pass)
		{
			if (c <= 'z' && c >= 'a')
			{
				return 0;
			}
		}
		return 1;
	}

	public int hasUpperCase(char[] pass)
	{
		for (char c : pass)
		{
			if (c <= 'Z' && c >= 'A')
			{
				return 0;
			}
		}
		return 1;
	}

	public int hasNumber(char[] pass)
	{
		for (char c : pass)
		{
			if (c <= '9' && c >= '0')
			{
				return 0;
			}
		}
		return 1;
	}

	int highestRep = 0;
	public int hasRepeat(char[] pass)
	{
		int rep = 0;
		
		if (pass.length >= 3)
		{
			char prev = pass[0];
			int count = 1;
			for (int i = 1; i < pass.length; i++)
			{
				if (prev == pass[i])
				{
					count++;
				}
				else
				{
					rep = rep + (count / 3);
					if (count > highestRep)
					{
						highestRep = count;
					}
					count = 1;
				}
				prev = pass[i];
			}
			rep = rep + (count / 3);	
		}
		return rep;
	}
}
