<%--
  Created by IntelliJ IDEA.
  User: huige
  Date: 2020/9/24
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>第一个springmvc项目</p>
    <p><a href="user/some.do">发起some.do的请求</a></p>
    <br/>
    <form action="user/other.do" method="post">
        <input type="submit" value="post请求other.do">
    </form>
</body>
</html>
