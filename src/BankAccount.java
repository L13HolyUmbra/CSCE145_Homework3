
/*
 * @Author: Dion de jong
 * @Version 1.0
 * 09-22-2013
 * This is the BankAccount class that contains methods for constructing a bank account object as well as getting it, displaying it,
 * depositing to it, and withdrawing from it. 
 */


//main class name
public class BankAccount 
{
	//instance variables that this class uses. These will be changed by the constructor. 
	String accountHolder = null; 
	int CurrentBalance = 0; 

	//Constructor
	public BankAccount(String name)
	{
		accountHolder = name; 
		CurrentBalance = 1000; 
	}

	//This is the getter, it returns the variable CurrentBalance (The money in the user's account.)
	public int getBalance()
	{
		return (CurrentBalance);
	}

	//this will show the details of the current user's account. 
	public void DisplayAccount()
	{
		System.out.println("The player:" + accountHolder + " has a current balance of:" + CurrentBalance);
	}

	/**
	 * deposit
	 * parameter(int)
	 * return int
	 */
	//this should deposit a set amount of money from the wager made in the game to the account. 
	public int Deposit(int wager)
	{
		//the user's new balance is the wager + the money they had. 
		CurrentBalance = wager + CurrentBalance;
		return CurrentBalance;

	}

	/**
	 * withdraw
	 * parameter(int)
	 * return int
	 */
	//this should withdraw the amount of money from a lost wager from the user's current balance. 
	public int Withdraw(int wager)
	{
		//the user's new balance is the the money they had - the wager. 
		CurrentBalance = CurrentBalance - wager; 
		return (CurrentBalance); 
	}
}


