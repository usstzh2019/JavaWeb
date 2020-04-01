package org.student.servlet;

import org.student.entity.Page;
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

@WebServlet("/QueryStudentByPage")
public class QueryStudentByPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStudentService studentService=new StudentServiceImpl();
        int count=studentService.getTotalCount();
        //将分页所需的5个字段，组装到page对象之中
        Page page=new Page();


        String cPage=request.getParameter("currentPage");
        if(cPage==null){
            cPage="1";
        }
        int currentPage= Integer.parseInt(cPage);
        page.setCurrentPage(currentPage);
        //int currentPage=2;
        //注意顺序

        int totalCount= studentService.getTotalCount();
        page.setTotalCount(totalCount);
        //int pageSize= Integer.parseInt(request.getParameter("ps"));
        int pageSize=3;
        page.setPageSize(pageSize);

        List<Student> students = studentService.queryStudentByPage(currentPage, pageSize);
        //System.out.println(students);
        System.out.println(count);
        page.setStudents(students);
        request.setAttribute("p",page );
        request.getRequestDispatcher("WEB-INF/query.jsp").forward(request,response);
    }
}
