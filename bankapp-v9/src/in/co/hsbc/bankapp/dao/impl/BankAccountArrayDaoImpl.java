package in.co.hsbc.bankapp.dao.impl;

import java.util.List;

import in.co.hsbc.bankapp.dao.BankAccountDao;
import in.co.hsbc.bankapp.dao.exception.DataStoreFullException;
import in.co.hsbc.bankapp.dao.exception.RecordNotFoundException;
import in.co.hsbc.bankapp.model.BankAccount;
import in.co.hsbc.bankapp.model.exception.BankAccountNotFoundException;

public class BankAccountArrayDaoImpl implements BankAccountDao {

	private BankAccount[] accounts;
	private int count;

	public BankAccountArrayDaoImpl() {
		accounts = new BankAccount[2];
		count = 0;
	}

	public int save(BankAccount newAccount) throws DataStoreFullException {
		if (count == 2)
		{
			//generate Exception (DataStoreFullException)
			throw new DataStoreFullException("DataStore is overflowing");
		}

		// check if two objects are equal
		// if yes don't save
		for (BankAccount existingAccount : accounts) {
			if (existingAccount != null) {
				if (newAccount.equals(existingAccount))
					return -2;
			}
		}

		accounts[count] = newAccount;
		count++;
		return 1;
	}

	public BankAccount findByAccountNumber(int accNo) throws RecordNotFoundException {
		for (BankAccount account : this.accounts) {
			if (account != null) {
				if (account.getAccountNumber() == accNo) {
					return account;
				}
			}
		}
		throw new RecordNotFoundException(accNo,"Record Not Found With Number " + accNo);

	}

	public BankAccount[] findAll() {
		return accounts;
	}

	public BankAccount updateAccount(BankAccount account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				if (accounts[i].getAccountNumber() == account.getAccountNumber()) {
					accounts[i] = account;
					return account;
				}
			}
		}
		return null;
	}

	@Override
	public void close() throws Exception{

	}

	@Override
	public List<BankAccount> findAllBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteByAccountNumber(int accountNumber) {
		// TODO Auto-generated method stub
		return false;
	}
}