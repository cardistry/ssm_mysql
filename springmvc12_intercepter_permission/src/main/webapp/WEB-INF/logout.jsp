<%--
  Created by IntelliJ IDEA.
  User: huige
  Date: 2020/9/28
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    退出系统，从session中删除用户
    <%
        session.removeAttribute("name");
    %>

</body>
</html>
