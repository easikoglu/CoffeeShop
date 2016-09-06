package com.coffeeshop.example.web;

import com.coffeeshop.example.models.addition.jpa.AdditionJpaEntity;
import com.coffeeshop.example.models.category.ProductCategory;
import com.coffeeshop.example.models.category.jpa.ProductCategoryJpaEntity;
import com.coffeeshop.example.models.order.jpa.OrderJpaEntity;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;
import com.coffeeshop.example.models.shoppingcart.jpa.ShoppingCartItemJpaEntity;
import com.coffeeshop.example.models.shoppingcart.jpa.ShoppingCartJpaEntity;
import com.coffeeshop.example.models.user.jpa.UserJpaEntity;
import com.coffeeshop.example.services.*;
import com.coffeeshop.example.util.ObjectUtil;
import com.coffeeshop.example.web.resource.AdditionResource;
import com.coffeeshop.example.web.resource.CategoryResource;
import com.coffeeshop.example.web.resource.ProductResource;
import com.coffeeshop.example.web.resource.ShoppingCartResource;
import com.coffeeshop.example.web.resource.visitor.ItemVisitor;
import com.sun.jersey.api.view.Viewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by easikoglu on 30/01/16.
 */

@Component
@Path("/admin")
public class AdminPage extends BasePage {


    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AdditionService additionService;

    @Autowired
    ItemVisitor itemVisitor;

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    OrderService orderService;


     @GET
    @Path("/")
    public Viewable main(@Context HttpServletRequest request) {

        final List<ProductJpaEntity> products = productService.getAll();
        request.setAttribute("products", products);


        final List<AdditionJpaEntity> additions = additionService.getAll();
        request.setAttribute("additions", additions);

        final List<ShoppingCartJpaEntity> orders = shoppingCartService.getAll();
        request.setAttribute("orders", orders);


        return new Viewable("/admin/admin.jsp", null);
    }



    @Path("createProduct")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String createProduct(ProductResource productResource, @Context HttpServletRequest request) {

        ProductJpaEntity newProduct = new ProductJpaEntity();
        newProduct.setName(productResource.getName());
        newProduct.setPrice(productResource.getPrice());
        final ProductCategoryJpaEntity categoryJpaEntity = categoryService.get(new Long(2));
        newProduct.setCategory((ProductCategory) categoryJpaEntity);

        productService.saveOrUpdate(newProduct);


        return "true";
    }


     @Path("createAddition")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String createAddition(AdditionResource additionResource, @Context HttpServletRequest request) {

        AdditionJpaEntity newAddition = new AdditionJpaEntity();
        newAddition.setName(additionResource.getName());
        newAddition.setPrice(additionResource.getPrice());

        additionService.saveOrUpdate(newAddition);


        return "true";
    }

     @GET
    @Path("/orderDetail/{orderId}")
    public Viewable orderDetail(@PathParam("orderId") String orderId,@Context HttpServletRequest request) {

         final ShoppingCartJpaEntity order = shoppingCartService.get(new Long(orderId));

         request.setAttribute("order",order);



         return new Viewable("/admin/order_detail.jsp", null);
    }
}
