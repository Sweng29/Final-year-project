package com.oam.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="farmer_trader",uniqueConstraints = {
		@UniqueConstraint(columnNames = "user_name"),
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "cnic_number")})
public class FarmerTraderModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "farmer_trader_id", unique = true, nullable = false)
	private Integer farmerTraderId;
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	@Column(name = "user_name", unique = true, nullable = false)
	private String userName;
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	@Column(name = "backup_email")
	private String backupEmail;
	@Column(name = "password", unique = true, nullable = false)
	private String password;
	@Column(name = "address")
	private String address;
	@Column(name = "validation_id", length=1)
	private Integer validationId;
	@Column(name = "active", length=1)
	private Integer active;
	@Column(name = "cnic_number", unique = true, nullable = false)
	private String cnicNumber;
	@ManyToOne
	@JoinColumn(name="city_id")
	private CityModel cityModel;
	@Column(name = "deposited_amount")
	private Double depositedAmount;
	@OneToMany(targetEntity=SellingProductModel.class,mappedBy="farmerTraderModel",cascade=CascadeType.ALL)
	Set<SellingProductModel> sellingProducts = new HashSet<>();
	public FarmerTraderModel(){}
	
	public Integer getFarmerTraderId() {
		return farmerTraderId;
	}
	public void setFarmerTraderId(Integer farmerTraderId) {
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
	public Integer getValidationId() {
		return validationId;
	}
	public void setValidationId(Integer validationId) {
		this.validationId = validationId;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public String getCnicNumber() {
		return cnicNumber;
	}
	public void setCnicNumber(String cnicNumber) {
		this.cnicNumber = cnicNumber;
	}
	public CityModel getCityModel() {
		return cityModel;
	}
	public void setCityModel(CityModel cityModel) {
		this.cityModel = cityModel;
	}
	public Double getDepositedAmount() {
		return depositedAmount;
	}
	public void setDepositedAmount(Double depositedAmount) {
		this.depositedAmount = depositedAmount;
	}

}
