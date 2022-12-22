package com.leetcode;

import java.util.Set;

public class P0008StringToInteger_atoi_Medium {

	public static void main(String[] args) {
		P0008StringToInteger_atoi_Medium q = new P0008StringToInteger_atoi_Medium();
		System.out.println(q.myAtoi("     -- 34"));
		System.out.println(q.myAtoi("2147483647"));
		System.out.println(q.myAtoi("-2147483648"));
		System.out.println(q.myAtoi("   -42"));
		System.out.println(q.myAtoi("42"));
		System.out.println(q.myAtoi("4193 with words"));
		System.out.println(q.myAtoi("+-12")); // -12
		System.out.println(q.myAtoi("-+12")); // 0

	}

	public int myAtoi(String s) {
		char[] chars = s.toCharArray();
		Set<Character> digits = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
		String output = "";
		boolean negative = false;
		boolean prevDigit = false;
		boolean prevSign = false;
		boolean prevZero = false;
		// collects digit values in output String
		for (char c : chars) {
			if (c == ' ') {
				if (prevSign || prevDigit || prevZero) {
					break;
				}
			} else if (c == '-') {
				// silly edge case
				if (prevSign || prevDigit || prevZero) {
					break;
				}
				prevSign = true;
				negative = true;
			} else if (c == '+') {
				if (prevSign || prevDigit || prevZero) {
					break;
				}
				prevSign = true;
			} else if (digits.contains(c)) {
				if (c != '0') {
					prevDigit = true;
				} else {
					prevZero = true;
				}
				if (prevDigit) {
					output += c;
				}
			} else {
				break;
			}
		}
		// appends 0 to output to make its length 10
		StringBuilder sb = new StringBuilder();
		if (output.length() < 10) {
			for (int i = 10 - output.length(); i > 0; i--) {
				sb.append('0');
			}
			sb.append(output);
			output = sb.toString();
		}
		// checks if value exceeds max/min integer
		if (output.compareTo("2147483647") > 0 || output.length() > 10) {
			if (negative) {
				return -2147483648;
			} else {
				return 2147483647;
			}
		}
		// returns
		if (negative) {
			return -Integer.parseInt(output);
		}
		return Integer.parseInt(output);
	}
}
