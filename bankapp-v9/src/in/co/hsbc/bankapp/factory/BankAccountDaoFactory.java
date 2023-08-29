package in.co.hsbc.bankapp.factory;

import java.io.IOException;
import java.sql.SQLException;

import in.co.hsbc.bankapp.dao.BankAccountDao;
import in.co.hsbc.bankapp.dao.impl.BankAccountArrayDaoImpl;
import in.co.hsbc.bankapp.dao.impl.BankAccountCollectionDaoImpl;
import in.co.hsbc.bankapp.dao.impl.BankAccountFileDaoImpl;
import in.co.hsbc.bankapp.dao.impl.BankAccountJdbcDaoImpl;

public class BankAccountDaoFactory {

	public static BankAccountDao createBankAccountDao(int option) throws IOException, ClassNotFoundException, SQLException
	{
		if(option == 1)
			return new BankAccountArrayDaoImpl();
		else if (option == 2) {
			return new BankAccountCollectionDaoImpl();
		}
		else if (option == 3) {
			return new BankAccountJdbcDaoImpl();
		}
		else if(option == 4)
		{
			return new BankAccountFileDaoImpl();
		}
		return null;
	}
}
