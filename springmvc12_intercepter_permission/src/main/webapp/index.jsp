<%--
  Created by IntelliJ IDEA.
  User: huige
  Date: 2020/9/24
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
    + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
<%--    <base href="http://localhost:8080/myWeb/"/>--%>
    <base href="%basePath%"/>
</head>
<body>
    <p>一个拦截器</p>
    <form action="some.do" method="post">
        姓名：<input type="text" name="name" ><br/>
        年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="提交事务">
    </form>
    <br/>


</body>
</html>
