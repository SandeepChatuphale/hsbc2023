package in.co.hsbc.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.hsbc.bankapp.dao.BankAccountDao;
import in.co.hsbc.bankapp.model.BankAccount;

public class BankAccountJdbcDaoImpl implements BankAccountDao {

	private Connection con;

	public BankAccountJdbcDaoImpl() throws ClassNotFoundException, SQLException {

		init();
	}

	/**
	 * this is helper method hence it is private
	 * initializing connection object
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void init() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");	
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp_db", "root", "root");
	}

	@Override
	public int save(BankAccount account) throws SQLException {
		
		String sql = "INSERT INTO bankaccount_tbl VALUES(?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, account.getAccountNumber());
		pstmt.setString(2, account.getHolderName());
		pstmt.setDouble(3, account.getBalance());
		java.sql.Date d = new Date(account.getOpeningDate().getTime());	
		pstmt.setDate(4, d);
		
		
		int numberOfRowsUpdated = pstmt.executeUpdate();//Query is getting executed here
		
		
		return numberOfRowsUpdated;
	}

	@Override
	public BankAccount findByAccountNumber(int accNo) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM bankaccount_tbl WHERE accountNumber = ?";

	
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accNo);
			ResultSet rs = pstmt.executeQuery();//Query is getting executed here 
			
			while(rs.next())
			{
				BankAccount a = new BankAccount(rs.getString(2),rs.getDouble(3));
				a.setAccountNumber(rs.getInt(1));
				return a;
			}

			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			//exception is handled to perform logging
		}
		return null;
	}

	@Override
	public BankAccount[] findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<BankAccount> accounts = findAllBankAccounts();
		return accounts.toArray(new BankAccount[accounts.size()]);
	}

	@Override
	public BankAccount updateAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BankAccount> findAllBankAccounts() throws SQLException 
	{
		String sql = "SELECT * FROM bankaccount_tbl";
		List<BankAccount> accounts = new ArrayList<>();
	
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();//Query is getting executed here 
			
			while(rs.next())
			{
				BankAccount a = new BankAccount(rs.getString(2),rs.getDouble(3));
				a.setAccountNumber(rs.getInt(1));
				accounts.add(a);
			}
			return accounts;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			//exception is handled to perform logging
			//this is called partial handling
			throw e;//this is rethrowing
		}
	}

	@Override
	public boolean deleteByAccountNumber(int accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM bankaccount_tbl WHERE accountNumber = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, accountNumber);
		int numberOfRowsUpdated = pstmt.executeUpdate();//Query is getting executed here 

		return numberOfRowsUpdated == 1;
	}
}
