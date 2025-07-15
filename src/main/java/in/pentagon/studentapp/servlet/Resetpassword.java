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
@WebServlet("/Resetpassword")

public class Resetpassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImp1();
		PrintWriter out=resp.getWriter();
		Student s1=sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("mail"));
		
		if(s1!=null) {
			if(req.getParameter("password").equals(req.getParameter("confirm"))){
				s1.setPassword(req.getParameter("confirm"));
				
		boolean res=sdao.updateStudent(s1);
	
		if(res) {
		
		
		 
	        // out.println("<h1>Passwords update successfully</h1>");
			req.setAttribute("success","password updated successfully");//package
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");//destination
			rd.forward(req, resp);
	     } 
		else {
	        

	         //out.println("<h1>Failed to update the password! </h1");
			req.setAttribute("error", "Failed to create an account!");
			RequestDispatcher rd=req.getRequestDispatcher("resetpassword.jsp");
			rd.forward(req, resp);
			
	     }
	     
	}
	else{
   	 //out.println("<h1>password mismatched!</h1>");
		req.setAttribute("error","Password mismatched!!");
	    RequestDispatcher rd=req.getRequestDispatcher("resetpassword.jsp");
	    rd.forward(req, resp);
    }
}

	else {
	    	 //out.println("<h1>Student not found</h1>");
		req.setAttribute("error", "no student with the data");
		RequestDispatcher rd=req.getRequestDispatcher("resetpassword.jsp");
		rd.forward(req, resp);
	     
		
}
}
}
