<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <title>ajax</title>
</head>
<body>
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
</body>
</html>
