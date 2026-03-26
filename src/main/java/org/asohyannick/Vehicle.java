package org.asohyannick;

public abstract class Vehicle {
// instance fields
	private  String brand;
	private String model;
	private String color;
	private  int speed;
	
	public Vehicle(String brand, String model, String color,  int speed) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.speed = speed;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

     // subclass must implement this
	abstract void fuelType ();
	abstract void drinkType ();
	
	public void accelerate() {
		speed += 20;
		System.out.println (brand + "accelerating...");
	}
	
	
}
