package com.oam.dto;

public class OfficeDTO {

	private String officeId;
	private String officeName;
	private CityDTO cityDTO;
	public String getOfficeId() {
		return officeId;
	}
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public CityDTO getCityDTO() {
		return cityDTO;
	}
	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}
}
