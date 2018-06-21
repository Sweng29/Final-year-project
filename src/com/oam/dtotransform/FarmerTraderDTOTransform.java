package com.oam.dtotransform;

import com.oam.dto.FarmerTraderDTO;
import com.oam.models.FarmerTraderModel;

public class FarmerTraderDTOTransform {

	private static FarmerTraderDTO farmerTraderDTO = new FarmerTraderDTO();
	
	public static FarmerTraderDTO transform(FarmerTraderModel farmerTraderModel)
	{
		if(farmerTraderModel.getActive()!=null)
		{
			farmerTraderDTO.setActive(Integer.toString(farmerTraderModel.getActive()));
		}
		if(farmerTraderModel.getAddress()!=null)
		{
			farmerTraderDTO.setAddress(farmerTraderModel.getAddress());
		}
		if(farmerTraderModel.getBackupEmail()!=null)
		{
			farmerTraderDTO.setBackupEmail(farmerTraderModel.getBackupEmail());
		}
		if(farmerTraderModel.getCityModel()!=null)
		{
			farmerTraderDTO.setCityDTO(CityDTOTransform.transform(farmerTraderModel.getCityModel()));
		}
		if(farmerTraderModel.getCnicNumber()!=null)
		{
			farmerTraderDTO.setCnicNumber(farmerTraderModel.getCnicNumber());
		}
		if(farmerTraderModel.getDepositedAmount()!=null)
		{
			farmerTraderDTO.setDepositedAmount(Double.toString(farmerTraderModel.getDepositedAmount()));			
		}
		if(farmerTraderModel.getEmail()!=null)
		{
			farmerTraderDTO.setEmail(farmerTraderModel.getEmail());			
		}
		if(farmerTraderModel.getFarmerTraderId()!=null)
		{
			farmerTraderDTO.setFarmerTraderId(Integer.toString(farmerTraderModel.getFarmerTraderId()));
		}
		if(farmerTraderModel.getName()!=null)
		{
			farmerTraderDTO.setName(farmerTraderModel.getName());
		}
		if(farmerTraderModel.getPassword()!=null)
		{
			farmerTraderDTO.setPassword(farmerTraderModel.getPassword());
		}
		if(farmerTraderModel.getUserName()!=null)
		{
			farmerTraderDTO.setUserName(farmerTraderModel.getUserName());
		}
		if(farmerTraderModel.getValidationId()!=null)
		{
			farmerTraderDTO.setValidationId(Integer.toString(farmerTraderModel.getValidationId()));
		}
		return farmerTraderDTO;
	}
}
