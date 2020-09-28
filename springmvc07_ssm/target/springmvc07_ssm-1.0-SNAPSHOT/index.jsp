<%--
  Created by IntelliJ IDEA.
  User: huige
  Date: 2020/9/27
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName()+":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>功能入口</title>
    <base href="<%=basePath%>>"/>
</head>
    <div align="center">
    <p>SSM 整合的例子</p>
    <img src="image/4.jpg "/>
    <table>
        <tr>
            <td><a href="addStudent.jsp"/>注册学生</td>
        </tr>
        <tr>
            <td><a href="listStudent.jsp">浏览学生</td>
        </tr>
    </table>
    </div>
</body>
</html>
