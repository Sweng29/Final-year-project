package com.oam.dtotransform;

import com.oam.dto.CityDTO;
import com.oam.dto.EmployeeDTO;
import com.oam.dto.OfficeDTO;
import com.oam.models.EmployeeModel;

public class EmployeeDTOTransform {

	public static EmployeeDTO transform(EmployeeModel employeeModel)
	{
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		if(employeeModel.getAddress()!=null)
		{
			employeeDTO.setAddress(employeeModel.getAddress());
		}
		if(employeeModel.getCityModel()!=null)
		{
			CityDTO cityDTO = CityDTOTransform.transform(employeeModel.getCityModel());
			employeeDTO.setCityDTO(cityDTO);
		}
		if(employeeModel.getContact()!=null)
		{
			employeeDTO.setContact(employeeModel.getContact());
		}
		if(employeeModel.getEmployeeId()!=null)
		{
			employeeDTO.setEmployeeId(Integer.toString(employeeModel.getEmployeeId()));
		}
		if(employeeModel.getOfficeModel()!=null)
		{
			OfficeDTO officeDTO = OfficeDTOTransform.transform(employeeModel.getOfficeModel());
			employeeDTO.setOfficeDTO(officeDTO);
		}
		if(employeeModel.getEmployeeName()!=null)
		{
			employeeDTO.setEmployeeName(employeeModel.getEmployeeName());
		}
		return employeeDTO;
	}
}
