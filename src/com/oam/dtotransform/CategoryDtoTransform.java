package com.oam.dtotransform;

import com.oam.dto.CategoryDTO;
import com.oam.models.ProductCategoryModel;

public class CategoryDtoTransform {
    
	static CategoryDTO categoryDTO = new CategoryDTO();
	public static CategoryDTO transform(ProductCategoryModel productCategoryModel){
		
		if(productCategoryModel.getProductCategoryId()!=null){
			
			categoryDTO.setCategoryId(String.valueOf(productCategoryModel.getProductCategoryId()));
			
		}
		if(productCategoryModel.getCategory()!=null){
			
			categoryDTO.setCategoryType(productCategoryModel.getCategory());
		}
		
		return categoryDTO;
	}
	
	
	
}
