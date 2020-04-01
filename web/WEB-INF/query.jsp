<%@ page import="org.student.entity.Student" %>
<%@ page import="org.student.entity.Page" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 张益达
  Date: 2020/3/30
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息列表</title>
</head>
<body>
    <%
        String error=(String) request.getAttribute("error");
        if(error!=null){
            if(error.equals("addError")){
                out.print("增加失败！");
            }else if(error.equals("NoaddError")){
                out.print("增加成功！");
            }

        }

    %>



<table border="1px">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <%
        Page p = (Page) request.getAttribute("p");
        for(Student student:p.getStudents()){
       %>
        <tr>
            <td><a href="QueryStudentServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
            <td><%=student.getSname()%></td>
            <td><%=student.getSage()%></td>
            <td><a href="DeleteStudentServlet?sno=<%=student.getSno()%>" >删除</a></td>
        </tr>

    <%
        }
    %>

</table>
<a href="QueryStudentAllServlet">返回</a>
<a href="index.jsp">新增学生</a><br/>

    <%
    if(p.getCurrentPage()==1){
    %> <a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1%>"> 下一页</a>
        <a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()%>"> 尾页</a>
    <%
    }
    else if(p.getCurrentPage()==p.getTotalPage()){
        %><a href="QueryStudentByPage?currentPage=1"> 首页</a>
    <a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1%>"> 上一页</a>
    <%
    }
    else{
        %>
    <a href="QueryStudentByPage?currentPage=1"> 首页</a>
    <a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1%>"> 上一页</a>
    <a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1%>"> 下一页</a>
    <a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()%>"> 尾页</a>
    <%
    }
    %>
    <br/>
    每页显示
    <form>
        <select name="ps">
            <option value="3">3</option>
            <option value="5">5</option>
            <option value="10">10</option>
        </select>
        <input type="submit" value="提交"/>
    </form>

</body>
</html>
