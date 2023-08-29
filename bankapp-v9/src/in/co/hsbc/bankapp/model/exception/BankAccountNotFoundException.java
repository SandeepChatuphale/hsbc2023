package in.co.hsbc.bankapp.model.exception;

public class BankAccountNotFoundException extends Exception
{
	private String message;

	public BankAccountNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	
}
