package com.oam.models;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class CityModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CityModel(){}
	
	@Id
	@GeneratedValue
	@Column(name="city_id")
	private Integer cityId;
	
	@Column(name="city_name")
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="province_id")
	private ProvinceModel provinceModel;
    
	@OneToMany(targetEntity=FarmerTraderModel.class,mappedBy="cityModel",cascade=CascadeType.ALL)
	Set<FarmerTraderModel> farmerTraders = new HashSet<>();
	
	@OneToMany(targetEntity=OfficeModel.class,mappedBy="cityModel",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	Set<OfficeModel> officesList = new HashSet<OfficeModel>();
	
	@OneToMany(targetEntity=EmployeeModel.class,mappedBy="cityModel",cascade=CascadeType.ALL)
	Set<EmployeeModel> employeesList = new HashSet<EmployeeModel>();
	
	public Set<EmployeeModel> getEmployeesList() {
		return employeesList;
	}
	public void setEmployeesList(Set<EmployeeModel> employeesList) {
		this.employeesList = employeesList;
	}
	public Set<FarmerTraderModel> getFarmerTraders() {
		return farmerTraders;
	}
	public void setFarmerTraders(Set<FarmerTraderModel> farmerTraders) {
		this.farmerTraders = farmerTraders;
	}
	public Set<OfficeModel> getOfficesList() {
		return officesList;
	}
	public void setOfficesList(Set<OfficeModel> officesList) {
		this.officesList = officesList;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public ProvinceModel getProvinceModel() {
		return provinceModel;
	}
	public void setProvinceModel(ProvinceModel provinceModel) {
		this.provinceModel = provinceModel;
	}

}
