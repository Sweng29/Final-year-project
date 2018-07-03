package com.oam.dtotransform;

import com.oam.dto.CityDTO;
import com.oam.dto.OfficeDTO;
import com.oam.models.OfficeModel;

public class OfficeDTOTransform {

	public static OfficeDTO transform(OfficeModel officeModel)
	{
		OfficeDTO officeDTO = new OfficeDTO();
		
		if(officeModel.getOfficeId()!=null)
		{
			officeDTO.setOfficeId(Integer.toString(officeModel.getOfficeId()));
		}
		if(officeModel.getOfficeName()!=null)
		{
			officeDTO.setOfficeName(officeModel.getOfficeName());
		}
		if(officeModel.getCityModel()!=null)
		{
			CityDTO cityDTO = CityDTOTransform.transform(officeModel.getCityModel());
			officeDTO.setCityDTO(cityDTO);
		}
		return officeDTO;
	}
}
