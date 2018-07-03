package com.oam.models;

import java.io.Serializable;

public class MessageModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MessageModel(){}
	
	private Integer messageId;
	private String message;
	private SellingProductModel sellingProductModel;
	private FarmerTraderModel sentBy;
	private FarmerTraderModel sentTo;
	private String messageStatus;

	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public SellingProductModel getSellingProductModel() {
		return sellingProductModel;
	}
	public void setSellingProductModel(SellingProductModel sellingProductModel) {
		this.sellingProductModel = sellingProductModel;
	}
	public FarmerTraderModel getSentBy() {
		return sentBy;
	}
	public void setSentBy(FarmerTraderModel sentBy) {
		this.sentBy = sentBy;
	}
	public FarmerTraderModel getSentTo() {
		return sentTo;
	}
	public void setSentTo(FarmerTraderModel sentTo) {
		this.sentTo = sentTo;
	}
	public String getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

}
