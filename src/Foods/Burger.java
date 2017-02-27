package Foods;

import DS.ListInterface;
import DS.ListVector;

public class Burger extends MenuItem{
	public Burger(){
		super(getRecipe());
	}
	
	private static ListInterface<Ingredient> getRecipe(){
		ListInterface<Ingredient> temp = new ListVector<Ingredient>();
		temp.add(new Bun());
		temp.add(new Patty());
		temp.add(new Lettuce());
		temp.add(new Tomato());
		temp.add(new Onion());
		return temp;
	}
	
}
