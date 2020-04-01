<%@ page import="org.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 张益达
  Date: 2020/3/30
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Student student=(Student) request.getAttribute("student");

    %>

    <%--通过表单展示此人信息--%>
<form action="UpdateStudentServlet">
    学号：<input type="text" name="sno" value="<%=student.getSno()%>" readonly="readonly"/><br/>
    姓名：<input type="text" name="sname" value="<%=student.getSname()%>"/><br/>
    年龄：<input type="text" name="sage" value="<%=student.getSage()%>"/> <br/>
    地址：<input type="text" name="saddress" value="<%=student.getSaddress()%>"/><br/>
    <input type="submit"value="修改"/>



</form>
</body>
</html>
