package com.adminportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.adminportal.domain.Car;
import com.adminportal.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addCar(Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		
		return "addCar";				
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addCarPost(
			@ModelAttribute("car") Car car, HttpServletRequest request
			) {
		carService.save(car);
		
		MultipartFile carImage = car.getCarImage();

		try {
			byte[] bytes = carImage.getBytes();
			String name = car.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/car/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:carList";					
	}
	
	@RequestMapping("/carInfo")
	public String carInfo(@RequestParam("id") Long id, Model model) {
		Car car = carService.findOne(id);
		model.addAttribute("car", car);
		
		return "carInfo";
	}
	
	@RequestMapping("/updateCar")
	public String updateCar(@RequestParam("id") Long id, Model model) {
		Car car = carService.findOne(id);
		model.addAttribute("car", car);
		
		return "updateCar";
	}
	
	
	@RequestMapping(value="/updateCar", method=RequestMethod.POST)
	public String updatecarPost(@ModelAttribute("car") Car car, HttpServletRequest request) {
		carService.save(car);
		
		MultipartFile carImage = car.getCarImage();
		
		if(!carImage.isEmpty()) {
			try {
				byte[] bytes = carImage.getBytes();
				String name = car.getId() + ".png";
				
				Files.delete(Paths.get("src/main/resources/static/image/car/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/car/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/car/carInfo?id="+car.getId();
	}	
	
		
	@RequestMapping("/carList")
	public String carList(Model model) {
	List<Car> carList = carService.findAll();
	model.addAttribute("carList", carList);
		
		return "carList";
	}
	
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		carService.removeOne(Long.parseLong(id.substring(7)));
		List<Car> carList = carService.findAll();
		model.addAttribute("carList", carList);
		
		return "redirect:/car/carList";
	}

}
