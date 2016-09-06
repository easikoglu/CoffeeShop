package com.coffeeshop.example.web.resource;

import com.coffeeshop.example.web.resource.visitor.ItemResource;
import com.coffeeshop.example.web.resource.visitor.ItemVisitor;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by easikoglu on 30/01/16.
 */
@XmlRootElement
public class ProductResource implements ItemResource {

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    Long productId;
    String name;
    BigDecimal price;
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    Long categoryId;
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    CategoryResource category;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryResource getCategory() {
        return category;
    }

    public void setCategory(CategoryResource category) {
        this.category = category;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public BigDecimal accept(ItemVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductResource)) return false;

        ProductResource that = (ProductResource) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return price != null ? price.equals(that.price) : that.price == null;

    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
