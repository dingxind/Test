<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8 0008
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="/javaweb-demo/user_servlet" method="post">
    <input type="hidden" value="user_update" name="action"/>
    <input type="hidden" name="id" value="${user.id }">
    登录名：<input type="text" name="loginName" value="${user.loginName}"><br>
    密码：<input type="text" name="password" value="${user.password }"><br>
    用户名：<input type="text" name="realName" value="${user.realName }"><br>
    性别:<c:choose >
    <c:when test="${user.gender==0}">
        <input type="radio" name="gender" value="0" checked="checked" >男
        <input type="radio" name="gender" value="1">女<br>
    </c:when>
    <c:otherwise>
        <input type="radio" name="gender" value="0">男
        <input type="radio" name="gender" value="1"  checked="checked" >女<br>
    </c:otherwise>
</c:choose><br/>
   创建日期：<input type="text" name="createDate" value="${user.createDate }"><br>
    修改日期：<input type="text" name="updateDate" value="${user.updateDate }"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
