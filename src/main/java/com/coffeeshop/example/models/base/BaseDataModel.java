package com.coffeeshop.example.models.base;

import java.util.Date;

public interface BaseDataModel {
	
	public abstract Long getId();

	public abstract void setId(Long id);
	
	public abstract Date getCreationTime();
	
	public abstract Date getUpdateTime();
}
