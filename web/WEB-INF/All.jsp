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
        List<Student> students=(List<Student>)request.getAttribute("students");
        for(Student student:students){
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
<a href="QueryStudentByPage">分页查找</a>
<%

%>


</body>
</html>
