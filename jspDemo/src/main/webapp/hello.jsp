<%--
  Created by IntelliJ IDEA.
  User: lxlan
  Date: 2022/4/4
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello JSP</h1>
<%
    System.out.println("hello jsp~~");
%>
<%=
"Hello"
%>
<%!
    void show(){};
    String name = "zhangsan";
%>
</body>
</html>
