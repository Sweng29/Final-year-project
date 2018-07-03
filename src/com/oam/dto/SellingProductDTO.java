package com.oam.dto;

import java.util.HashSet;
import java.util.Set;

public class SellingProductDTO {

	private String sellingProductId;
	private String quantity;
	private String productName;
	private QualityDTO qualityDTO;
	private CategoryDTO categoryDTO;
	private String minPrice;
	private String startDate;
	private String endDate;
	private FarmerTraderDTO farmerTraderDTO;
	private Set<ProductImagesDTO> images = new HashSet<ProductImagesDTO>();
	public String getSellingProductId() {
		return sellingProductId;
	}
	public void setSellingProductId(String sellingProductId) {
		this.sellingProductId = sellingProductId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public QualityDTO getQualityDTO() {
		return qualityDTO;
	}
	public void setQualityDTO(QualityDTO qualityDTO) {
		this.qualityDTO = qualityDTO;
	}
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public FarmerTraderDTO getFarmerTraderDTO() {
		return farmerTraderDTO;
	}
	public void setFarmerTraderDTO(FarmerTraderDTO farmerTraderDTO) {
		this.farmerTraderDTO = farmerTraderDTO;
	}
	public Set<ProductImagesDTO> getImages() {
		return images;
	}
	public void setImages(Set<ProductImagesDTO> images) {
		this.images = images;
	}

}
