/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author IsoraDolage
 */
public class Main {
    public static void main(String[] args) {
    
        System.out.printf("♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣\n"
                + "\n" +
"                                      .------.\n" +
    "                   .------.           |A .   |   WELCOME TO TEXAS HOLD'EM POKER!!\n" +
"                   |A_  _ |    .------; / \\  |   \n" +
"                   |( \\/ )|-----. _   |(_,_) |   ENTER 1 TO ENTER THE GAME\n" +
"                   | \\  / | /\\  |( )  |  I  A|   ENTER 2 TO SELECT HELP\n" +
"                   |  \\/ A|/  \\ |_x_) |------'   ENTER 0 TO EXIT\n" +
"                   `-----+'\\  / | Y  A|\n" +
"                         |  \\/ A|-----'\n" +
"                         `------' \n" +
"♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣   ♠   ♦   ♥   ♣\n");
        
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
                        
                        else if (input == 2) {
                            help.viewRule();
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
