package com.comehomecar.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comehomecar.domain.Car;
import com.comehomecar.domain.User;
import com.comehomecar.service.CarService;
import com.comehomecar.service.UserService;



@Controller
public class SearchController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;

	@RequestMapping("/searchByCategory")
	public String searchByCategory(
			@RequestParam("category") String category,
			Model model, Principal principal
			){
		if(principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		String classActiveCategory = "active"+category;
		classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
		classActiveCategory = classActiveCategory.replaceAll("&", "");
		model.addAttribute(classActiveCategory, true);
		
		List<Car> carList = carService.findByCategory(category);
		
		if (carList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "carshelf";
		}
		
		model.addAttribute("carList", carList);
		
		return "carshelf";
	}
	
	@RequestMapping("/searchCar")
	public String searchCar(
			@ModelAttribute("keyword") String keyword,
			Principal principal, Model model
			) {
		if(principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		List<Car> carList = carService.blurrySearch(keyword);
		
		if (carList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "carshelf";
		}
		
		model.addAttribute("carList", carList);
		
		return "carshelf";
	}
}
