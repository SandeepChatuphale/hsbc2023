package in.co.hsbc.cms.view.impl;

import java.util.Map;
import java.util.Set;

import in.co.hsbc.cms.model.Student;
import in.co.hsbc.cms.model.Subject;

public class StudentReportConsoleImpl {
	
	public void showStudentNameAndAssociatedSubjects(Map<String, Set<Subject>> data)
	{
		
	}
	
	public void showStudentNameAndAssociatedSubjects(Set<Student> students)
	{
		for (Student student : students) {
			System.out.println(student.getName());
			System.out.println("----------------------------------------");
			System.out.println(student.getName() +"   is learning " + student.getSubjectsToLearn());
		}
	}
	
	
	
}
