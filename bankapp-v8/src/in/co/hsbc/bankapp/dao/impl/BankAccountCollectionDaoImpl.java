package in.co.hsbc.bankapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import in.co.hsbc.bankapp.dao.BankAccountDao;
import in.co.hsbc.bankapp.dao.exception.RecordNotFoundException;
import in.co.hsbc.bankapp.model.BankAccount;

public class BankAccountCollectionDaoImpl implements BankAccountDao{

	private List<BankAccount> accounts;
	
	public BankAccountCollectionDaoImpl() {
		accounts = new ArrayList<BankAccount>();
	}
	
	@Override
	public int save(BankAccount account) {
		this.accounts.add(account);
		return 1;
	}

	@Override
	public BankAccount findByAccountNumber(int accNo) throws RecordNotFoundException {
		for (BankAccount bankAccount : accounts) {
			if(bankAccount.getAccountNumber() == accNo)
				return bankAccount;
		}
		throw new RecordNotFoundException(accNo, "Record Not found");
	}

	@Override
	public BankAccount[] findAll() {
		return accounts.toArray(new BankAccount[accounts.size()]);
	}
	@Override
	public List<BankAccount> findAllBankAccounts() {
		return accounts;
	}

	@Override
	public BankAccount updateAccount(BankAccount account) {
		
		for(int i = 0; i<accounts.size() ; i++)
		{
			if(account.getAccountNumber() == accounts.get(i).getAccountNumber())
			{
				accounts.set(i, account);
				return account;
			}
		}
		return null;
	}
	@Override
	public boolean deleteByAccountNumber(int accountNumber) throws RecordNotFoundException {

		BankAccount foundAccount =  findByAccountNumber(accountNumber);
		accounts.remove(foundAccount);
		return true;
	}
	

	@Override
	public void close() {		
	}



	
}