package studentm2withhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentm2withhtml.dao.StudentDao;
import studentm2withhtml.dto.Student;

public class UpdateServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	Student student=new Student();
	student.setAddress(req.getParameter("address"));
	student.setEmail(req.getParameter("email"));
	student.setName(req.getParameter("name"));
	student.setPassword(req.getParameter("password"));
	student.setPhone(Long.parseLong(req.getParameter("phone")));
	
	StudentDao dao=new StudentDao();
	Student dbStudent=dao.updateStudent(id,student);
	if(dbStudent!=null) {
//		id is present then i have updated the data
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Data updated successfully");
	}else {
//		id is not present
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Sorry id is not present");
	}
	
	
}
}
