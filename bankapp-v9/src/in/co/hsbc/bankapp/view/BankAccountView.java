package in.co.hsbc.bankapp.view;

import java.util.List;

import in.co.hsbc.bankapp.model.BankAccount;

public interface BankAccountView extends AutoCloseable {

	void printAll(List<BankAccount> accounts);
	BankAccount accept();
	void showSuccessMessage(String msg);
	void showErrorMessage(String msg);
	int showMenu();
	int acceptAccountNumber();
	void printBankAccount(BankAccount account);
	void close();
}
