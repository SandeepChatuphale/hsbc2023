package in.co.hsbc.foodapp.service;

import java.util.List;

import in.co.hsbc.foodapp.model.FoodItem;

public interface FoodService {
	
	List<FoodItem> findAll();
	FoodItem save(FoodItem food);
	void deleteById(int id);
}
