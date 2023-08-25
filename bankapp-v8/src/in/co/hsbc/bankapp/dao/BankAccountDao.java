package in.co.hsbc.bankapp.dao;

import java.util.List;

import in.co.hsbc.bankapp.dao.exception.DataStoreFullException;
import in.co.hsbc.bankapp.dao.exception.RecordNotFoundException;
import in.co.hsbc.bankapp.model.BankAccount;

//THIS IS A CONTRACT THAT DAO-IMPL CLASS MUST FOLLOW
public interface BankAccountDao extends AutoCloseable{

	int save(BankAccount account) throws DataStoreFullException;
	BankAccount findByAccountNumber(int accNo) throws RecordNotFoundException;
	BankAccount[] findAll();
	List<BankAccount> findAllBankAccounts();
	BankAccount updateAccount(BankAccount account);
	boolean deleteByAccountNumber(int accountNumber) throws RecordNotFoundException;
	void close() throws Exception;
	
}
