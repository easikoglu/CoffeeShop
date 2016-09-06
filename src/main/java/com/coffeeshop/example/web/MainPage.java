package com.coffeeshop.example.web;

import com.coffeeshop.example.models.addition.Addition;
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
import com.coffeeshop.example.web.user.SessionUser;
import com.sun.jersey.api.view.Viewable;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by easikoglu on 30/01/16.
 */

@Component
@Path("/")
public class MainPage extends BasePage {


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

    @Autowired
    ShoppingCartItemService shoppingCartItemService;



    @PermitAll
    @GET
    @Path("/")
    public Viewable main(@Context HttpServletRequest request) {

        this.populateAdditions(request);
        this.populateProducts(request);

        request.setAttribute("pageType", "product");

        return new Viewable("/index.jsp", null);
    }

    private void populateAdditions(HttpServletRequest request) {

        request.setAttribute("additions", transformAdditions(additionService.getAll()));
    }


    private void populateProducts(HttpServletRequest request) {


        final List<ProductCategoryJpaEntity> activeCategories = categoryService.findParent();

        Map<ProductCategoryJpaEntity, List<ProductJpaEntity>> products = new HashMap<>();

        for (ProductCategoryJpaEntity category : activeCategories) {
            products.put(category, productService.findByCategory(category));
        }
        List<ProductResource> productResourceList = this.transformProducts(products);
        request.setAttribute("products", productResourceList);
    }

    private List<ProductResource> transformProducts(Map<ProductCategoryJpaEntity, List<ProductJpaEntity>> all) {
        List<ProductResource> productResourceList = new ArrayList<>();

        for (Map.Entry<ProductCategoryJpaEntity, List<ProductJpaEntity>> entry : all.entrySet()) {
            ProductCategoryJpaEntity category = entry.getKey();
            final CategoryResource categoryResource = this.generateCategory(category);
            for (ProductJpaEntity entity : entry.getValue()) {
                ProductResource productResource = new ProductResource();
                productResource.setProductId(entity.getId());
                productResource.setName(entity.getName());
                productResource.setCategory(categoryResource);
                productResource.setCategoryId(entity.getCategory().getId());
                productResource.setPrice(entity.getPrice());
                productResourceList.add(productResource);

            }
        }
        return productResourceList;
    }

    private List<AdditionResource> transformAdditions(List<AdditionJpaEntity> additions) {

        List<AdditionResource> list = new ArrayList<>();
        for (AdditionJpaEntity entity : additions) {
            list.add(new AdditionResource(entity.getId(), entity.getName(), entity.getPrice()));
        }
        return list;
    }

    private CategoryResource generateCategory(ProductCategoryJpaEntity category) {

        CategoryResource categoryResource = new CategoryResource();
        categoryResource.setName(category.getName());
        categoryResource.setId(category.getId());
        if (ObjectUtil.isNotNull(category.getParent())) {
            categoryResource.setParentId(category.getParent().getId());
        }
        return categoryResource;
    }


     @Path("addToBasket")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String addToBasket(ShoppingCartResource resource, @Context HttpServletRequest request) {


        this.saveOrUpdateCard(request, resource);
        Map<ProductResource, List<AdditionResource>> card = (Map<ProductResource, List<AdditionResource>>)
                request.getSession().getAttribute("card");

        final BigDecimal[] bigDecimals = calculatePrice(card);

        request.getSession().setAttribute("prices", bigDecimals);
        request.setAttribute("prices", bigDecimals);
        request.setAttribute("card", card);
        return "true";

    }

    private void saveOrUpdateCard(HttpServletRequest request, ShoppingCartResource resource) {

        Map<ProductResource, List<AdditionResource>> card = (Map<ProductResource, List<AdditionResource>>)
                request.getSession().getAttribute("card");

        if (ObjectUtil.isNull(card)) {
            card = new HashMap<>();
        }
        card.put(resource.getProduct(), resource.getAdditions());
        request.getSession().setAttribute("card", card);
    }

