package com.oam.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="city_id")
	private CityModel cityModel;
	
	// cascade=CascadeType.ALL,
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="office_id")
	private OfficeModel officeModel;
	
	@Column(name="verification_id",length=1)
	private Integer verificationId;
	
	@Column(name="active",length=1)
	private Integer active;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public CityModel getCityModel() {
		return cityModel;
	}
	public void setCityModel(CityModel cityModel) {
		this.cityModel = cityModel;
	}
	public OfficeModel getOfficeModel() {
		return officeModel;
	}
	public void setOfficeModel(OfficeModel officeModel) {
		this.officeModel = officeModel;
	}
	public Integer getVerificationId() {
		return verificationId;
	}
	public void setVerificationId(Integer verificationId) {
		this.verificationId = verificationId;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
}
