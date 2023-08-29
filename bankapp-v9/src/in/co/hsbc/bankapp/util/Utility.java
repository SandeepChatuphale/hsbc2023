package in.co.hsbc.bankapp.util;

import java.util.Arrays;

import in.co.hsbc.bankapp.model.BankAccount;

public class Utility 
{
	public static void print(BankAccount[] arr) 
	{
		for ( BankAccount b : arr) 
		{
			System.out.println(b);
		}
	}
	
	public static void sortBankAccount(BankAccount[] arr)
	{
		Arrays.sort(arr);
	}
}

