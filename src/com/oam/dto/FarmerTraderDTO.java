package com.oam.dto;

public class FarmerTraderDTO {

	private String farmerTraderId;
	private String name;
	private String userName;
	private String email;
	private String backupEmail;
	private String password;
	private String address;
	private String validationId;
	private String active;
	private String cnicNumber;
	private CityDTO cityDTO;
	private String depositedAmount;
	public String getFarmerTraderId() {
		return farmerTraderId;
	}
	public void setFarmerTraderId(String farmerTraderId) {
		this.farmerTraderId = farmerTraderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBackupEmail() {
		return backupEmail;
	}
	public void setBackupEmail(String backupEmail) {
		this.backupEmail = backupEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getValidationId() {
		return validationId;
	}
	public void setValidationId(String validationId) {
		this.validationId = validationId;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getCnicNumber() {
		return cnicNumber;
	}
	public void setCnicNumber(String cnicNumber) {
		this.cnicNumber = cnicNumber;
	}
	public CityDTO getCityDTO() {
		return cityDTO;
	}
	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}
	public String getDepositedAmount() {
		return depositedAmount;
	}
	public void setDepositedAmount(String depositedAmount) {
		this.depositedAmount = depositedAmount;
	}
}
