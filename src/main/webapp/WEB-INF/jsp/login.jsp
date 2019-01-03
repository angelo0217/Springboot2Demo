<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <title>SB Admin - Start Bootstrap Template</title>
    <!-- Bootstrap core CSS-->
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/css/sb-admin.css" type="text/css" rel="stylesheet">

    <script type="text/javascript" defer="defer">
        function loginFormSubmit(){
            $("#loginForm").submit();
        }
    </script>
</head>
<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
            <form class="form-login" id="loginForm" action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <label for="username1">Email address</label>
                    <input class="form-control" name="username1" id="username1"  type="email" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="password1">Password</label>
                    <input class="form-control" name="password1" type="password" id="password1" placeholder="Password">
                </div>
                <a class="btn btn-primary btn-block" id="testBtn" onclick="loginFormSubmit();">Login</a>
            </form>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>