    @GET
    @Path("basket")
    public Viewable basketPage(@Context HttpServletRequest request) {

        request.setAttribute("pageType", "basket");
        return new Viewable("/index.jsp");
    }


    @PermitAll
    @Path("placeOrder")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String placeOrder(String userName, @Context HttpServletRequest request) {

        Map<ProductResource, List<AdditionResource>> card = (Map<ProductResource, List<AdditionResource>>)
                request.getSession().getAttribute("card");

        if (ObjectUtil.isNotNull(card)) {

            final BigDecimal[] bigDecimals = calculatePrice(card);

            ShoppingCartJpaEntity shoppingCartJpaEntity = new ShoppingCartJpaEntity();

            List<ShoppingCartItemJpaEntity> shoppingCartItemJpaEntities = new ArrayList<>();

            for (Map.Entry<ProductResource, List<AdditionResource>> entry : card.entrySet()) {

                ShoppingCartItemJpaEntity item = new ShoppingCartItemJpaEntity();
                final ProductResource product = entry.getKey();

                final ProductJpaEntity entity = productService.get(product.getProductId());
                item.setProduct(entity);

                final List<AdditionResource> additionList = entry.getValue();
                List<AdditionJpaEntity> additionJpaEntityList = new ArrayList<>();
                if (ObjectUtil.isNotNull(additionList)) {
                    for (AdditionResource addition : additionList) {
                        final AdditionJpaEntity additionJpaEntity = additionService.get(addition.getId());
                        additionJpaEntityList.add(additionJpaEntity);

                    }
                    item.setAdditions(additionJpaEntityList);
                }


                item.setShoppingCart(shoppingCartJpaEntity);

                shoppingCartItemJpaEntities.add(item);

            }

            final UserJpaEntity byName = userService.findByName(userName);

            shoppingCartJpaEntity.setUser(byName);
            shoppingCartJpaEntity.setTotalPrice(bigDecimals[0]);
            shoppingCartJpaEntity.setDiscountPrice(bigDecimals[1]);
            shoppingCartJpaEntity.setLastPrice(bigDecimals[2]);
            shoppingCartJpaEntity.setItems(shoppingCartItemJpaEntities);



            shoppingCartService.saveOrUpdate(shoppingCartJpaEntity);


            request.getSession().setAttribute("card", null);
        }

        return "true";
    }


    private BigDecimal[] calculatePrice(Map<ProductResource, List<AdditionResource>> card) {

        BigDecimal[] priceList = new BigDecimal[3];

        BigDecimal discountRate = new BigDecimal(0);
        BigDecimal sum = new BigDecimal(0);
        BigDecimal discountedPrice = new BigDecimal(0);
        BigDecimal lowestPrice = new BigDecimal(0);
        Integer index = 1;
        for (Map.Entry<ProductResource, List<AdditionResource>> entry : card.entrySet()) {
            BigDecimal subTotal = new BigDecimal(0);

            final ProductResource product = entry.getKey();

            final List<AdditionResource> additionList = entry.getValue();

            subTotal = subTotal.add(product.accept(itemVisitor));
            if (ObjectUtil.isNotNull(additionList)) {
                for (AdditionResource addition : additionList) {
                    subTotal = subTotal.add(addition.accept(itemVisitor));
                }
            }
            if (index == 1) { //new lowestPrice
                lowestPrice = subTotal;
            } else if (lowestPrice.compareTo(subTotal) == 1) {
                lowestPrice = subTotal;
            }
            sum = sum.add(subTotal);
            index++;
        }

        if (sum.compareTo(new BigDecimal(12)) == 1) {// Greater than 12
            discountRate = sum.multiply(new BigDecimal(0.25));

            if (card.size() >= 3 && (lowestPrice.compareTo(discountRate) == 1)) {
                discountRate = lowestPrice;
            }
        }

        discountedPrice = sum.subtract(discountRate);

        priceList[0] = sum;
        priceList[1] = discountRate;
        priceList[2] = discountedPrice;
        return priceList;

    }

}
