/*
 * @Author: Dion de jong
 * @Version 1.0
 * 09-22-2013
 * This is the PlayDice class. It is the driver that combines the downloaded Die class and ShowDie class,
 *  as well as my BankAccount class to allow two users to play a game of dice. They will create a bank account 
 *  object from which they will wager money and either win more or less their own, depending on how the dice roll. 
 */

//The scanner import that is used to retrieve user values for name and wager. 
import java.util.Scanner;


public class PlayDice
{
	//main method
	public static void main(String[] args) 

	{
		//This creates the scanner used throughout the program. 
		Scanner keyboard = new Scanner(System.in); 
		//initializes the name variables used to construct bank account objects. 
		String name1;
		String name2; 

		//initial display. 
		System.out.println("Welcome to the Dice Game. Soon you will enter a wager and be able to gamble!");


		//Create the two accounts
		//Assign values to variables by retrieving input and saving based on user input.
		System.out.println("Player 1, please enter your name."); 
		name1 = keyboard.nextLine(); 
		BankAccount player1 = new BankAccount(name1);
		System.out.println("Player 2, please enter your name."); 
		name2 = keyboard.nextLine(); 
		BankAccount player2 = new BankAccount(name2);

		//initialize the wager variable
		int wager1;
		int wager2; 
		//ask the user for their initial wager and save it under the wager variable. This allows the while statement to begin running.
		System.out.println("Player 1, what is your wager?");
		wager1 = keyboard.nextInt();
		System.out.println("Player 2, what is your wager?");
		wager2 = keyboard.nextInt();


		//Create a while statement that will run the game until a user quits or tries to cheat. 
		while (wager1 != 0 && (wager1 < player1.getBalance()) && wager2 != 0 && (wager2 < player2.getBalance())) 
		{
			//construct the two dice objects
			Die Die1 = new Die();
			Die Die2 = new Die();
			//initiate the dice so they roll and generate values
			int Roll1 = Die1.roll();
			int Roll2 = Die2.roll();
			//tell the users what they rolled
			System.out.println("The dice rolled as a " + Roll1 + " and a " + Roll2 +".");
			//display the jpane showing the two rolled dice.
			ShowDie Die1Draw = Die1.display(0, 0);
			ShowDie Die2Draw = Die2.display(110, 0);
			//create a variable based on the sum of the two rolls. 
			int totalRoll = Roll1 + Roll2;

			//if the roll is between 7-12, player 1 wins. 
			if (totalRoll > 6) 
			{
				System.out.println("The dice rolled to be more than 6, player 1 wins. Congratulations. Take some money.");
				/* this should call the deposit method from the Bank Account class for player 1's account, which should take player 1's
				 * wager and add it to their existing Balance. It should call the withdraw method for player 2's account 
				 * and withdraw player 2's wager from the account. 
				 */
				player1.Deposit(wager1);
				player2.Withdraw(wager2);
				//Statement displays new balance after win for player 1 is added and loss for player 2 is taken away. 
				player1.DisplayAccount();
				player2.DisplayAccount();

			}
			//if the dice rolls 6 or less, player 2 wins. 
			else 
			{
				System.out.println("The dice rolled to be less than 7, player 2 wins. Congratulations. Take some money.");
				/* this should call the deposit method from the Bank Account class for player 2's account, which should take player 2's
				 * wager and add it to their existing Balance. It should call the withdraw method for player 1's account 
				 * and withdraw player 1's wager from the account. 
				 */
				player2.Deposit(wager2);
				player1.Withdraw(wager1);
				//Statement displays new balance after win for player 2 is added and loss for player 1 is taken away.
				player2.DisplayAccount();
				player1.DisplayAccount();
			}
			//Get the new input for the new wagers for the game to continue 
			System.out.println("Player 1, what is your wager?");
			wager1 = keyboard.nextInt();
			System.out.println("Player 2, what is your wager?");
			wager2 = keyboard.nextInt();
		}
		//if player 1 or 2 has typed a 0, this message will display.
		if (wager1 == 0 || wager2 ==0)
		{
			System.out.println("Either player 1 or player 2 has quit."); 
		}
		//if player 1 or 2 tries to cheat, this message should display. 
		else if (wager1 > player1.getBalance() || wager2 > player2.getBalance() )
		{
			System.out.println("Either player 1 or player 2 has attempted to cheat. Cheaters ruin fun for everyone."); 
		}
	}
} 