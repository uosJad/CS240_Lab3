package Foods;

import DS.ListInterface;
import DS.ListVector;

public class CheeseBurger extends MenuItem{
	public CheeseBurger(){
		super(getRecipe());
	}
	
	private static ListInterface<Ingredient> getRecipe(){
		ListInterface<Ingredient> temp = new ListVector<Ingredient>();
		temp.add(new Cheese());
		temp.add(new Bun());
		temp.add(new Patty());
		temp.add(new Lettuce());
		temp.add(new Tomato());
		temp.add(new Onion());
		return temp;
	}
	
}
