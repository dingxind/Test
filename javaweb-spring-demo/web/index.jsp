<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6 0006
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>首页</title>
    <style type="text/css">
        #txtLloginName {

        }


    </style>
    <script type="text/javascript" src="/javaweb-demo/resource/js/jquery-3.3.1.js"></script>
</head>
<body>
<h1 style="color: red;margin-left: 1000px"> 欢迎:&nbsp;${sessionScope.username} &nbsp;登录 </h1>
<form action="/javaweb-demo/user_servlet" method="post">
    <input type="hidden" value="user_list" name="action"/>
    <table style="margin-left: 70px;">
        <tr>
            <td>
                <a href="/javaweb-demo/user_servlet?action=user_add">
                    <button>添加</button>
                </a>
            </td>
            <td>
                用户名<input type="text" id="textRealName" name="textRealName"/>
            </td>
            <td>
                <input type="submit" value="查询" id="btnSearch"/>
                <input type="button" value="ajax查询" id="btnSearchAjax"/>
            </td>

        </tr>

    </table>
</form>
<div id="divUserListContainer">
<table id="tblUserList" border="1" style="margin-left: 70px;color: blue">
    <tr>
        <th style="width: 200px">
            登录名
        </th>
        <th style="width: 200px">
            用户名
        </th>
        <th style="width: 200px">
            性别
        </th>
        <th style="width: 200px">
            创建日期
        </th>
        <th style="width: 200px">
            操作
        </th>

    </tr>
    <tr>
        <c:forEach var="user" items="${userList}">
    <tr>
        <th>${user.loginName}</th>
        <th>${user.realName}</th>
        <th>
                <%-- ${user.gender}--%>
            <c:choose>
                <c:when test="${user.gender ==0}">
                    男
                </c:when>
                <c:otherwise>
                    女
                </c:otherwise>
            </c:choose>

        </th>
        <th>${user.createDate}</th>
        <th>
            <a href="/javaweb-demo/user_servlet?action=user_delete&id=${user.id} ">
                <button>删除</button>
            </a>
            <a href="/javaweb-demo/user_servlet?action=user_edit&id=${user.id}">
                <button>修改</button>
            </a>

        </th>
    </tr>


    </c:forEach>

    </tr>

</table>
</div>
<script type="text/javascript">
    $(function () {
        $("#btnSearchAjax").on("click", function () {
            // alert($("#textRealName"));
            $.ajax({
                url: "/javaweb-demo/user_servlet?action=user_list_ajax",
                type:"post",
                data: {realName: $("#textRealName").val()},
                dataType: "html",
                success: function (response) {
                   // alert(response);
                    $("#divUserListContainer").html(response);
                },
                error: function () {
                    alert("服务器响应错误");
                },

            });
        })
    });

</script>
</body>
</html>
