package in.co.hsbc.bankapp.dao.impl;

import java.util.List;

import in.co.hsbc.bankapp.dao.BankAccountDao;
import in.co.hsbc.bankapp.dao.exception.DataStoreFullException;
import in.co.hsbc.bankapp.model.BankAccount;
import in.co.hsbc.bankapp.model.exception.BankAccountNotFoundException;

public class BankAccountFileDaoImpl implements BankAccountDao{

	@Override
	public int save(BankAccount account) throws DataStoreFullException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
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
