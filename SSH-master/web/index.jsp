<%--
  Created by IntelliJ IDEA.
  User: Mr.Hu
  Date: 2018/2/17
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <title>$Title$</title>
    </head>
    <body>
        <a href="register.jsp">注册</a><br>
        <form action="http://localhost:8080/userAction!getUserList" method="get">
            <input type="submit" value="用户列表">
        </form>
        <br>
        <form action="http://localhost:8080/userAction!getUserById" method="get">
            查询的ID:<input type="text" name="id"><br>
            <input type="submit" value="查询">
        </form>

    </body>
</html>
