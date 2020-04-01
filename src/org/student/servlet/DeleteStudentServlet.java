package org.student.servlet;

import org.student.service.IStudentService;
import org.student.service.StudentService;
import org.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*删除*/
        request.setCharacterEncoding("UTF-8");
        int no= Integer.parseInt(request.getParameter("sno"));
        IStudentService service=new StudentServiceImpl();
        boolean result = service.deleteStudentBySno(no);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if(result){
            //response.getWriter().println("删除成功！");
            response.sendRedirect("QueryStudentAllServlet");
        }else {
            response.getWriter().println("删除失败！");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
