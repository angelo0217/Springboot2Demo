<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div id="helloText">helloJsp</div>
    </div>
    <div class="row">
        <div class="col-xs-6 col-sm-3">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="name_title">Name</span>
                </div>
                <input type="text" class="form-control" aria-label="Default" aria-describedby="name_title" id="name">
            </div>
        </div>
        <div class="col-xs-6 col-sm-3">
            <div class=" input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="age_title">Age</span>
                </div>
                <input type="text" class="form-control" aria-label="Default" aria-describedby="age_title" id="age">
            </div>
        </div>

        <button type="button" class="btn btn-info mb-3" id="insertBtn">新增</button>
    </div>
</div>
<script>
    $( document ).ready(function() {
        $("#insertBtn").click(function () {
            let params = {
                "name": $("#name").val(),
                "age": $("#age").val()
            };
            promiseAjax('post', "/inserUser", params).then(
                function (res) {
                    alert("success");
                    $("#name").val("");
                    $("#age").val("");
                }
            );
        });
    });
</script>
</body>
</html>