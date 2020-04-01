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
import java.io.PrintWriter;

@WebServlet("/AddStudentServlet" )
public class AddStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int no = Integer.parseInt(request.getParameter("sno"));
        String name = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("sage"));
        String address = request.getParameter("saddress");
        Student student=new Student(no,name,age,address);
        //接口X=new 实现类();
        IStudentService studentService=new StudentServiceImpl();
        boolean result = studentService.addStudent(student);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
/*if(result){

            //out.println("增加成功");
           // response.sendRedirect("QueryStudentAllServlet");
        }else {
           // out.println("增加失败");
           // response.sendRedirect("QueryStudentAllServlet");
        }*/
        if(!result){
            request.setAttribute("error","addError");
        }else{
            request.setAttribute("error","NoaddError");
        }
        request.getRequestDispatcher("QueryStudentAllServlet").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
