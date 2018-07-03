package com.oam.models;


import java.io.Serializable;

public class SoldProducts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SoldProducts(){}
	
	private Integer soldProductId;
	private FarmerTraderModel farmerTraderModel;
	private SellingProductModel sellingProductModel;
	private Long finalPrice;
	private TransportModel transportModel;
	private Integer quanititySold;
	private Long returnedDepositAmount;
	private Integer bulityNumber;

	public Integer getSoldProductId() {
		return soldProductId;
	}
	public void setSoldProductId(Integer soldProductId) {
		this.soldProductId = soldProductId;
	}
	public FarmerTraderModel getFarmerTraderModel() {
		return farmerTraderModel;
	}
	public void setFarmerTraderModel(FarmerTraderModel farmerTraderModel) {
		this.farmerTraderModel = farmerTraderModel;
	}
	public SellingProductModel getSellingProductModel() {
		return sellingProductModel;
	}
	public void setSellingProductModel(SellingProductModel sellingProductModel) {
		this.sellingProductModel = sellingProductModel;
	}
	public Long getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Long finalPrice) {
		this.finalPrice = finalPrice;
	}
	public TransportModel getTransportModel() {
		return transportModel;
	}
	public void setTransportModel(TransportModel transportModel) {
		this.transportModel = transportModel;
	}
	public Integer getQuanititySold() {
		return quanititySold;
	}
	public void setQuanititySold(Integer quanititySold) {
		this.quanititySold = quanititySold;
	}
	public Long getReturnedDepositAmount() {
		return returnedDepositAmount;
	}
	public void setReturnedDepositAmount(Long returnedDepositAmount) {
		this.returnedDepositAmount = returnedDepositAmount;
	}
	public Integer getBulityNumber() {
		return bulityNumber;
	}
	public void setBulityNumber(Integer bulityNumber) {
		this.bulityNumber = bulityNumber;
	}

}
