package com.oam.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="selling_product")
public class SellingProductModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="selling_product_id")
	private Integer sellingProductId;
	@Column(name="quantity")
	private Integer quantity;
	@Column(name="product_name")
	private String productName;
	@ManyToOne
	@JoinColumn(name="quality_id")
	private QualityModel qualityModel;
	@ManyToOne
	@JoinColumn(name="category_id")
	private ProductCategoryModel categoryModel;
	@Column(name="min_price")
	private Long minPrice;
	@Column(name="start_date")
	private String startDate;
	@Column(name="end_date")
	private String endDate;
	@ManyToOne
	@JoinColumn(name="farmer_trader_id")
	private FarmerTraderModel farmerTraderModel;
	@JoinColumn(name="selling_product_id")
	@OneToMany(cascade=CascadeType.ALL)
	Set<ProductImagesModel> images = new HashSet<ProductImagesModel>();
/*	@OneToMany(targetEntity=BiddingModel.class,mappedBy="sellingProductModel",cascade=CascadeType.ALL)
    Set<BiddingModel> biddersList = new HashSet<>();
*/
	
	
	/*public Set<BiddingModel> getBiddersList() {
		return biddersList;
	}
	public void setBiddersList(Set<BiddingModel> biddersList) {
		this.biddersList = biddersList;
	}*/
	public Integer getSellingProductId() {
		return sellingProductId;
	}
	public void setSellingProductId(Integer sellingProductId) {
		this.sellingProductId = sellingProductId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Long minPrice) {
		this.minPrice = minPrice;
	}
	
	public FarmerTraderModel getFarmerTraderModel() {
		return farmerTraderModel;
	}
	public void setFarmerTraderModel(FarmerTraderModel farmerTraderModel) {
		this.farmerTraderModel = farmerTraderModel;
	}
	public QualityModel getQualityModel() {
		return qualityModel;
	}
	public void setQualityModel(QualityModel qualityModel) {
		this.qualityModel = qualityModel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ProductCategoryModel getCategoryModel() {
		return categoryModel;
	}
	public void setCategoryModel(ProductCategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}
	public Set<ProductImagesModel> getImages() {
		return images;
	}
	public void setImages(Set<ProductImagesModel> images) {
		this.images = images;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
}
