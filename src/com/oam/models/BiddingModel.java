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
@Table(name="bidding")
public class BiddingModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BiddingModel(){}
	@Id
	@GeneratedValue
	@Column(name="bid_id")
	private Integer bidId;
	@ManyToOne
	@JoinColumn(name="selling_product_id")
	private SellingProductModel sellingProductModel;
	@ManyToOne
	@JoinColumn(name="faremer_trader_id")
	private FarmerTraderModel farmerTraderModel;
	
	@Column(name="bid_amount")
	private Long bidAmount;

	
	
	public Integer getBidId() {
		return bidId;
	}
	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}
	public SellingProductModel getSellingProductModel() {
		return sellingProductModel;
	}
	public void setSellingProductModel(SellingProductModel sellingProductModel) {
		this.sellingProductModel = sellingProductModel;
	}
	public FarmerTraderModel getFarmerTraderModel() {
		return farmerTraderModel;
	}
	public void setFarmerTraderModel(FarmerTraderModel farmerTraderModel) {
		this.farmerTraderModel = farmerTraderModel;
	}
	public Long getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(Long bidAmount) {
		this.bidAmount = bidAmount;
	}
}
