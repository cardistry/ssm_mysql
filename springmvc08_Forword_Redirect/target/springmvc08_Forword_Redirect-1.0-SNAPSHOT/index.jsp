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
    <p>当出来方法返回ModelAndView实现forword</p>
    <form action="doForword.do" method="post">
        姓名：<input type="text" name="name" ><br/>
        年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="提交事务">
    </form>
    <br/>
    <br/>
    <p>当出来方法返回ModelAndView实现redirect</p>
    <form action="doRedirect.do" method="post">
        姓名：<input type="text" name="name" ><br/>
        年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="提交事务">
    </form>

</body>
</html>
