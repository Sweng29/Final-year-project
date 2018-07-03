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
@Table(name="office")
public class OfficeModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OfficeModel(){}
	@Id
	@GeneratedValue
	@Column(name="office_id")
	private Integer officeId;
	
	@Column(name="office_name")
	private String officeName;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="city_id")
	private CityModel cityModel;

	@OneToMany(targetEntity=EmployeeModel.class,mappedBy="officeModel",cascade=CascadeType.ALL)
	Set<EmployeeModel> employeesList = new HashSet<EmployeeModel>();
	
	
	public Set<EmployeeModel> getEmployeesList() {
		return employeesList;
	}
	public void setEmployeesList(Set<EmployeeModel> employeesList) {
		this.employeesList = employeesList;
	}
	public Integer getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public CityModel getCityModel() {
		return cityModel;
	}
	public void setCityModel(CityModel cityModel) {
		this.cityModel = cityModel;
	}
}
