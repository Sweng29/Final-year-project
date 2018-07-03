package com.oam.dtotransform;

import com.oam.dto.ProductImagesDTO;
import com.oam.models.ProductImagesModel;

public class ProductImagesDTOTransform {
	
	public static ProductImagesDTO transform(ProductImagesModel productImagesModel)
	{
		ProductImagesDTO productImagesDTO = new ProductImagesDTO();
		
		if(productImagesModel.getImageId()!=null)
		{
			productImagesDTO.setImageId(Integer.toString(productImagesModel.getImageId()));
		}
		if(productImagesModel.getImagePath()!=null)
		{
			productImagesDTO.setImagePath(productImagesModel.getImagePath());
		}
		return productImagesDTO;
	}
}
