package in.co.hsbc.cms.controller;

import in.co.hsbc.cms.dao.impl.StudentDaoImpl;
import in.co.hsbc.cms.view.impl.StudentReportConsoleImpl;

public class StudentController {

	public static void main(String[] args) {
		
		StudentDaoImpl dao = new StudentDaoImpl();
		StudentReportConsoleImpl report = new StudentReportConsoleImpl();
		report.showStudentNameAndAssociatedSubjects(dao.findAll());
	}
}
