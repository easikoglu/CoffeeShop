package com.coffeeshop.example.models.category.jpa;

import com.coffeeshop.example.models.base.BaseJpaEntity;
import com.coffeeshop.example.models.category.ProductCategory;
import com.coffeeshop.example.models.product.Product;
import com.coffeeshop.example.models.product.jpa.ProductJpaEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by easikoglu on 30/01/16.
 * This class mysql based jpa entity. look at the id definition.
 */
@Entity
@Table(name = "product_category")
public class ProductCategoryJpaEntity extends BaseJpaEntity implements ProductCategory, Serializable {


    private Long id;
    private String name;
    private Set<ProductJpaEntity> products = new HashSet<>();
    private Set<ProductCategoryJpaEntity> children = new HashSet<ProductCategoryJpaEntity>();
    private ProductCategoryJpaEntity parent;


    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, length = 25)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * The following onetomany relations says that one ProductCategory can have many childrens of teh same type(ProductCategory) identified by
     * a collection(Set) children.
     * The initialisation is set to EAGER meaning when you fetch the parent product category all its childeren are automatically
     * loaded
     */


    /**
     * The following many to one relation means that many(children) of ProductCategory can have a parent of the same kind identified by
     * parent
     */


    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER,targetEntity = ProductCategoryJpaEntity.class)
    public Set<?extends ProductCategory> getChildren() {
        return children;
    }

    public void setChildren(Set<? extends ProductCategory> children) {
        this.children = (Set<ProductCategoryJpaEntity>) children;
    }

    @ManyToOne(targetEntity = ProductCategoryJpaEntity.class)
    @JoinColumn(name = "PARENT")
    public ProductCategory getParent() {
        return parent;
    }

    public void setParent(ProductCategory parent) {
        this.parent = (ProductCategoryJpaEntity) parent;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY,targetEntity = ProductJpaEntity.class)
    public Set<? extends Product> getProducts() {
        return products;
    }

    public void setProducts(Set<? extends Product> products) {
        this.products = (Set<ProductJpaEntity>) products;
    }

}
