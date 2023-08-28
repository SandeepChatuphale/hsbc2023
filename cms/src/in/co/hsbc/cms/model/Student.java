package in.co.hsbc.cms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student {

	private int rollNumber;
	private String name;
	private Date dateOfBirth;//has-a
	private Address postalAddress;//has-a
	private Set<Subject> subjectsToLearn;//has-a
	
	
	public Student(int rollNumber, String name, Date dateOfBirth, Address postalAddress) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.postalAddress = postalAddress;
		this.subjectsToLearn = new HashSet<>();
	}
	
	public void addSubjectToLearn(Subject s)
	{
		this.subjectsToLearn.add(s);
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(Address postalAddress) {
		this.postalAddress = postalAddress;
	}

	public Set<Subject> getSubjectsToLearn() {
		return subjectsToLearn;
	}
	

	
	
	
}
