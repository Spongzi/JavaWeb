<%--
  Created by IntelliJ IDEA.
  User: lxlan
  Date: 2022/4/6
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/brand/addServlet" method="post">
    品牌名称：<label>
    <input name="brandName">
</label><br>
    企业名称：<label>
    <input name="companyName">
</label><br>
    排序：<label>
    <input name="ordered">
</label><br>
    描述信息：<label>
    <textarea rows="5" cols="20" name="description"></textarea>
</label><br>
    状态：
    <label>
        <input type="radio" name="status" value="0">
    </label>禁用
    <label>
        <input type="radio" name="status" value="1">
    </label>启用<br>

    <input type="submit" value="提交">
</form>
</body>
</html>
