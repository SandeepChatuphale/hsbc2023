package in.co.hsbc.bankapp.model;
import java.io.Serializable;
import java.util.Date;

import in.co.hsbc.bankapp.util.Printable;

public class BankAccount extends Object implements Printable,Comparable,Serializable
{
	/*instance variable is created when object is created 
	 *Every Object has separate copy of instance variables  
	 */
	
	private final int MINIMUM_BALANCE = 500;
	
	private int accountNumber;
	private String holderName;	//has-a relationship
	private double balance;
	private Date openingDate; //has-a relationship
	
	private static int count;	//This is independent of object
								//This is class property
								//this is created when class is loaded
								//This is shared among instances
								//of the same class
	
	//static initialization block
	//used to initialization static variables
	//executed only once when class is loaded
	static
	{
		count = 1000;
	}
	
	//constructor
	//used to initialize instance variables
	//automatically executes when object is created
	//same name with class name , no return type
	private BankAccount()//No-argument constructor
	{
		count++;
		accountNumber = count;
		holderName = "Guest";
		balance = 5000;
		openingDate = new Date();
	}
	
	//parameterized constructor
	public BankAccount(String holderName
					  ,double balance)
	{
		//instanceVariable=localVariable
		count++;
		this.accountNumber = count;
		this.holderName = holderName;
		this.balance = balance;
		this.openingDate = new Date();
	}
	
	public static int getCount()
	{
		return count;
	}
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public Date getOpeningDate()
	{
		return openingDate;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	@Override
	public void print()
	{
		System.out.println("Account Number is " + accountNumber);
		System.out.println("Account Holder is " + holderName);
		System.out.println("Balance " + balance);
		System.out.println("Opening Date " + openingDate);
	}
	
	//THis is a special method - callback method
	@Override
	public String toString()
	{
		return "Account Number " + accountNumber+ " Holder Name is " 
								+ holderName  + " Balance is " + balance  
								+"  Opening Date "  + openingDate;
	}
	
	public void deposit(double amount)
	{
		System.out.println("Depositing " + amount );
	}

	public void withdraw(double amount)
	{
		System.out.println("Withdrawing" + amount );
	}

	//This method is from Comparable interface
	//This method MUST specify sorting criteria (by balance)
	//This is Contract we are following given by sort() method of Arrays class
	@Override
	public int compareTo(Object o) 
	{
		System.out.println("In compareTo");
		//this is casting of reference variable
		//so that subclass specific instance variable can be accessed
		BankAccount a = (BankAccount)o;
		
		
		return (int) (this.balance - a.balance);//checking which balance is greater
	}
	
	
	//This method is equality test for objects of BankAccount
	//It is present in Object super class 
	//BankAccount class is overriding
//	@Override
//	public boolean equals(Object o)
//	{
//		System.out.println("in equals()");
//		BankAccount account = (BankAccount) o; 
//		if(this.getHolderName().equals(account.getHolderName()))
//			return true;
//		return false;
//	}
	
	//THis is method from Object super class
	//It is used to improve performance is "hashing algorithm"
	//It is responsibility of Developer to write appropriate implementation
	//(Meaning it should make sure search happens faster)
	@Override
	public int hashCode()
	{
		System.out.println("in hashCode()");
		return 1;//currently this is BAD implementation
				 /** TO-DO - improve this
				  * 
				  */
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}













