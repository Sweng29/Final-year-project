package com.oam.dtotransform;

import com.oam.dto.CityDTO;
import com.oam.models.CityModel;

public class CityDTOTransform {

	
	
	public static CityDTO transform(CityModel cityModel)
	{
		CityDTO cityDTO = new CityDTO();
		
		if(cityModel.getCityId()!=null)
		{
			cityDTO.setCityId(Integer.toString(cityModel.getCityId()));
		}
		if(cityModel.getCityName()!=null)
		{
			cityDTO.setCityName(cityModel.getCityName());
		}
		if(cityModel.getProvinceModel()!=null)
		{
			cityDTO.setProvinceDTO(ProvinceDTOTransform.transform(cityModel.getProvinceModel()));
		}
		return cityDTO;
	}
}
