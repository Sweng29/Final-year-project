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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="province",uniqueConstraints = {
		@UniqueConstraint(columnNames = "province_name")})
public class ProvinceModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="province_id")
	private Integer provinceId;
	@Column(name="province_name")
	private String provinceName;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="provinceModel",fetch = FetchType.LAZY)
	private Set<CityModel> citiesList = new HashSet<CityModel>();
	
	public ProvinceModel(){}

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
	
}
