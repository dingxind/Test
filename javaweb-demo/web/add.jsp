<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8 0008
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>

</head>
<body>

<form action="/javaweb-demo/user_servlet" method="post">
    <input type="hidden" value="user_add" name="action"/>
登录名:<input type="text" name="loginName"/><br/>
密码:<input type="text" name="password"/><br/>
用户名:<input type="text" name="realName"/><br/>
性别:<input type="radio" value="0" name="gender">男
<input type="radio" value="1" name="gender">女<br/>
创建日期:<input type="text" name="createDate"/><br/>
更新日期:<input type="text" name="updateDate"/><br/>
<input type="submit" value="提交"/>
</form>
</body>
</html>
