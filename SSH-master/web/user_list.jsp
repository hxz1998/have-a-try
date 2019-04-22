<%--
  Created by IntelliJ IDEA.
  User: Mr.Hu
  Date: 2018/2/18
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>用户列表</title>
</head>
<body>

    <ol id="userList" >
        <li v-for="user in users">
            {{ user.username }}->{{ user.password }}
        </li>
    </ol>
    <hr>

    <s:iterator value="users">
        <s:property value="username"/>--><s:property value="password"/><br>
    </s:iterator>
    <s:debug/>


    <script type="text/javascript" src="js/vue.js"></script>
    <script type="text/javascript">
        var vm = new Vue({
            el:'#userList',
            data:{
                users:[
                    {username:'a', password:'a'},
                    {username:'b', password:'b'}
                ]
            }
        });
    </script>
</body>
</html>
