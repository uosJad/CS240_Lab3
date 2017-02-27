import java.util.Random;

import Foods.*;
import DS.*;
import Resturant.*;

public class TestClass {

	public static void main(String[] args) {
		int SimulationDays = 31;
		Store innout = new Store();
		
		day(SimulationDays, innout);
	}
	
	public static void day(int d, Store innout){
		boolean shipToday = false;
		
		//day
		for (int day = 0; day < d; day++){
			
			if (day%3 == 0) shipToday = true;
			
			
			//hour
			for (int hour = 0; hour < 24; hour++){
				if (shipToday && hour == 9){
					innout.shipIngredients();
				}
				else if(hour >= 10 && hour <=20){
					innout.lineCustomers();
					innout.takeOrders();
				}
				else if(hour == 21){
					innout.endOfDay();
				}
			}
			
			shipToday = false;
			
			System.out.println("---------------------");
			System.out.println("March "+ day + ", 20XX:");
			innout.printStatistics();
			System.out.println("---------------------");
			innout.resetStats();
			
		}
		
		
	}
	
}
