<%--
  Created by IntelliJ IDEA.
  User: easikoglu
  Date: 30/01/16
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Heroic Features - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/assets/css/heroic-features.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<jsp:include page="../header.jsp"></jsp:include>

<!-- Page Content -->
<div class="container">


    <hr>


    <!-- Title -->
    <div class="row">
        <div class="col-lg-12">
            <h3>Order Items</h3>
        </div>
    </div>
    <table class="table table-hover">
        <tr>
            <th>Order Item ID</th>
            <th>Item Name</th>
            <th>Item Price</th>
        </tr>
        <tbody>
        <c:forEach items="${order.items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>

            </tr>
            <%--<c:forEach items="${item.additions}" var="addition">
                <tr>
                    <td>${addition.id}</td>
                    <td>${addition.name}</td>
                    <td>${addition.price}</td>

                </tr>
            </c:forEach>
--%>
        </c:forEach>


        </tbody>
    </table>


    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="/assets/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/main.js"></script>
</body>

</html>
