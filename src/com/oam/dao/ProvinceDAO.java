package com.oam.dao;

import java.util.List;

import com.oam.models.ProvinceModel;

public interface ProvinceDAO {

	public Integer addProvince(ProvinceModel provinceModel);
	public Integer updateProvince(ProvinceModel provinceModel);
	public Integer deleteProvinceById(Integer provinceId);
	public ProvinceModel getProvinceById(Integer provinceId);
	public ProvinceModel getProvinceByName(String provinceName);
	public List<ProvinceModel> getAllProvinces();
}
