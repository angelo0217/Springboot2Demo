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
        <button type="button" class="btn btn-info mb-3" id="queryBtn">查詢</button>
    </div>
    <div class="row">
        <table class="table" >
            <thead>
            <tr>
                <th>seq</th>
                <th>name</th>
                <th>age</th>
            </tr>
            </thead>
            <tbody id="userTable">

            </tbody>
        </table>
    </div>
</div>
<script>
    $( document ).ready(function() {
        $("#queryBtn").click(function () {
            promiseAjax('get', "/query", null).then(
                function (res) {
                    let html = "";
                    res.forEach(function(element) {
                        html = html + "<tr>";
                        html = html +"<td>" + element.seq + "</td>";
                        html = html +"<td>" + element.name + "</td>";
                        html = html +"<td>" + element.age + "</td>";
                        html = html + "</tr>";
                    });
                    $("#userTable").html("");
                    $("#userTable").html(html);
                    $("#chkField").val("ok");
                }
            );
        });
    });
</script>
</body>
</html>