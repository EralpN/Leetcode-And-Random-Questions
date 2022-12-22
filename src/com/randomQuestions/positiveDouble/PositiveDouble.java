package com.randomQuestions.positiveDouble;

import java.math.BigDecimal;

public class PositiveDouble {
//wrong

	public static void main(String[] args) {
		double i = 0;
		while (true) {
			i++;
			String num = String.valueOf(i);
			char temp = num.charAt(num.length() - 3);
			num = temp + num;
			double newi = Math.floor(Double.parseDouble(num) / 10);
			if ((double) newi / (double) i == 2) {
				System.out.println((new BigDecimal(i)).toString());
				break;
			}
		}

	}

}
