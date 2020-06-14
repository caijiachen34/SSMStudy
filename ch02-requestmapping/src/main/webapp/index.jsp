<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/9
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>第一个springmvc项目</p>
    <p><a href="test/some.do">发起some.do get请求</a></p>
    <br/>
    <form action="test/other.do" method="post">
        <input type="submit" value="post请求other.do">
    </form>
</body>
</html>
