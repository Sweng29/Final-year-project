package com.oam.dao;

import java.util.List;
import com.oam.models.OfficeModel;

public interface OfficeDAO {

	public Integer addOffice(OfficeModel officeModel);
	public Integer updateOffice(OfficeModel officeModel);
	public Integer deleteOffice(OfficeModel officeModel);
	public OfficeModel getOfficeById(Integer officeId);
	public OfficeModel getOfficeByName(String officeName);
	public List<OfficeModel> getAllOfficies();
	
}
