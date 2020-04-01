package org.student.servlet;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.StudentService;
import org.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/QueryStudentServlet")
public class QueryStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int no = Integer.parseInt(request.getParameter("sno"));
        IStudentService service=new StudentServiceImpl();
        Student student=service.queryStudentBySno(no);
       // System.out.println(student);
        //将此人的数据通过前台jsp显示:web/studentInfo.jsp
        request.setAttribute("student",student);//查询到的学生翻到request域中
        request.getRequestDispatcher("studentInfo.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
