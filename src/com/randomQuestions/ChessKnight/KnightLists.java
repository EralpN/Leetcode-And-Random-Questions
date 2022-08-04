package com.randomQuestions.ChessKnight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// this question is solved using lists and maps for learning purposes.

public class KnightLists
{
	private static boolean exit = false;
	private static String knightCharacter = "🐴";
	private static String moveCharacter = "⚔";

	private HashMap<String, String> chessBoard = new HashMap<String, String>();
	private List<String> canMoveTo = new ArrayList<String>();
	private String knight;

	public static void main(String[] args)
	{

		KnightLists chessGame = new KnightLists();

		chessGame.knight = chessGame.initiateKnight();
		while (!exit)
		{
			chessGame.initiateChessBoard();
			chessGame.placeKnight();
			chessGame.printChessBoard();
			chessGame.moveKnight();
		}
		System.out.println("Terminating.");
	}

	private String initiateKnight()
	{
		Scanner ask = new Scanner(System.in);
		System.out.print("Where is the knight? (a1 to h8) (type exit to terminate): ");
		String knight = ask.nextLine();
		if (knight.equals("exit"))
		{
			exit = true;
			ask.close();
		}
		System.out.println();
		return knight;
	}

	private void initiateChessBoard()
	{
		for (int column = 7; column >= 0; column--)
		{
			for (char row = 'a'; row <= 'h'; row++)
			{
				column++;
				String position = String.valueOf(row) + column;
				column--;
				chessBoard.put(position, "");
			}
		}
	}

	private void placeKnight()
	{
		int row = knight.charAt(1) - '0';
		char column = (char) (knight.charAt(0));

		ArrayList<String> allMoves = new ArrayList<String>(chessBoard.keySet());

		for (String move : allMoves)
		{
			if (!move.equals(""))
			{
				if (move.equals(column + Integer.toString(row)))
				{
					chessBoard.replace(column + Integer.toString(row), knightCharacter);
					
					if (allMoves.contains((char)(column + 2) + Integer.toString(row + 1)))
					{
						chessBoard.replace((char)(column + 2) + Integer.toString(row + 1), moveCharacter);
						canMoveTo.add((char)(column + 2) + Integer.toString(row + 1));
					}
					if (allMoves.contains((char)(column + 2) + Integer.toString(row - 1)))
					{
						chessBoard.replace((char)(column + 2) + Integer.toString(row - 1), moveCharacter);
						canMoveTo.add((char)(column + 2) + Integer.toString(row - 1));
					}
					if (allMoves.contains((char)(column - 2) + Integer.toString(row + 1)))
					{
						chessBoard.replace((char)(column - 2) + Integer.toString(row + 1), moveCharacter);
						canMoveTo.add((char)(column - 2) + Integer.toString(row + 1));
					}
					if (allMoves.contains((char)(column - 2) + Integer.toString(row - 1)))
					{
						chessBoard.replace((char)(column - 2) + Integer.toString(row - 1), moveCharacter);
						canMoveTo.add((char)(column - 2) + Integer.toString(row - 1));
					}
					if (allMoves.contains((char)(column + 1) + Integer.toString(row + 2)))
					{
						chessBoard.replace((char)(column + 1) + Integer.toString(row + 2), moveCharacter);
						canMoveTo.add((char)(column + 1) + Integer.toString(row + 2));
					}
					if (allMoves.contains((char)(column - 1) + Integer.toString(row + 2)))
					{
						chessBoard.replace((char)(column - 1) + Integer.toString(row + 2), moveCharacter);
						canMoveTo.add((char)(column - 1) + Integer.toString(row + 2));
					}
					if (allMoves.contains((char)(column + 1) + Integer.toString(row - 2)))
					{
						chessBoard.replace((char)(column + 1) + Integer.toString(row - 2), moveCharacter);
						canMoveTo.add((char)(column + 1) + Integer.toString(row - 2));
					}
					if (allMoves.contains((char)(column - 1) + Integer.toString(row - 2)))
					{
						chessBoard.replace((char)(column - 1) + Integer.toString(row - 2), moveCharacter);
						canMoveTo.add((char)(column - 1) + Integer.toString(row - 2));
					}
				}

			}
		}
	}

	private void printChessBoard()
	{

		List<String> allMoves = new ArrayList<String>(chessBoard.keySet());
		Collections.sort(allMoves);

		for (int i = 8; i > 0; i--)
		{
			for (int index = 0; index < chessBoard.size(); index++)
			{
				int temp1 = allMoves.get(index).charAt(1) - '0';
				if (temp1 == i)
				{
					if (chessBoard.get(allMoves.get(index)).equals(""))
					{
					System.out.print(allMoves.get(index) + " ");
					}
					else
					{
					System.out.print(chessBoard.get(allMoves.get(index)) + " ");
					}
				}
			}
		System.out.println();
		}
		System.out.println();
	}

	private void moveKnight()
	{
		boolean invalidInput = true;
		Scanner ask = new Scanner(System.in);

		System.out.print("Knight can move to ");
		System.out.print(canMoveTo);
		System.out.println("!");
		
		do
		{
			System.out.print("What is knights next move? (type exit to terminate): ");
			knight = ask.nextLine();

			if (knight.equals("exit"))
			{
				exit = true;
				ask.close();
				break;
			}
			else
			{
				for (String moveable : canMoveTo)
				{
					if (knight.equals(moveable))
					{
						invalidInput = false;
					}
				}
			}
			System.out.println();
		}
		while (invalidInput);
		canMoveTo.clear();
	}

}
