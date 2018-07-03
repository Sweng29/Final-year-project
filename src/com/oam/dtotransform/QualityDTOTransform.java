package com.oam.dtotransform;

import com.oam.dto.QualityDTO;
import com.oam.models.QualityModel;

public class QualityDTOTransform {

	static QualityDTO qualityDTO = new QualityDTO();
	
	public static QualityDTO transform(QualityModel qualityModel)
	{
		if(qualityModel.getQualityId()!=null)
		{
			qualityDTO.setQualityId(Integer.toString(qualityModel.getQualityId()));
		}
		if(qualityModel.getQuality()!=null)
		{
			qualityDTO.setQuality(qualityModel.getQuality());
		}
		return qualityDTO;
	}
}
