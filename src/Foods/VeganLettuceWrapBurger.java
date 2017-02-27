package Foods;

import DS.ListInterface;
import DS.ListVector;

public class VeganLettuceWrapBurger extends MenuItem{
	public VeganLettuceWrapBurger(){
		super(getRecipe());
	}
	
	private static ListInterface<Ingredient> getRecipe(){
		ListInterface<Ingredient> temp = new ListVector<Ingredient>();
		temp.add(new Lettuce());
		temp.add(new Lettuce());
		temp.add(new Tomato());
		temp.add(new Onion());
		return temp;
	}
	
}
