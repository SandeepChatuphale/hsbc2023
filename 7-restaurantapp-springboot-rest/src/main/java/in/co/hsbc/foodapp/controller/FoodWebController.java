package in.co.hsbc.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import in.co.hsbc.foodapp.service.FoodService;

@Controller
public class FoodWebController {
	
	@Autowired
	private FoodService service;
	
	//This method is responsible for returning data along with view
	//Because we are writing Web-application hence human is consuming it 
	@GetMapping("/foods")
	public ModelAndView showAll()
	{						
										//viewName	modelName   data		
		ModelAndView m = new ModelAndView("/foods.jsp", "allFoods", service.findAll());
		return m;
	}
}




