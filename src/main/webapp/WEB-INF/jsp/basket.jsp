<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h1>Shopping Cart</h1><hr>
<table class="table table-striped table-hover table-bordered">
    <tr>
        <th>Item</th>
        <th>Type</th>
        <th>Item Price</th>
    </tr>
    <tbody>
    <c:forEach items="${card}" var="entry" >
        <tr>
            <td>${entry.key.name}</td>
            <td>Product</td>
            <td>${entry.key.price} TL</td>

        </tr>
        <c:forEach items="${entry.value}" var="additions">
            <tr>
                <td>-${additions.name}</td>
                <td>Addition</td>
                <td>${additions.price} TL</td>

            </tr>
        </c:forEach>

    </c:forEach>

    <tr>
        <th colspan="3"><span class="pull-right">Sub Total</span></th>
        <th>${prices[0]}</th>
    </tr>
    <tr>
        <th colspan="3"><span class="pull-right">Discount</span></th>
        <th>${prices[1]}</th>
    </tr>
    <tr>
        <th colspan="3"><span class="pull-right">Total</span></th>
        <th>${prices[2]}</th>
    </tr>
    <tr>
        <th colspan="3"><span class="pull-right">UserID</span></th>
        <th><input type="text" placeholder="use test1 or test2" id="userName" name="userName"> </th>
    </tr>
    <tr>
        <td><a href="/" class="btn btn-primary">Continue Shopping</a></td>
        <td colspan="3"><a href="#" class="pull-right btn btn-success checkoutBtn">Checkout</a></td>
    </tr>
    </tbody>
</table>