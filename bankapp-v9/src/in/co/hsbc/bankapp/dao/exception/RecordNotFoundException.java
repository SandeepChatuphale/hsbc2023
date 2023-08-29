package in.co.hsbc.bankapp.dao.exception;

public class RecordNotFoundException extends Exception{

	private int id;

	public RecordNotFoundException(int id,String message) {
		super(message);
		this.id = id;
	}

	
}
