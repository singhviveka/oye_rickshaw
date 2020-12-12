package com.vivek.oye_rickshaw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.oye_rickshaw.model.Driver;
import com.vivek.oye_rickshaw.model.Pessenger;
import com.vivek.oye_rickshaw.repo.DriverRepo;
import com.vivek.oye_rickshaw.repo.PessengerRepo;

@RestController
@RequestMapping(value = "/pessenger")
public class PessengerController {
	  @Autowired
	  private DriverRepo driverRepo;
	  @Autowired
	  private PessengerRepo pessengerRepo;
	  public static final double DISTANCE = 200;
	  
	  @GetMapping(value = "/all")
	  List<Pessenger> getAll() {
	    return pessengerRepo.findAll();
	  }

	  @GetMapping(value = "/{id}")
	  Optional<Pessenger> getPessengerById(@PathVariable int id) {
	    return pessengerRepo.findById(id);
	  }
	  
	  @GetMapping(value = "/find_driver/{id}")
	  List<Driver> getAllDriverNearBy(@PathVariable int id){
		  List<Driver> drivers = driverRepo.findAll();
		  Pessenger pessenger = pessengerRepo.findById(id).get();
		  List<Driver> resultDriver = new ArrayList<Driver>();
		  for(Driver driver : drivers) {
			  double dis = Math.pow(Math.pow(pessenger.getCurrentX()-driver.getCurrentX(), 2)+Math.pow(pessenger.getCurrentY()-driver.getCurrentY(), 2),0.5);
			  if(dis<=DISTANCE) {
				  resultDriver.add(driver);
			  }
		  }
		  return resultDriver;  
	  }
	  
	  @PostMapping(value = "/insert")
	  Optional<Pessenger> insert(@RequestBody Pessenger pessenger) {
		  pessengerRepo.save(pessenger);
	    return pessengerRepo.findById(pessenger.getId());
	  }

	  @PutMapping(value = "/update/{id}")
	  Optional<Pessenger> update(@RequestBody Pessenger pessenger, @PathVariable int id) {
		  pessenger.setId(id);
		pessengerRepo.save(pessenger);
	    return pessengerRepo.findById(id);
	  }

	  @DeleteMapping(value = "/delete/{id}")
	  String delete(@PathVariable int id) {
		  pessengerRepo.deleteById(id);
	    return "Deleated";
	  }
}
