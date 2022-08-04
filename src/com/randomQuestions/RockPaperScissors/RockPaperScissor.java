package com.randomQuestions.RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor
{

	public static void main(String[] args)
	{

		System.out.println("Can you beat the mighty computer in a game of Rock Paper Scissor? \nGames are played as best of 3, the winner of the game gains a score! \nGood Luck! (you can exit anytime by typing \"stop\")\n ");
		
		int computerScore = 0;
		int playerScore = 0;
		
		
		while (true)
		{
			
			int pointPlayer = 0;
			int pointComputer = 0;
			
			for (int i = 0; i < 3; i++)
			{
				String computer = null;
				Random random = new Random();
				int randomNumber = random.nextInt(3);
				
				switch (randomNumber)
				{
				case 0:
					computer = "rock";
					break;
				case 1:
					computer = "paper";
					break;
				case 2:
					computer = "scissors";
					break;
				default:
					System.exit(0);
				}
					
				System.out.println("\t\"stop\" to quit\n\tComputer has decided on its next move!");
				
				Scanner game = new Scanner(System.in);
				String player;
				System.out.println("\t***************Choose!****************\n\t\tRock, Paper, Scissors!\n");
				player = game.next().trim().toLowerCase();
				
				if (player.trim().toLowerCase().equals("stop"))
				{
					if (computerScore > playerScore)
					{
						System.out.println("\tSo you have decided to give up...\n\tUnderstandable not many can win againts the mighty computer!");
						game.close();
						System.exit(0);
					}
					else if (computerScore == playerScore)
					{
						System.out.println("\tWe should have played more there isnt even a clear winner...\n\tAnyway, play again later, bye!");
						game.close();
						System.exit(0);
					}
					else
					{
						System.out.println("\tYou are a worthy challenger, your score is ahead of me...\n\tI will gladly play again with you, bye for now!");
						game.close();
						System.exit(0);
					}
				}
				
				while(!(player.equals("rock")  || player.equals("paper") || player.equals("scissors")))
				{
					System.out.println("You can only choose between Rock, Paper and Scissors!");
					player = game.next().trim().toLowerCase();
				}
				
				String condition = null;
				
				if ((player + computer).equals("rockrock") || (player + computer).equals("scissorsscissors") || (player + computer).equals("paperpaper"))
				{
					condition = "draw";
				}
				else if ((player + computer).equals("rockscissors") || (player + computer).equals("scissorspaper") || (player + computer).equals("paperrock"))
				{
					condition = "win";
				}
				else if ((player + computer).equals("rockpaper") || (player + computer).equals("scissorsrock") || (player + computer).equals("paperscissors"))
				{
					condition = "lose";
				}
				else
				{
					System.exit(0);
				}
				
				switch(condition)
				{
				case "draw":
					System.out.println("\n\tDraw! you have both choose " + player + "!\n");
					i--;
					break;
				case "win":
					System.out.println("\n\tYou win, computer choose " + computer + ".\n");
					pointPlayer = pointPlayer + 1;
					break;
				case "lose":
					System.out.println("\n\tYou lose, computer choose " + computer + ".\n");
					pointComputer = pointComputer + 1;
					break;
				default:
					System.exit(0);
				}
				
				System.err.println("\tCurrent points in this round:\n" + "\n\tPlayer: " + pointPlayer + "\tComputer: " + pointComputer + "\n");
				
				if (pointPlayer == 2 || pointComputer == 2)
				{
					if (pointPlayer > pointComputer)
					{
						System.out.println("You have won this round " + pointPlayer + " to " + pointComputer + "!");
						playerScore = playerScore + 1;
						System.err.println("\n\t###########################################\n\t###\tPlayer: " + playerScore + "\tComputer: " + computerScore +"\t###\n\t###########################################\n");
						break;
					}
					else
					{
						System.out.println("You have lost this round " + pointComputer + " to " + pointPlayer + "!");
						computerScore = computerScore + 1;
						System.err.println("\n\t###########################################\n\t###\tPlayer: " + playerScore + "\tComputer: " + computerScore +"\t###\n\t###########################################\n");
						break;
					}
				}
				
				
			}
		}
		
		
		
		
		
		
		

	}

}
