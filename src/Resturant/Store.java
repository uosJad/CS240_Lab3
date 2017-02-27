package Resturant;

import DS.QueueInterface;
import DS.QueueNode;
import Foods.*;

public class Store {
	private Inventory inv;
	private QueueInterface<Customer> line;

	public Store() {
		inv = new Inventory();//TODO
	}
}
