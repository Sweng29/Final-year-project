package com.oam.dto;

public class CityDTO {

	private String cityId;
	private String cityName;
	private ProvinceDTO provinceDTO;
	private String active;
	
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public ProvinceDTO getProvinceDTO() {
		return provinceDTO;
	}
	public void setProvinceDTO(ProvinceDTO provinceDTO) {
		this.provinceDTO = provinceDTO;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}
