package com.oam.models;


import java.io.Serializable;
import java.sql.Timestamp;

public class NotificationModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotificationModel(){}
	
	private Integer notificationId;
	private String notification;
	private SellingProductModel sellingProductModel;
	private Timestamp notificationTime;

	public Integer getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public SellingProductModel getSellingProductModel() {
		return sellingProductModel;
	}
	public void setSellingProductModel(SellingProductModel sellingProductModel) {
		this.sellingProductModel = sellingProductModel;
	}
	public Timestamp getNotificationTime() {
		return notificationTime;
	}
	public void setNotificationTime(Timestamp notificationTime) {
		this.notificationTime = notificationTime;
	}
	
}
