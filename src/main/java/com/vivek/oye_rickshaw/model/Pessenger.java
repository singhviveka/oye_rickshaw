package com.vivek.oye_rickshaw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessenger {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;
     private int currentX;  // used for location
     private int currentY;  // used for location
     private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentX() {
		return currentX;
	}
	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}
	public int getCurrentY() {
		return currentY;
	}
	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
