package com.vivek.oye_rickshaw.controller;

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
import com.vivek.oye_rickshaw.repo.DriverRepo;

@RestController
@RequestMapping(value = "/driver")
public class DriverController {
	  @Autowired
	  private DriverRepo driverRepo;
	  
	  @GetMapping(value = "/all")
	  List<Driver> getAll() {
	    return driverRepo.findAll();
	  }

	  @GetMapping(value = "/{id}")
	  Optional<Driver> getDriverById(@PathVariable int id) {
	    return driverRepo.findById(id);
	  }
	  
	  @PostMapping(value = "/insert")
	  Optional<Driver> insert(@RequestBody Driver driver) {
		  driverRepo.save(driver);
	    return driverRepo.findById(driver.getId());
	  }

	  @PutMapping(value = "/update/{id}")
	  Optional<Driver> update(@RequestBody Driver driver, @PathVariable int id) {
		driver.setId(id);
	    driverRepo.save(driver);
	    return driverRepo.findById(id);
	  }

	  @DeleteMapping(value = "/delete/{id}")
	  String delete(@PathVariable int id) {
		  driverRepo.deleteById(id);
	    return "Deleated";
	  }
}
