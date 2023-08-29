package in.co.hsbc.bankapp.dao.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import in.co.hsbc.bankapp.dao.BankAccountDao;
import in.co.hsbc.bankapp.dao.exception.DataStoreFullException;
import in.co.hsbc.bankapp.model.BankAccount;

public class BankAccountFileDaoImpl implements BankAccountDao{

	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private List<BankAccount> accounts;
	
	private final String FILE_NAME = "accounts.txt"; 

	public BankAccountFileDaoImpl() throws IOException
	{
		this.accounts = new ArrayList<>();
		fos = new FileOutputStream(FILE_NAME,true);
		oos = new ObjectOutputStream(fos);
		fis = new FileInputStream(FILE_NAME);
		ois = new ObjectInputStream(fis);
	}

	@Override
	public int save(BankAccount account) throws DataStoreFullException {

		accounts.add(account);
		
		try 
		{
			oos.writeObject(accounts);
			
			return 1;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public BankAccount findByAccountNumber(int accNo)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount[] findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount updateAccount(BankAccount account) {
		return null;
	}


	@Override
	public List<BankAccount> findAllBankAccounts() {

		try
		{
			while(fis.available()>0)
			{
				
				accounts =(List<BankAccount>) ois.readObject();
			}
			System.out.println(accounts.size());
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public boolean deleteByAccountNumber(int accountNumber) {
		return false;
	}

	@Override
	public void close() throws Exception {

		fos.close();
		oos.close();
		fis.close();
		ois.close();
	}

	
}