package com.oam.dto;

public class EmployeeDTO {

	private String employeeId;
	private String employeeName;
	private String contact;
	private String address;
	private CityDTO cityDTO;
	private OfficeDTO officeDTO;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
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
	public CityDTO getCityDTO() {
		return cityDTO;
	}
	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}
	public OfficeDTO getOfficeDTO() {
		return officeDTO;
	}
	public void setOfficeDTO(OfficeDTO officeDTO) {
		this.officeDTO = officeDTO;
	}

}
