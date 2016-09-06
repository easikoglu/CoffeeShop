package com.coffeeshop.example.web.resource;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by easikoglu on 30/01/16.
 */
@XmlRootElement
public class CategoryResource {

    String name;
    private Long id;
    private Long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
