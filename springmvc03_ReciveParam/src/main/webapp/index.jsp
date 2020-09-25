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
    <p>提交参数给Controller</p>
    <form action="receiveproperty.do" method="post">
        姓名：<input type="text" name="myname"><br/>
        年龄: <input type="text" name="myage"><br/>
        <input type="submit" value="提交参数">
    </form>

    <form action="receiveparam.do" method="get">
        姓名：<input type="text" name="rname"><br/>
        年龄: <input type="text" name="rage"><br/>
        <input type="submit" value="提交参数">
    </form>

    <form action="receiveobject.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄: <input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
