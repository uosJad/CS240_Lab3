
import Resturant.*;

public class TestClass {

	public static void main(String[] args) {
		int SimulationDays = 31;
		Store innout = new Store();
		
		day(SimulationDays, innout);
	}
	
	public static void day(int d, Store innout){
		boolean shipToday = false;
		String delivery = "";
		//day elapsed
		for (int day = 0; day < d; day++){
			
			if (day%3 == 0) {
				shipToday = true;
				delivery = "(delivery day)";
			}
			
			//hour elapsed
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
			
			System.out.println("March "+ (day+1) + ", 20XX: " + delivery);
			innout.printStatistics();
			System.out.println("---------------------");
			innout.resetStats();
			delivery = "";
		}
		
		
	}
	
}
