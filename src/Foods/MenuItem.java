package Foods;
import DS.ListInterface;

/**
 * Contains a list of Ingredients
 * @author Jason Wu
 *
 */
public abstract class MenuItem {
	private ListInterface<Ingredient> recipe;
	
	public MenuItem(ListInterface<Ingredient> l){
		recipe = l;
	}
	
	public Ingredient[] toArray(){
		Ingredient[] temp = new Ingredient[recipe.getLength()];
		for (int i = 0; i < temp.length; i++){
			temp[i] = recipe.lookAt(i);
		}
		return temp;
	}
	
}
