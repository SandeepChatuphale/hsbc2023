package in.co.hsbc.foodapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import in.co.hsbc.foodapp.dao.FoodDao;
import in.co.hsbc.foodapp.model.FoodItem;

@Repository("dao")
public class FoodDaoImpl implements FoodDao{

	private List<FoodItem> foods;
	
	public FoodDaoImpl() {
		
		FoodItem f1 = new FoodItem(1,"Wada",10);
		FoodItem f2 = new FoodItem(2,"Dosa",20);
		
		foods = new ArrayList<>();
		foods.add(f1);
		foods.add(f2);
	}

	@Override
	public List<FoodItem> findAll() {
		return this.foods;
	}	
}






