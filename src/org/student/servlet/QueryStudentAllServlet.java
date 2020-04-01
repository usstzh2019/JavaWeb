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
import java.util.List;

@WebServlet("/QueryStudentAllServlet")
public class QueryStudentAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        IStudentService service=new StudentServiceImpl();
        List<Student> students=service.queryAllStudents();
        System.out.println(students);
        request.setAttribute("students",students);
        /*因为request域中有数据，因此需要通过请求转发的方式跳转（重定向会丢失request域）*/
        request.getRequestDispatcher("WEB-INF/All.jsp").forward(request,response);
    }
}
