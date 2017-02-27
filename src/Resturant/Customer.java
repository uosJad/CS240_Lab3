package Resturant;
import java.util.Random;

public class Customer {
	private int order;
	
	public Customer(){
		order = new Random().nextInt(5);
	}
	
	public int getOrder(){
		return order;
	}
}
