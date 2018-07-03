package com.oam.dto;

public class ProductImagesDTO {

	private String imageId;
	private String imagePath;
	private SellingProductDTO sellingProductDTO;
	
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public SellingProductDTO getSellingProductDTO() {
		return sellingProductDTO;
	}
	public void setSellingProductDTO(SellingProductDTO sellingProductDTO) {
		this.sellingProductDTO = sellingProductDTO;
	}
}
