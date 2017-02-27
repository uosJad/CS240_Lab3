package Foods;

public abstract class Ingredient {
	private int expDays;
	
	public Ingredient(int i){
		expDays = i;
	}
	
	public int decrementExp(){
		expDays--;
		return expDays;
	}
	
	public boolean isExpired(){
		boolean result = false;
		if (expDays <= 0)
			result = true;
		return result;
	}
	
	public int getAge(){
		return expDays;
	}
	
}
