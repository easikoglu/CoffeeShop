package com.coffeeshop.example.models.base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseJpaEntity implements Serializable {
    


    /**
     * We do not implement Id for the JPA, cause
     * it can be oracle so we need to implement sequence.
     * */
   
    private Date creationTime;
    
    private Date updateTime;

    public BaseJpaEntity() {
        creationTime = new Date();
        updateTime = new Date();
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_TIME", nullable = false)
    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    @PrePersist
    protected void onCreate() {
    	updateTime = creationTime = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	updateTime = new Date();
    }

}
