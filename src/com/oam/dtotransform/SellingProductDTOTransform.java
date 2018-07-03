package com.oam.dtotransform;

import java.util.HashSet;
import java.util.Set;

import com.oam.dto.CategoryDTO;
import com.oam.dto.ProductImagesDTO;
import com.oam.dto.SellingProductDTO;
import com.oam.models.ProductImagesModel;
import com.oam.models.SellingProductModel;

public class SellingProductDTOTransform {

	
	public static SellingProductDTO transform(SellingProductModel sellingProductModel)
	{
		SellingProductDTO sellingProductDTO = new SellingProductDTO();
		Set<ProductImagesDTO> productImages = new HashSet<ProductImagesDTO>();
		if(sellingProductModel.getEndDate()!=null)
		{
			sellingProductDTO.setEndDate(sellingProductModel.getEndDate());
		}
		if(sellingProductModel.getCategoryModel()!=null)
		{
			sellingProductDTO.setCategoryDTO(CategoryDtoTransform.transform(sellingProductModel.getCategoryModel()));
		}
		if(sellingProductModel.getFarmerTraderModel()!=null)
		{
			sellingProductDTO.setFarmerTraderDTO(FarmerTraderDTOTransform.transform(sellingProductModel.getFarmerTraderModel()));
		}
		if(sellingProductModel.getImages()!=null)
		{
			for(ProductImagesModel p : sellingProductModel.getImages())
			{
				productImages.add(ProductImagesDTOTransform.transform(p));
			}
			sellingProductDTO.setImages(productImages);
		}
		if(sellingProductModel.getMinPrice()!=null)
		{
			sellingProductDTO.setMinPrice(Double.toString(sellingProductModel.getMinPrice()));
		}
		if(sellingProductModel.getProductName()!=null)
		{
			sellingProductDTO.setProductName(sellingProductModel.getProductName());
		}
		if(sellingProductModel.getQualityModel()!=null)
		{
			sellingProductDTO.setQualityDTO(QualityDTOTransform.transform(sellingProductModel.getQualityModel()));
		}
		if(sellingProductModel.getQuantity()!=null)
		{
			sellingProductDTO.setQuantity(Integer.toString(sellingProductModel.getQuantity()));
		}
		if(sellingProductModel.getSellingProductId()!=null)
		{
			sellingProductDTO.setSellingProductId(Integer.toString(sellingProductModel.getSellingProductId()));
		}
		if(sellingProductModel.getStartDate()!=null)
		{
			sellingProductDTO.setStartDate(sellingProductModel.getStartDate());
		}
		return sellingProductDTO;
	}
	
}
