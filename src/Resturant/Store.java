package Resturant;

import DS.QueueInterface;
import DS.QueueNode;
import Foods.*;
import java.util.Random;

public class Store {
	private Inventory inv;
	private QueueInterface<Customer> line;
	private int lostCustomerDay;
	private int countItemOne, countItemTwo, countItemThree, countItemFour, countItemFive, countItemSix;

	public Store() {
		inv = new Inventory(); //TODO default
		line = new QueueNode<Customer>();
		lostCustomerDay = 0;
		countItemOne = 0;
		countItemTwo = 0;
		countItemThree = 0;
		countItemFour = 0;
		countItemFive = 0;
		countItemSix = 0;
	}
	
	public void lineCustomers(){
		int people = new Random().nextInt(100);
		//System.out.println(people);
		for(int i = 0; i < people; i++){
			if(!line.enqueue(new Customer())){
				lostCustomerDay++;
			}
		}
		
	}
	
	public void takeOrders(){
		while(!line.isEmpty()){
			Customer c = line.dequeue();
			MenuItem food = c.getOrder();
			if (!inv.makeItem(food)) this.lostCustomerDay++;
			else{
				if (food instanceof Burger) countItemOne++;
				else if (food instanceof CheeseBurger) countItemTwo++;
				else if (food instanceof VeganLettuceWrapBurger) countItemThree++;
				else if (food instanceof BurgerNoOnion) countItemFour++;
				else if (food instanceof CheeseBurgerNoOnion) countItemFive++;
				else if (food instanceof BurgerNoTomato) countItemSix++;
			}
		}
		line.clear();
	}
	
	public void shipIngredients(){
		inv.shipItems();
	}
	
	public void endOfDay(){
		inv.endOfDay();
	}
	
	public void resetStats(){
		lostCustomerDay = 0;
		countItemOne = 0;
		countItemTwo = 0;
		countItemThree = 0;
		countItemFour = 0;
		countItemFive = 0;
		countItemSix = 0;
		inv.resetStats();
	}
	
	public void printStatistics(){
		System.out.println("1): lostCustomerDay: " + this.lostCustomerDay);
		System.out.println("2): wasteCheese: " + inv.getWasteCheese() + ", " +
							"wasteBun: " + inv.getWasteBun() + ", " +
							"wastePatty: " + inv.getWastePatty() + ", " +
							"wasteLettuce: " + inv.getWasteLettuce() + ", " +
							"wasteTomato: " + inv.getWasteTomato() + ", " +
							"wasteOnion: " + inv.getWasteOnion());
		System.out.println("3): countItemOne: " + this.countItemOne + ", " +
							"countItemTwo: " + this.countItemTwo + ", " +
							"countItemThree: " + this.countItemThree + ", " +
							"countItemFour: " + this.countItemFour + ", " +
							"countItemFive: " + this.countItemFive  + ", " +
							"countItemSix: " + this.countItemSix);
	}
	
	
}
