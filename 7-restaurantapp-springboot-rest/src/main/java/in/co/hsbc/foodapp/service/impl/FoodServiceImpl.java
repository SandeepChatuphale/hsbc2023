package in.co.hsbc.foodapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import in.co.hsbc.foodapp.dao.FoodDao;
import in.co.hsbc.foodapp.model.FoodItem;
import in.co.hsbc.foodapp.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{

	//Dao is dependency of Service
	//In other words Service is dependent on Dao
	@Autowired
	@Qualifier("dao")
	private FoodDao dao;
	
	@Override
	public List<FoodItem> findAll() {
		return this.dao.findAll();
	}

	@Override
	public FoodItem save(FoodItem food) {
		return this.dao.save(food);
	}

	@Override
	public void deleteById(int id) {
		this.dao.deleteById(id);
	}
}