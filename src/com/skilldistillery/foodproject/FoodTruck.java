package com.skilldistillery.foodproject;

public class FoodTruck {

	private String name;
	private String foodType;
	private double rating;
	private int id;
	private static int nextTruckId = 1;

	public FoodTruck(String n, String ft, double r) {
		this.name = n;
		this.foodType = ft;
		this.rating = r;
		this.id = FoodTruck.nextTruckId++;
	}

	public String getName() {
		return name;
	}

	public String getFoodType() {
		return foodType;
	}
	
	public double getRating() {
		return rating;
	}

	public String toString() {
		return name
				+ "\n  id: " + id
				+ "\n  type: " + foodType
				+ "\n  rating: ⭐" + rating;		
	}
	
}
