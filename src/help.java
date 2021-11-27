
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IsoraDolage
 */
public class help {
    public static void viewRule() {    
        System.out.println("\n♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣  HOW TO PLAY  ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   \n");
        System.out.println("\nThe deck is shuffled and the dealer deals two cards face down to each player.\n"
                            + "These cards are your Hole Cards or Pocket Cards.\n"                
                            + "The game has ten rounds. Each round contains three stages. FLOP, TURN and RIVER.\n"
                            + "The five community cards are dealt in these three stages.\n"
                            + "In each round When it's your turn,you can make a choice to either dicard your hand or keep it.\n"
                            + "All players hands are shown at the show down.\n"
                            + "At the end of each round the winner will receive points according to the ranking of the hand.\n"
                            + "The winner of the tournament will be the player with the highest score at the end of all 10 rounds.\n\n"
                            + "Here are the \"Ranks of Hands\": \n"
                            + "High Card        -   One card high, plus four unmatched lower ranking cards.\n"
                            + "One Pair         -   Two cards of the same rank, plus Three unmatched cards.\n"
                            + "Two Pair         -   Two cards of the same rank, plus Two cards of another rank.\n"
                            + "Three Of A Kind  -   Three cards of the same rank, plus two unmatched cards.\n"
                            + "Straight         -   Five cards of sequential rank, but different suit.\n"
                            + "Flush            -   Five cards of the same suit.\n"
                            + "Full House       -   Three matching cards of one rank, plus Two matching cards of another rank.\n"
                            + "Four Of A Kind   -   Four cards of one rank.\n"
                            + "Straight Flush   -   Five cards in sequence, all of the same suit.\n"
                            + "Royal Flush      -   A, K, Q, J, 10, all in the same suit.\n\n"
                            + "Here's how the points are allocated to each rank:\n"
                            + "High Card        -   1    point\n"
                            + "One Pair         -   2    points\n"
                            + "Two Pair         -   3    points\n"
                            + "Three Of A Kind  -   4    points\n"
                            + "Straight         -   5    points\n"
                            + "Flush            -   6    points\n"
                            + "Full House       -   7    points\n"
                            + "Four Of A Kind   -   8    points\n"
                            + "Straight Flush   -   10   points\n"
                            + "Royal Flush      -   20   points\n\n"
                            + "~~~~~~~~~~        GOOD LUCK!        ~~~~~~~~~~\n");
        System.out.println("\nInput number to select an option: ");
	System.out.println("1. Start Game");
	System.out.println("0. Exit");
        
        Scanner scanner = new Scanner(System.in);
        int input;

while(true) {
			try {
				System.out.print("\nENTER YOUR CHOICE HERE: ");
				input = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Input is not vaild");
				scanner.next();
				continue;
			}
                        
                        if (input == 1) {
                            start level = new start();
                            break;
                        }
                       else if (input == 0) {
                            scanner.close();
			    System.out.println("Program is terminated!");
			    System.exit(0);
                        }
                        else {
			    System.out.println("Wrong Input");				
			}
}
    }
}
