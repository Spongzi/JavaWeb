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
    <title>修改品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/brand/updateServlet" method="post">
    <input name="id" type="hidden" value="${brand.id}">
    品牌名称：<label>
    <input name="brandName" value="${brand.brandName}">
</label><br>
    企业名称：<label>
    <input name="companyName" value="${brand.companyName}">
</label><br>
    排序：<label>
    <input name="ordered" value="${brand.ordered}">
</label><br>
    描述信息：<label>
    <textarea rows="5" cols="20" name="description">
        ${brand.description}
    </textarea>
</label><br>
    状态：
    <c:if test="${brand.status == 0}">
        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>
    <c:if test="${brand.status == 1}">
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1" checked>启用<br>
    </c:if>

    <input type="submit" value="提交">
</form>
</body>
</html>
