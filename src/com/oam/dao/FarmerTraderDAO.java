package com.oam.dao;

import com.oam.models.FarmerTraderModel;

public interface FarmerTraderDAO {
	public Integer addFarmerTrader(FarmerTraderModel farmerTraderModel);
	public Integer updateFarmerTrader(FarmerTraderModel farmerTraderModel);
	public Integer deleteFarmerTrader(FarmerTraderModel farmerTraderModel);
	public FarmerTraderModel getFarmerTraderById(Integer farmerTraderId);
	public FarmerTraderModel getLoggedIn(FarmerTraderModel farmerTraderModel);
	public Integer validateEmail(String emailAddress);
}
