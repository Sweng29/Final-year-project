package com.oam.models;

import java.io.Serializable;

public class BidNotificationModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BidNotificationModel(){}
	
	private Integer bidNotification_id;
	private NotificationModel notificationModel;
	private FarmerTraderModel farmerTraderModel;
	private String status;

	public Integer getBidNotification_id() {
		return bidNotification_id;
	}
	public void setBidNotification_id(Integer bidNotification_id) {
		this.bidNotification_id = bidNotification_id;
	}
	public NotificationModel getNotificationModel() {
		return notificationModel;
	}
	public void setNotificationModel(NotificationModel notificationModel) {
		this.notificationModel = notificationModel;
	}
	public FarmerTraderModel getFarmerTraderModel() {
		return farmerTraderModel;
	}
	public void setFarmerTraderModel(FarmerTraderModel farmerTraderModel) {
		this.farmerTraderModel = farmerTraderModel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
