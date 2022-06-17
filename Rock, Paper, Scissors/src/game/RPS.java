package game;

import java.util.Random;
import java.util.Scanner;

public class RPS {
	public static void main(String[] args) {

		int computerMove;
		String compMove = "";
		Scanner scan = new Scanner(System.in);
		Random compNumber = new Random();
		System.out.print("Hey, let's play Rock, Paper, Scissors!\n" + "Please enter a move.\n" + "Rock = R, Paper"
				+ "= P, and Scissors = S.");

		computerMove = compNumber.nextInt(3) + 1 ;
		if (computerMove == 1) {
			compMove = "R";
		} else if (computerMove == 2) {
			compMove = "P";
		} else {
			compMove = "S";
		}
		System.out.print("\nEnter your move: ");
		String userInput = scan.next();
		userInput = userInput.toUpperCase();
		System.out.println("Computer played: " + compMove);
		if (userInput.equals(compMove)) {
			System.out.println("It's a tie!");
		} else if (userInput.equals("R")) {
			if (compMove.equals("S"))
				System.out.println("Rock crushes scissors. You win!!");
			else if (compMove.equals("P"))
				System.out.println("Paper eats rock. You lose!!");
		} else if (userInput.equals("P")) {
			if (compMove.equals("S"))
				System.out.println("Scissor cuts paper. You lose!!");
			else if (compMove.equals("R"))
				System.out.println("Paper eats rock. You win!!");
		} else if (userInput.equals("S")) {
			if (compMove.equals("P"))
				System.out.println("Scissor cuts paper. You win!!");
			else if (compMove.equals("R"))
				System.out.println("Rock breaks scissors. You lose!!");
		} else
			System.out.println("Invalid user input.");
		scan.close();
	}

}
