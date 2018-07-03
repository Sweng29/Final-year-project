package com.oam.models;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="product_category")
public class ProductCategoryModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="category_id")
	private Integer productCategoryId;
	@Column(name="category_type")
	private String category;
/*	@OneToMany(targetEntity=SellingProductModel.class,mappedBy="categoryModel",cascade=CascadeType.ALL)
	Set<SellingProductModel> sellingProducts = new HashSet<>();
*/	public Integer getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
/*	public Set<SellingProductModel> getSellingProducts() {
		return sellingProducts;
	}
	public void setSellingProducts(Set<SellingProductModel> sellingProducts) {
		this.sellingProducts = sellingProducts;
	}
*/}
