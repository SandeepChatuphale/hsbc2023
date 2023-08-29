package in.co.hsbc.bankapp.service;

import in.co.hsbc.bankapp.model.BankAccount;
import in.co.hsbc.bankapp.model.exception.BankAccountNotFoundException;

public interface BankAccountService {

	BankAccount findBankAccountByAccountNumber(int accountNumber) throws BankAccountNotFoundException;

}
