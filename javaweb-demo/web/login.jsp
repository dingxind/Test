<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录</title>

    <style type="text/css">
        #divContainer {
            width: 400px;
            height: 300px;
            /*border: 1px solid #3cffe6;*/
            margin: 8rem auto;
        <%--background: url("${pageContext.request.contextPath}/images/b.jpg");--%><%--background-size: cover;--%>
        }

        .divLeft {
            width: 100px;
            float: left;
            text-align: right;
        }

        .divRight {
            width: 200px;
            float: left;

        }

        .text {
            width: 200px;
            height: 30px;

        }

        .div-content {
            margin: 15px 0px 0px 10px;
            background: rgba(0, 0, 0, 0);
        }

        .div-title {
            padding-top: 10px;
            margin: 15px 0px 0px 10px;
        }

        .error {
            font-size: x-small;
        }

        body {
            background: url("${ctx}/resource/images/bg2.jpg");
            background-size: cover;
        }

    </style>
    <script type="text/javascript" src="${ctx}/resource/js/jquery-3.3.1.js"></script>

</head>
<body>
<form action="${ctx}/login" method="get">
    <div id="divContainer">
        <div align="center">
            <span style="color: #d0cccf;font-family: '楷体' "><h1>登&nbsp;&nbsp;录</h1></span>
        </div>
        <hr/>
        <div class="divLeft">
            <div class="div-title" style="color: #d0cccf;font-family: '微软雅黑' ">登录名:</div>
            <div class="div-title" style="color: #d0cccf;font-family: '微软雅黑' ">密 &nbsp;&nbsp;码:</div>

        </div>
        <div class="divRight">
            <div class="div-content">
                <input type="text" class="text" id="txtLloginName" onblur="check()" name="loginName"
                       placeholder="用户名" style="border:0px;background:rgba(0, 1, 1, 0);"/><span class="error"
                                                                                                id="userId"
                                                                                                style="color: red"></span>
            </div>
            <div class="div-content">
                <input type="password" class="text" id="password" onblur="check()" name="password"
                       placeholder="密码" style="border:0px;background:rgba(0, 1, 1, 0);"/><span class="error" id="pwdId"
                                                                                               style="color: red"></span>
            </div>

            <div >
                <span style="color: red;margin-left: 10px ">  ${requestScope.get("msg")}</span>

            </div>
            <div class="div-content">
                &nbsp;&nbsp;&nbsp; <input style="width: 60px" type="submit" class="text" id="submitLogin" value="登录">&nbsp;&nbsp;
                <input style="width: 60px" type="reset" class="text" value="重置">
            </div>

        </div>


    </div>

</form>
<script type="text/javascript">
    $(function () {
        $("#submitLogin").on("click", function () {
            var loginName = $("#txtLloginName").val();
            var pwd = $("#password").val();
            if (loginName == null || loginName.length <= 0) {
                // $("#userId").innerHTML("请输入用户名");
                alert("请输入用户名")
                return false;

            } else if (pwd == null || pwd.length <= 0) {
                alert("请输入密码")
                return false;
            } else
                return true;
        })

    });

</script>
</body>
</html>
