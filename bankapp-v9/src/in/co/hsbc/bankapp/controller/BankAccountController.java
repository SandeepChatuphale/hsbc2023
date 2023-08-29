package in.co.hsbc.bankapp.controller;

import java.util.List;

import in.co.hsbc.bankapp.dao.BankAccountDao;
import in.co.hsbc.bankapp.dao.exception.DataStoreFullException;
import in.co.hsbc.bankapp.factory.BankAccountDaoFactory;
import in.co.hsbc.bankapp.model.BankAccount;
import in.co.hsbc.bankapp.model.exception.BankAccountNotFoundException;
import in.co.hsbc.bankapp.service.BankAccountService;
import in.co.hsbc.bankapp.service.impl.BankAccountServiceImpl;
import in.co.hsbc.bankapp.view.BankAccountView;
import in.co.hsbc.bankapp.view.impl.BankAccountConsoleViewImpl;

class BankAccountController 
{
	static public void main(String[] args) throws Exception {

		// coding to interface
		// referring to object of class

		try(BankAccountDao dao = BankAccountDaoFactory.createBankAccountDao(3);
			BankAccountView view = new BankAccountConsoleViewImpl();)
		{
			BankAccountService service = new BankAccountServiceImpl(dao);
			
			int option = 0;

			do
			{
				option = view.showMenu();
				switch (option) {
				case 1:
					BankAccount b = view.accept();
					int result;
					try 
					{
						result = dao.save(b);
						
						if (result == 1)
							view.showSuccessMessage("Record Inserted");
						else if (result == -2)
							view.showErrorMessage("Record With this name exists. Choose another");
						else
							view.showErrorMessage("Some Problem Try Again");						
					}
					catch (DataStoreFullException e) 
					{
						e.printStackTrace();//this is for developer to make debug easy
											//and log messages
						view.showErrorMessage(e.getMessage());//this is for end user
															//user friendly message
					}
					break;
				case 2:
					int accountNumber = view.acceptAccountNumber();
					BankAccount foundAccount;
					try 
					{
						foundAccount = service.findBankAccountByAccountNumber(accountNumber);
						view.printBankAccount(foundAccount);
					}
					catch (BankAccountNotFoundException e) 
					{
						e.printStackTrace();
						view.showErrorMessage(e.toString());
					}
					
					break;
				case 3:
					BankAccount account = view.accept();
					if (dao.updateAccount(account) != null) {
						view.showSuccessMessage("Account updated");
					} else
						view.showErrorMessage("Account NOT updated");
					break;
				case 4:

					List<BankAccount> accounts = dao.findAllBankAccounts();
					view.printAll(accounts);

					break;
				case 5:
					accounts = dao.findAllBankAccounts();
					// Sort All Records
					//Utility.sortBankAccount(accounts);
					// Print
					view.printAll(accounts);

					break;
				case 6:
					accountNumber = view.acceptAccountNumber();
					boolean isDeleted = dao.deleteByAccountNumber(accountNumber);
					
					if(isDeleted)
						view.showSuccessMessage("Record Deleted");
					else
						view.showErrorMessage("Record NOT Deleted");
					
					
					break;

				case -1:
					break;
				default:
					break;
				}
			} while (option != -1);
		} 
	}
}