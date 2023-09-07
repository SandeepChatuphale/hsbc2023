package in.co.hsbc.foodapp.service.impl;

import in.co.hsbc.foodapp.dao.FoodDao;
import in.co.hsbc.foodapp.service.FoodService;

public class FoodServiceImpl implements FoodService{

	//Dao is dependency of Service
	//In other words Service is dependent on Dao
	private FoodDao dao;
	
	public FoodServiceImpl(FoodDao dao) {
		this.dao = dao;
	}
}
