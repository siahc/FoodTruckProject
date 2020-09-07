package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckApp {
	private FoodTruck[] list;
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.run();
	}

	private void run() {
		list = new FoodTruck[5];

		// Get list of trucks from user with max limit 5 trucks
		getTruckListFromUser();
//		getTruckListForTesting();

	
		// show menu to user with the following items:
		//
		// 1 List all existing food trucks.
		// 2 Show average rating of food trucks.
		// 3 Show highest-rated food truck.
		// 4 Quit.
		while ( true ) {
			boolean quit = false;
			
			System.out.println();
			System.out.println( "Press 1 for list of food trucks:");
			System.out.println("Press 2 for average rating of food trucks");
			System.out.println("Press 3 for the highest rated food truck");
			System.out.println("Press 4 to quit");
			System.out.println();
			
			System.out.println("Input a menu option:");
			int menuItem = scan.nextInt();
			
			// read keyboard
			switch (menuItem)
			{
			case 1: {
				listFoodTrucks();
				break;
			}
			case 2: {
				showAverageRatings();
				break;
			}
			case 3: {
				showHighestRatedFoodTruck();
				break;
			}
			case 4: {
				quit = true;
				break;
			}
			default: {
				// print bad selection
			}
			}
			if ( quit == true ) {
				break;
			}
		}

		System.out.println("Goodbye :)");
	}

	private void getTruckListFromUser() {
		// get initial input from user
		for (int i = 0; i < list.length; i++) {
			System.out.println("Please enter the name of the food truck or 'quit': ");
			String name = scan.next();
			if (name.contentEquals("quit")) {
				break;
			}
			System.out.println("Please enter the type of food you would like: ");
			String foodType = scan.next();
			System.out.println("Please ask for rating of 1-5");
			double rating = scan.nextDouble();
			System.out.println(); // give the user some space :p

			FoodTruck f1 = new FoodTruck(name, foodType, rating);
			list[i] = f1;
		}
	}
	
	private void getTruckListForTesting() {
		list[0] = new FoodTruck("Tacos Super", "mexican", 4.2987654);
		list[1] = new FoodTruck("The Hat", "pastrami", 4.5);
		list[2] = new FoodTruck("Taco Bell Mobile", "mexican sort of", 2);
	}

	// prints all non-nil food trucks in list
	private void listFoodTrucks() {
		
		// loop over all 5 possible trucks...
		for (int index = 0; index < list.length; index++) {
			if ( list[index] != null) {
				printFoodTruck(list[index]);
			}
		}

	}

	private void printFoodTruck(FoodTruck truck) {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println(truck);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
	
	private void showAverageRatings() {
		
		// loop over all 5 possible trucks...
		int trucksFound = 0;
		double TotalRatings= 0.0 ;
		
		for (int index = 0; index < list.length; index++)
		{
			if ( list[index] != null) {
				trucksFound++;
				// Calculate the average
				TotalRatings += list[index].getRating();
			} else {
				// We hit null so there must be no more trucks!
				break;
			}
		}
		
		double averageRating = (TotalRatings / trucksFound);
		System.out.println("The average rating is: " + averageRating);
		/*
		 * { double[] rating = { 1, 2, 3, 4, 5 }; double min = rating[0];
		 * 
		 * for (int r = 1; r =< rating.length; r++) { if (max > rating[r]) { min =
		 * rating[r]; } if (max < rating[r]) { max = rating[r]; } }
		 * 
		 * System.out.println("Min: " + min);
		 * 
		 * }
		 */
	}
	
	private void showHighestRatedFoodTruck() {
		// loop over all 5 possible trucks...
		double highestRated = 0.0 ;
		FoodTruck highestFoundTruck = null;
		
		for (int index = 0; index < list.length; index++)
		{
			if ( list[index] != null) {
				// Calculate the average
				if ( list[index].getRating() > highestRated ) {
					highestRated = list[index].getRating();
					highestFoundTruck = list[index];
				}
			} else {
				// We hit null so there must be no more trucks!
				break;
			}
		}
		if ( highestFoundTruck != null ) {
			printFoodTruck(highestFoundTruck);
		}
	}

}
