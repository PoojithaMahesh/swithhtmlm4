package studentm2withhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentm2withhtml.dao.StudentDao;
import studentm2withhtml.dto.Student;

public class DeleteServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	StudentDao studentDao=new StudentDao();
	Student student=studentDao.deleteStudentById(id);
	if(student!=null) {
//		id is present then ihave deleted the data
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Data deleted successfully");
	}else {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Sorry id is not present");
	}
}
}
