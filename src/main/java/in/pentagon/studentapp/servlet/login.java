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
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDAO sdao=new StudentDAOImp1();
		HttpSession session=req.getSession(true);
		//PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		Student s =sdao.getStudent(mail,password);
		if(s!=null) {
			//out.println("<h1>Login Successfully!!</h1>");
			//out.println("<h1>login successful</h1>");
			//out.println("<p>welcome," + s.getName()+"</p>");
			//out.println("<h1>Login successfull</h1>");
			//out.println("<p>welcome,"+s.getName()+"!</p>");000000000000000000000000000000000000000000000000000000000000000000000000000000
			
			
			session.setAttribute("student",s);
			req.setAttribute("student", s);
			req.setAttribute("success","logged in successfully!");
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);
			
			
			
			
		}
		
		
		else {
			//out.println("<h1>Failed to Login</h1> ");
			req.setAttribute("error","failed to login!");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}

		
	}

	


}
