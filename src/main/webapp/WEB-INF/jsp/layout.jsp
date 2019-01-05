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
    <!-- MetisMenu CSS -->
    <%--<link href="${pageContext.request.contextPath}/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">--%>
    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/css/sb-admin.css" type="text/css" rel="stylesheet">

    <!-- Bootstrap core JavaScript-->
    <script type="text/javascript" src="${pageContext.request.contextPath}${urls.getForLookupPath('/vendor/jquery/jquery.min.js')}"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}${urls.getForLookupPath('/vendor/bootstrap/js/bootstrap.bundle.min.js')}"></script>
    <!-- Core plugin JavaScript-->
    <script type="text/javascript" src="${pageContext.request.contextPath}${urls.getForLookupPath('/vendor/jquery-easing/jquery.easing.min.js')}"></script>
    <!-- Page level plugin JavaScript-->
    <script type="text/javascript" src="${pageContext.request.contextPath}${urls.getForLookupPath('/vendor/datatables/jquery.dataTables.js')}"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}${urls.getForLookupPath('/vendor/datatables/dataTables.bootstrap4.js')}"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script type="text/javascript" src="${pageContext.request.contextPath}${urls.getForLookupPath('/vendor/metisMenu/metisMenu.min.js')}"></script>
    <!-- Custom scripts for all pages-->
    <script type="text/javascript" src="${pageContext.request.contextPath}${urls.getForLookupPath('/js/sb-admin.min.js')}"></script>
    <!-- Custom scripts for this page-->
    <script type="text/javascript" src="${pageContext.request.contextPath}${urls.getForLookupPath('/js/sb-admin-datatables.min.js')}"></script>>
    <script type="text/javascript" src="${pageContext.request.contextPath}${urls.getForLookupPath('/js/commonDemo.js')}"></script>>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bluebird/3.3.4/bluebird.min.js"></script>


    <sitemesh:write property='head' />
    <script>
        var pageContext = "${pageContext.request.contextPath}";
    </script>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">Start Bootstrap</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
                <a class="nav-link" >
                    <i class="fa fa-fw fa-dashboard"></i>
                    <span class="nav-link-text">Dashboard</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
                <a class="nav-link"">
                <i class="fa fa-fw fa-area-chart"></i>
                <span class="nav-link-text">Charts</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                <a class="nav-link" >
                    <i class="fa fa-fw fa-table"></i>
                    <span class="nav-link-text">Tables</span>
                </a>
            </li>
        </ul>
    </div>
</nav>
<div class="content-wrapper">
    <div class="container-fluid">
    <sitemesh:write property='body' />
    </div>
</div>
<input style="display: none" id="chkField"/>
</body>
</html>