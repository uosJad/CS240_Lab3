package Foods;

/**
 * Superclass of Ingredients
 * @author Jason Wu
 *
 */
public abstract class Ingredient {
	private int expDays;
	
	/**
	 * Creates a new ingredient
	 * @param i number of days till expire 
	 */
	public Ingredient(int i){
		expDays = i;
	}
	
	/**
	 * Decreases days left till expiration by 1
	 * @return days left
	 */
	public int decrementExp(){
		expDays--;
		return expDays;
	}
	
	/**
	 * Checks to see if item is expired
	 * @return true if expired
	 */
	public boolean isExpired(){
		boolean result = false;
		if (expDays <= 0)
			result = true;
		return result;
	}
	
	/**
	 * 
	 * @return days left
	 */
	public int getAge(){
		return expDays;
	}
	
}
