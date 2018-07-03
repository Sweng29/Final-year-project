package com.oam.dao;

import java.util.List;

import com.oam.models.CityModel;

public interface CityDAO {

	public Integer addCity(CityModel cityModel);
	public Integer updateCity(CityModel cityModel);
	public Integer deleteCity(CityModel cityModel);
	public CityModel getCityById(Integer cityId);
	public CityModel getCityByName(String cityName);
	public List<CityModel> getAllCities();
	public List<CityModel> getAllCitiesByProvinceId(Integer provinceId);
}
