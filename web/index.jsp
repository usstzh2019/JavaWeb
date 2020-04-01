<%--
  Created by IntelliJ IDEA.
  User: 张益达
  Date: 2020/3/30
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="AddStudentServlet">
      学号：<input type="text" name="sno"/><br/>
      姓名：<input type="text" name="sname"/><br/>
      年龄：<input type="text" name="sage"/><br/>
      地址：<input type="text" name="saddress"/><br/>
      <input type="submit" value="新增">
    </form>
    <form action="DeleteStudentServlet">
      学号：<input type="text" name="sno"/><br/>>
      <input type="submit" value="删除">
    </form>
    <form action="UpdateStudentServlet">
      学号：<input type="text" name="sno"/><br/>
      姓名：<input type="text" name="sname"/><br/>
      年龄：<input type="text" name="sage"/><br/>
      地址：<input type="text" name="saddress"/><br/>
      <input type="submit" value="修改">
    </form>
  <a href="QueryStudentAllServlet">查询所有</a>
  <a href="QueryStudentByPage">分页查询</a>
  </body>
</html>
