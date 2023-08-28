package in.co.hsbc.cms.model;

public class Subject {

	private String name;
	private int marksScored;
	
	public Subject(String name, int marksScored) {
		super();
		this.name = name;
		this.marksScored = marksScored;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(int marksScored) {
		this.marksScored = marksScored;
	}

	@Override
	public String toString() {
		return  name;
	}
	
	
	
}
