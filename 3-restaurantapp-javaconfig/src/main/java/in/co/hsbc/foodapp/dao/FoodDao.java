package in.co.hsbc.foodapp.dao;

import java.util.List;

import in.co.hsbc.foodapp.model.FoodItem;

public interface FoodDao {

	List<FoodItem> findAll();
}
