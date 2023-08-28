package in.co.hsbc.cms.dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import in.co.hsbc.cms.model.Address;
import in.co.hsbc.cms.model.Student;
import in.co.hsbc.cms.model.Subject;

public class StudentDaoImpl {

	private Set<Student> students;
	
	public StudentDaoImpl() {
		this.students = new HashSet<>();
		
		Student s1 = new Student(1,"Ajay", new Date(), new Address("Pune",40010));
		Student s2 = new Student(2,"Sachin", new Date(), new Address("Pune",40010));
		s1.addSubjectToLearn(new Subject("Java", 90));
		s1.addSubjectToLearn(new Subject("Spring", 80));
		
		s2.addSubjectToLearn(new Subject("SQL", 75));
		
		students.add(s1);
		students.add(s2);
		
	}
		
	public Set<Student> findAll()
	{
		return students;
	}
}