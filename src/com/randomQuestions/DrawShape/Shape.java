package com.randomQuestions.DrawShape;

import java.util.Scanner;

class Shape {
	private double edge1;
	private double edge2;
	private double edge3;
	private double edge4;
	private boolean exit;

	public void readInput() {
		while (!exit) {
			edge1 = 0;
			edge2 = 0;
			edge3 = 0;
			edge4 = 0;

			System.out.println("0 to conclude your shape, negative value to exit. (Max 4 edges!)");

			askUserEdges();

			switch (analyseShape()) {
			case "properShape":
				System.out.println("Perimeter: " + perimeter());
				System.out.println("Area: " + area());
				break;
			default:
				break;
			}
		}
	}

	private String analyseShape() {
		if (exit) {
			return "exit";
		} else {
			if (edge1 == 0) {
				System.err.println("Please enter data!");
				return "nodata";
			} else if (edge2 == 0 || edge1 == edge2 + edge3 + edge4 || edge2 == edge1 + edge3 + edge4
					|| edge3 == edge1 + edge2 + edge4 || edge4 == edge1 + edge2 + edge3) {
				// The shape is a line if an edge is equal to the sum of other edges.
				System.err.println("Your shape is just a line!");
				return "line";
			} else if (edge3 == 0) {
				System.err.println("Invalid Data!");
				return "invalid";
			} else if (edge1 > edge2 + edge3 + edge4 || edge2 > edge1 + edge3 + edge4 || edge3 > edge1 + edge2 + edge4
					|| edge4 > edge1 + edge2 + edge3) {
				// Shape is not possible if an edge is longer than the sum of other edges.
				System.err.println("Impossible shape!");
				return "impossible";
			} else if (edge4 == 0) {
				System.out.println("Your shape is a triangle!");
				return "properShape";
			} else {
				System.out.println("Your shape is a quadrangle!");
				return "properShape";
			}
		}

	}

	private void askUserEdges() {
		for (int i = 1; i <= 4; i++) {
			Scanner ask = new Scanner(System.in);
			System.out.print("Enter edge " + i + ": ");
			double value = ask.nextDouble();

			boolean end = false;
			switch ((value < 0) ? "exit" : (value == 0) ? "end" : "valid") {
			case "exit":
				System.err.println("Closing...");
				ask.close();
				exit = true;
				break;

			case "end":
				end = true;
				break;

			case "valid":
				if (i == 1) {
					edge1 = value;
				}
				if (i == 2) {
					edge2 = value;
				}
				if (i == 3) {
					edge3 = value;
				}
				if (i == 4) {
					edge4 = value;
				}
				continue;

			default:
				break;
			}

			if (exit || end) {
				break;
			}
		}
	}

	private double area() {
		double area;
		double semiPerimeter = perimeter() / 2;
		area = Math.sqrt(
				(semiPerimeter - edge1) * (semiPerimeter - edge2) * (semiPerimeter - edge3) * (semiPerimeter - edge4));
		return area;
	}

	private double perimeter() {
		double perimeter;
		perimeter = edge1 + edge2 + edge3 + edge4;
		return perimeter;
	}
}