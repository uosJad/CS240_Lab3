package Foods;

import DS.ListInterface;
import DS.ListVector;

public class BurgerNoOnion extends MenuItem{
	public BurgerNoOnion(){
		super(getRecipe());
	}
	
	private static ListInterface<Ingredient> getRecipe(){
		ListInterface<Ingredient> temp = new ListVector<Ingredient>();
		temp.add(new Bun());
		temp.add(new Patty());
		temp.add(new Lettuce());
		temp.add(new Tomato());
		return temp;
	}
	
}
