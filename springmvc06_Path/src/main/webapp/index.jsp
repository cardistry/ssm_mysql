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
    <p>第一个springmvc项目</p>
    <p><a href="user/some.do">发起some.do的请求</a></p>
<%--        防止路径变化
            解决方案 v1--%>
<%--        <p><a href="${pageContext.request.contextPath}/user/some.do"/>发起some.do的请求</p>--%>
<%--        解决方案 v2
            加base 标签
            另外防止网站名字变化，可以动态指定
            --%>

</body>
</html>
