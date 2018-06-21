package com.oam.dao;

import java.util.List;

import com.oam.models.SellingProductModel;

public interface PostProductDao {

	public int postProduct(SellingProductModel sellingProductModel);
	public List<SellingProductModel> getAllSellingProducts();
	public SellingProductModel getSellingProductById(Integer sellingProductId);
	public Integer updateSellingProduct(SellingProductModel sellingProductModel);
	public Integer deleteSellingProductById(Integer sellingProductId);
}
