package com.oam.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="province")
public class ProvinceModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="province_id")
	private Integer provinceId;
	@Column(name="province_name")
	private String provinceName;
	@OneToMany(targetEntity=CityModel.class,mappedBy="provinceModel",cascade=CascadeType.ALL)
	Set<CityModel> cities = new HashSet<>();
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Set<CityModel> getCities() {
		return cities;
	}
	public void setCities(Set<CityModel> cities) {
		this.cities = cities;
	}
}
