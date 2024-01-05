package studentm2withhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentm2withhtml.dao.StudentDao;
import studentm2withhtml.dto.Student;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		StudentDao studentDao=new StudentDao();
		List<Student> students=studentDao.getAllStudents();
		boolean value=false;
		String studentPassword=null;
		for(Student student:students) {
			if(email.equals(student.getEmail())) {
				value=true;
				studentPassword=student.getPassword();
				break;
			}
		}
		if(value) {
//			value=true
//			when the email exist
			if(password.equals(studentPassword)) {
//				its a valid email and password
				resp.sendRedirect("https://trainer.qspiders.com/trainer-home");
			}else {
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
			}
		}else {
//			that email doesnot exist
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
		
		
		
		
		
		
		
		
	}
	
}
