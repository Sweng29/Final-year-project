package com.oam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_images")
public class ProductImagesModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductImagesModel(){}
	
	@Id
	@GeneratedValue
	@Column(name="image_id")
	private Integer imageId;

	@Column(name="image_path")
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name="selling_product_id")
	private SellingProductModel sellingProductModel;

	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public SellingProductModel getSellingProductModel() {
		return sellingProductModel;
	}
	public void setSellingProductModel(SellingProductModel sellingProductModel) {
		this.sellingProductModel = sellingProductModel;
	}

}
