<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style>
    /* CSS REQUIRED */
    .state-icon {
        left: -5px;
    }
    .list-group-item-primary {
        color: rgb(255, 255, 255);
        background-color: rgb(66, 139, 202);
    }

    /* DEMO ONLY - REMOVES UNWANTED MARGIN */
    .well .list-group {
        margin-bottom: 0px;
    }
</style>

<!-- Page Features -->
<div class="row text-center">
    <c:forEach items="${products}" var="product">
        <div class="col-md-3 col-sm-6 hero-feature">
            <div class="thumbnail">
                <img src="/assets/img/coffee.png" alt="">
                <div class="caption">

                    <h3>${product.name}</h3>
                    <p>${product.category.name}</p>
                    <p>${product.price} TL</p>
                    <p>
                        <a href="#addToBasket" class="addTobasket btn btn-primary" data-toggle="modal" data-target="#myModal"
                           data-product-id="${product.productId}" data-product-name="${product.name}" data-product-price="${product.price}" >Add To Basket</a>
                        <a href="#" class="btn btn-default">More Info</a>

                    </p>
                </div>
            </div>
        </div>

    </c:forEach>

</div>
<!-- /.row -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Additions To your Coffee</h4>
            </div>
            <div class="modal-body">
                <div class="well" style="max-height: 300px;overflow: auto;">
                    <ul id="check-list-box" class="list-group checked-list-box">
                        <c:forEach var="add" items="${additions}">
                            <li class="list-group-item" data-color="success" data-addition-id="${add.id}" data-addition-name="${add.name}"
                                data-addition-price="${add.price}">${add.name}</li>
                        </c:forEach>
                    </ul>
                    <br />
                    <input id="productId" type="hidden" />
                    <input id="productName" type="hidden" />
                    <input id="productPrice" type="hidden" />
                    <button class="btn btn-primary col-xs-12" id="get-checked-data">Add Them Also</button>
                    <button class="btn btn-default col-xs-12" id="continue">No Thanks</button>
                </div>

            </div>

        </div>
    </div>
</div>