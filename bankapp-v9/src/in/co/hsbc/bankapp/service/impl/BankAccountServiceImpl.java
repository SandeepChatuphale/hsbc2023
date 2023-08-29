package in.co.hsbc.bankapp.service.impl;

import in.co.hsbc.bankapp.dao.BankAccountDao;
import in.co.hsbc.bankapp.dao.exception.RecordNotFoundException;
import in.co.hsbc.bankapp.model.BankAccount;
import in.co.hsbc.bankapp.model.exception.BankAccountNotFoundException;
import in.co.hsbc.bankapp.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

	//Coding to interfaces
	private BankAccountDao dao;
	
	//DAO object is passed vai constructor
	//To avoid any tight coupling with any implementation of DAO
	public BankAccountServiceImpl(BankAccountDao dao) {
		this.dao = dao;
	}

	//DAO object is passed via setter
	//To avoid any tight coupling with any implementation of DAO
//	public void setDao(BankAccountDao dao) {
//		this.dao = dao;
//	}		
	
	@Override
	public BankAccount findBankAccountByAccountNumber(int accountNumber) throws BankAccountNotFoundException {
		
		BankAccount foundAccount = null;

		try 
		{
			foundAccount = dao.findByAccountNumber(accountNumber);
		}
		catch (RecordNotFoundException e) 
		{
			e.printStackTrace();
			throw new BankAccountNotFoundException("Account with accountNumber " + accountNumber + " does not Exist");
		}
		return foundAccount;
	}


}




