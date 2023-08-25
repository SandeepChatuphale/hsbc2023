package in.co.hsbc.bankapp.dao.exception;

public class DataStoreFullException extends Exception{

	private String message;

	public DataStoreFullException() {
		super();
		this.message = "DataStore is Full";
	}

	public DataStoreFullException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString()
	{
		return message;
	}
	
}
