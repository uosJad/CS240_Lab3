package Resturant;
import java.util.Random;

import Foods.*;

/**
 * Customer for store. Has a random item order out of the 6 choices
 * @author Jason Wu
 *
 */
public class Customer {
	private MenuItem order;
	
	public Customer(){
		int food = new Random().nextInt(6);
		if (food == 0){ // b
			order = new Burger();
		}
		else if (food == 1){ // cb
			order = new CheeseBurger();
		}
		else if (food == 2){ // v
			order = new VeganLettuceWrapBurger();
		}
		else if (food == 3){ // bnoo
			order = new BurgerNoOnion();
		}
		else if (food == 4){ // cbnoo
			order = new CheeseBurgerNoOnion();
		}
		else if (food == 5){ //bnot
			order = new BurgerNoTomato();
		}
	}
	
	public MenuItem getOrder(){
		return order;
	}
	
}
