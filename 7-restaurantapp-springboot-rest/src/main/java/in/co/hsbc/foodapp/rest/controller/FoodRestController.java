package in.co.hsbc.foodapp.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.co.hsbc.foodapp.model.FoodItem;

@RestController
public class FoodRestController {

	private List<FoodItem> foods;
	
	public FoodRestController()
	{
		foods = new ArrayList<>();
		
		FoodItem f1 = new FoodItem(1, "Idli", 10);
		foods.add(f1);
		
		FoodItem f2 = new FoodItem(2, "wada", 20);
		foods.add(f2);
	}
	
	@GetMapping("/food")
	public List<FoodItem> findAllFoodItems()
	{
		return this.foods;
	}
	
	//food/1
	//food/78
	@GetMapping("/food/{id}")
	public FoodItem findById(@PathVariable int id)
	{
		Optional<FoodItem> o = foods
									.stream()
								.filter(f -> f.getId() == id)
									.findFirst();
		return o.get();
		
	}
	
	@PostMapping("/food")
	public FoodItem createNewItem(@RequestBody FoodItem item)
	{
		foods.add(item);
		return item;
	}
	
	@DeleteMapping("/food/{id}")
	public void deleteById(@PathVariable int id)
	{
		foods.removeIf(f -> f.getId() == id);
	}
	
	@PutMapping("/food/{id}")
	public void updateById(@PathVariable int id,
							@RequestBody FoodItem i )
	{
		for (FoodItem foodItem : foods) {
			if(foodItem.getId() == id)
			{
				foodItem.setItem(i.getItem());
				foodItem.setPrice(i.getPrice());
			}
		}
	}
	
	
	@ResponseBody
	@GetMapping(value = "/food",params = "limit")
	public List<FoodItem> findByLimit(@RequestParam int limit)
	{
		return this.foods;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


