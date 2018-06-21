package com.oam.models;

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
@Table(name="city",uniqueConstraints = {
		@UniqueConstraint(columnNames = "city_name")})
public class CityModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="city_id")
	private Integer cityId;
	@Column(name="city_name")
	private String cityName;
	@ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinColumn(name="province_id")
	private ProvinceModel provinceModel;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="cityModel",fetch = FetchType.LAZY)
	private Set<FarmerTraderModel> farmerTraderList = new HashSet<FarmerTraderModel>();
	
	public Set<FarmerTraderModel> getFarmerTraderList() {
		return farmerTraderList;
	}
	public void setFarmerTraderList(Set<FarmerTraderModel> farmerTraderList) {
		this.farmerTraderList = farmerTraderList;
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
