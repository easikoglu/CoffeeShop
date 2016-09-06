<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!-- Title -->
<div class="row">
    <div class="col-lg-12">
        <h3>Products</h3>
    </div>
</div>
<table class="table table-hover">
    <tr>
        <th>Item</th>
        <th>Category</th>
        <th>Item Price</th>
    </tr>
    <tbody>
    <c:forEach items="${products}" var="product" >
        <tr>
            <td>${product.name}</td>
            <td>${product.category.name}</td>
            <td>${product.price} TL</td>

        </tr>
    </c:forEach>
    <p>
        <a href="#create-product" class="addTobasket btn btn-primary" data-toggle="modal" data-target="#productModel" data-model-title="Create Addition"
        >Add New</a>


    </p>
    </tbody>


</table>
<!-- Title -->
<div class="row">
    <div class="col-lg-12">
        <h3>Additions</h3>
    </div>
</div>
<table class="table table-hover">
    <tr>
        <th>Name</th>
         <th>Price</th>
    </tr>
    <tbody>
    <c:forEach items="${additions}" var="addition" >
        <tr>
            <td>${addition.name}</td>
             <td>${addition.price} TL</td>

        </tr>
    </c:forEach>
    <p>
        <a href="#create-addition" class="addTobasket btn btn-primary" data-toggle="modal" data-target="#additionModel" data-model-title="Create Addition"
        >Add New</a>


    </p>
    </tbody>


</table>


<!-- Modal -->
<div class="modal fade" id="productModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Create Product</h4>
            </div>
            <div class="modal-body">
                <form role="form"  id="createProductForm">
                    <div class="form-group">
                        <label for="productName"> Name</label>
                        <input type="text" class="form-control" name="name"
                               id="productName" placeholder="Product Name"/>
                    </div>
                    <div class="form-group">
                        <label for="productPrice"> Price</label>
                        <input type="text" class="form-control" name="price"
                               id="productPrice" placeholder="Product Price"/>
                    </div>

                    <button type="button" class="btn btn-default createProduct">Create</button>
                </form>
            </div>
            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                    Close
                </button>
                <button type="button" class="btn btn-primary">
                    Save changes
                </button>
            </div>

        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="additionModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">Create Addition</h4>
            </div>
            <div class="modal-body">
                <form role="form"  >
                    <div class="form-group">
                        <label for="productName"> Name</label>
                        <input type="text" class="form-control" name="name"
                               id="additionName" placeholder="Addition Name"/>
                    </div>
                    <div class="form-group">
                        <label for="productPrice"> Price</label>
                        <input type="text" class="form-control" name="price"
                               id="additionPrice" placeholder="Addition Price"/>
                    </div>

                    <button type="button" class="btn btn-default createAddition">Create</button>
                </form>
            </div>
            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                    Close
                </button>
                <button type="button" class="btn btn-primary">
                    Save changes
                </button>
            </div>

        </div>
    </div>
</div>