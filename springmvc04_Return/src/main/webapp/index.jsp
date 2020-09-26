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
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("button").click(function () {
               // alert("button click");
                $.ajax({
                    //url:"returnVoid-ajax.do",
                    //url:"returnStudentJson.do",
                    //url:"returnStudentJsonArray.do",
                    url:"returnStringData.do",
                    data:{
                        name:"zhangsan",
                        age:20
                    },
                    type:"post",
                    //dataType:"json",
                    dataType:"text",
                    success:function (resp) {
                        //resp 从服务器返回的是json格式的字符串
                        //jqery 会把字符串转为json对象，赋值给resp形参
                        // alert(resp.name +" " + resp.age);
                        // $.each(resp,function (i,n) {
                            //alert(n.name + " " + n.age)
                            alert("返回的是文本数据" +resp);
                        // })
                    }
                })
            })
        })
    </script>

</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
    <form action="returnString-view.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄: <input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <br/>
    <button id="btn">发起ajax请求</button>
</body>
</html>
