package com.oam.dtotransform;

import com.oam.dto.ProvinceDTO;
import com.oam.models.ProvinceModel;

public class ProvinceDTOTransform {

	static ProvinceDTO provinceDTO = new ProvinceDTO();
	
	public static ProvinceDTO transform(ProvinceModel provinceModel)
	{
		if(provinceModel.getProvinceId()!=null)
		{
			provinceDTO.setProvinceId(Integer.toString(provinceModel.getProvinceId()));
		}
		if(provinceModel.getProvinceName()!=null)
		{
			provinceDTO.setProvinceName(provinceModel.getProvinceName());
		}
		return provinceDTO;
	}
}
