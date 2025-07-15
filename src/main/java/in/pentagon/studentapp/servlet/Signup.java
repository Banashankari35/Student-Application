package in.pentagon.studentapp.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class Signup extends HttpServlet {
	


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	Student s=new Student();
	StudentDAO sdao=new StudentDAOImp1();
	PrintWriter out=resp.getWriter();
	resp.setContentType("text/html");
	
	
	//collecting the data from the UI
	//String name=req.getParameter("name");
	//s.setName(name);
	s.setName(req.getParameter("name"));
	
	//string phone=req.Parameter("phone");
	//long phone_no=Long.parseLong(phone)
	//s.setPhone(phone_no);
	
	s.setPhone(Long.parseLong((req.getParameter("phone"))));
	s.setMail(req.getParameter("mail"));
	s.setBranch(req.getParameter("branch"));
	s.setLoc(req.getParameter("loc"));
	
	if(req.getParameter("password").equals(req.getParameter("confirm"))) {
		s.setPassword(req.getParameter("confirm"));
		boolean res=sdao.insertStudent(s);
		if(res) {
			//out.println("<h1>Data save successfully</h1>");
			req.setAttribute("success", "Account created successfully");//PACKAGE
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");//destination
			rd.forward(req, resp);//delivery guy
			
			
		}
		else {
			//out.println("<h1>Failed to add data</h1>");
			req.setAttribute("error", "Failed to create an account!");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
			
		}
	}
	else {
		//out.println("<h1>Password mismatch!!</h1>");
		req.setAttribute("error","Password mismatch!!");
	    RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
	    rd.forward(req, resp);
		}
		}
}
	
