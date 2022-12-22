package com.leetcode;

public class P0006ZigzagConversionMedium
{

//	1 <= s.length <= 1000
//	s consists of English letters (lower-case and upper-case), ',' and '.'.
//	1 <= numRows <= 1000
	
	public static void main(String[] args) {
		P0006ZigzagConversionMedium q = new P0006ZigzagConversionMedium();

		String inputString = "PAYPALISHIRING";
		System.out.println(q.convert(inputString, 2));
		/* 
		 P Y A I H R N
		 A P L S I I G
		 Output: "PYAIHRNAPLSIIG"
		 */
		System.out.println(q.convert(inputString, 3));
		/* 
		 P   A   H   N
		 A P L S I I G
		 Y   I   R
		 Output: "PAHNAPLSIIGYIR"
		 */
		System.out.println(q.convert(inputString, 4));
		/*
		 P     I    N
		 A   L S  I G
		 Y A   H R
		 P     I
		 Output: "PINALSIGYAHRPI"
		 */
		System.out.println(q.convert(inputString, 5));
		/*
		 P       H
		 A     S I
		 Y   I   R
		 P L     I G
		 A       N
		 Output: "PHASIYIRPLIGAN"
		 */
		System.out.println(q.convert(inputString, 7));
		/*
		 P           N
		 A         I G
		 Y       R
		 P     I
		 A   H
		 L S
		 I
		 Output: "PNAIGYRPIAHLSI"
		 */
		System.out.println(q.convert("A", 1));
	}

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		char[] chars = s.toCharArray();
		int length = chars.length;
		String zigzagString = "";
		int spaceBetweenColumns = numRows - 2;

		for (int row = 0; row < numRows; row++) {
			// Start and End Rows
			if (row == 0 || row == (numRows - 1)) {
				for (int i = row; i < length; i += (numRows + spaceBetweenColumns)) {
					zigzagString += chars[i];
				}
			}
			// Other Rows
			else {
				boolean wide = false;
				for (int i = row; i < length; i += wide ? 2 * (numRows - row - 1) : 2 * row) {
					zigzagString += chars[i];
					wide = !wide;
				}
			}
		}
		return zigzagString;
	}
}
