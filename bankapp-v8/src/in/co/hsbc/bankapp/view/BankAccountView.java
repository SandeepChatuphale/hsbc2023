package in.co.hsbc.bankapp.view;

import in.co.hsbc.bankapp.model.BankAccount;

public interface BankAccountView extends AutoCloseable {

	void printAll(BankAccount[] accounts);
	BankAccount accept();
	void showSuccessMessage(String msg);
	void showErrorMessage(String msg);
	int showMenu();
	int acceptAccountNumber();
	void printBankAccount(BankAccount account);
	void close();
}
