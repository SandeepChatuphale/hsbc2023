package in.co.hsbc.bankapp.view.impl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import in.co.hsbc.bankapp.model.BankAccount;
import in.co.hsbc.bankapp.view.BankAccountView;

public class BankAccountConsoleViewImpl implements BankAccountView{

	private Scanner sc ;

	public BankAccountConsoleViewImpl() {
		sc = new Scanner(System.in);
	}

	public void printAll(List<BankAccount> accounts)
	{
		System.out.println("Account Number \t Name \t Balance \t Opening Date");
		for (BankAccount bankAccount : accounts) {
			System.out.println(bankAccount.getAccountNumber() + "\t\t" + bankAccount.getHolderName() + "\t"
					+ bankAccount.getBalance() + "\t" + bankAccount.getOpeningDate());
		}
	}

	@Override
	public BankAccount accept() 
	{
		try
		{
			System.out.println("Enter Account Number");
			int accountNumber = sc.nextInt();
			System.out.println("Enter New Name");
			String holderName = sc.next();
			System.out.println("Enter New Balance");
			double balance = sc.nextDouble();
			BankAccount account = new BankAccount(holderName, balance);
			account.setAccountNumber(accountNumber);
			return account;
		}
		catch (InputMismatchException e) 
		{
			showErrorMessage("Invalid Input");
		}
		return null;
	}

	@Override
	public void showSuccessMessage(String msg) {
		System.out.println(msg);
	}

	@Override
	public void showErrorMessage(String msg) {
		System.err.println(msg);
	}

	@Override
	public int showMenu() {
		System.out.println("Welcome to BankApp");
		System.out.println("1. Create New Account");
		System.out.println("2. Find By Account Number");
		System.out.println("3. Update Account");
		System.out.println("4. Find All");
		System.out.println("5. Sort Accounts By Balance");
		System.out.println("6. Delete By Id");
		System.out.println("-1. Exit");
		int option = sc.nextInt();
		return option;
	}

	@Override
	public int acceptAccountNumber() {
		System.out.println("Enter Account Number");
		int accountNumber = sc.nextInt();
		return accountNumber;
	}

	@Override
	public void printBankAccount(BankAccount account) {
		System.out.println(account);

	}

	@Override
	public void close() {
		sc.close();
	}
}




