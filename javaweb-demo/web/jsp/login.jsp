<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2 0002
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <title>Latest Login Form Responsive Widget Template :: w3layouts</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content="Latest Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- Meta tag Keywords -->

    <!-- css files -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //css files -->

    <!-- web-fonts -->
    <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
          rel="stylesheet">
    <!-- //web-fonts -->
</head>

<body>
<div class="main-bg">
    <!-- title -->
    <h1></h1>
    <!-- //title -->
    <!-- content -->
    <div class="sub-main-w3">
        <div class="bg-content-w3pvt">
            <div class="top-content-style">
                <!--<img src="images/user.jpg" alt="" />-->
            </div>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <p class="legend">登&nbsp;录<span class="fa fa-hand-o-down"></span></p>
                <div class="input">
                    <input type="username" placeholder="用户名" name="username" required />
                    <span class="fa fa-envelope"></span>
                </div>
                <div class="input">
                    <input type="password" placeholder="密码" name="password" required />
                    <span class="fa fa-unlock"></span>
                </div>
                <button type="submit" class="btn submit">
                    <span class="fa fa-sign-in"></span>
                </button>
            </form>
            <a href="#" class="bottom-text-w3ls">忘记密码?</a>
        </div>
    </div>

    <!--<div class="copyright">-->
    <!--<h2>&copy; 2019 Latest Login Form. All rights reserved | Design by-->
    <!--<a href="http://w3layouts.com" target="_blank">W3layouts</a>-->
    <!--</h2>-->
    <!--</div>-->
</div>
</body>


