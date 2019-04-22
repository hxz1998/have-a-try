<%--
  User: Mr.Hu
  Date: 2018/2/17
  Time: 22:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="http://localhost:8080/userAction!execute" method="post">
        用户名：<input type="text" name="username" ><br>
        密码：<input type="password" name="password"><br>
        确认密码：<input type="password" name="password2"><br>
        <button type="submit">提交</button>
    </form>
</body>
</html>
