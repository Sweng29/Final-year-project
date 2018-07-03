package com.oam.dtotransform;

import com.oam.dto.CategoryDTO;
import com.oam.models.ProductCategoryModel;

public class CategoryDtoTransform {
    
	public static CategoryDTO transform(ProductCategoryModel productCategoryModel){
		CategoryDTO categoryDTO = new CategoryDTO();
		
		if(productCategoryModel.getProductCategoryId()!=null){
			
			categoryDTO.setCategoryId(String.valueOf(productCategoryModel.getProductCategoryId()));
			
		}
		if(productCategoryModel.getCategory()!=null){
			
			categoryDTO.setCategoryType(productCategoryModel.getCategory());
		}
		
		return categoryDTO;
	}
	
	
	
}
