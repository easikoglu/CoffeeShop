<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!-- Title -->
<div class="row">
    <div class="col-lg-12">
        <h3>Orders</h3>
    </div>
</div>
<table class="table table-hover">
    <tr>
        <th>Order ID</th>
        <th>TotalPrice</th>
        <th>DiscountPrice</th>
        <th>LastPrice</th>
        <th>User</th>
        <th></th>
    </tr>
    <tbody>
    <c:forEach items="${orders}" var="order" >
        <tr>
            <td>${order.id}</td>
            <td>${order.totalPrice} TL</td>
            <td>${order.discountPrice} TL</td>
            <td>${order.lastPrice} TL</td>
            <td>${order.user.name}</td>
            <td><a href="/admin/orderDetail/${order.id}">details</a> </td>
        </tr>
    </c:forEach>

    </tbody>
</table>