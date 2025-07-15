package in.pentagon.studentapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Searchuser extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	StudentDAOImp1 sdao=new StudentDAOImp1();
	ArrayList<Student> users=sdao.getStudent(req.getParameter("search"));
	
	req.setAttribute("users", users);
	RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
	rd.forward(req, resp);
}
}
 