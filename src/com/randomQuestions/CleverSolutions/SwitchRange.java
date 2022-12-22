package com.randomQuestions.CleverSolutions;

import java.util.Scanner;

public class SwitchRange {

	public static void main(String[] args) {
		Scanner ask = new Scanner(System.in);
		System.out.print("Exam Grade: ");
		double grade = ask.nextDouble();
		ask.close();

		switch ((0 <= grade && grade <= 50) ? "0:50" : (51 <= grade && grade <= 100) ? "51:100" : "Not Between 0:100") {

		case "0:50":
			System.out.println("Fail!");
			break;
		case "51:100":
			System.out.println("Pass!");
			break;
		case "Not Between 0:100":
			System.out.println("Invalid Grade!");
			break;
		}
	}
}