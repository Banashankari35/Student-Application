package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;

public class Password {
public static void forgot() {
	StudentDAO sdao=new StudentDAOImp1();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Phone number:");
	long phone=sc.nextLong();
	System.out.println("enter the mail ID");
	String mail=sc.next();
	Student s=sdao.getStudent(phone,mail);
	if(s!=null) {
		System.out.println("Set a new password");
		String password=sc.next();
		System.out.println("confirm the new password:");
		String confirm=sc.next();
		if(password.equals(confirm)) {
			s.setPassword(password);
			boolean res=sdao.updateStudent(s);
			if(res) {
				System.out.println("password updated!");
				
			}
			else {
				System.out.println("failed to updated the password!s");
			}
		}
		else {
			System.out.println("password mismatch");
		}
	}else {
		System.out.println("student not found!");
	}

}
}
