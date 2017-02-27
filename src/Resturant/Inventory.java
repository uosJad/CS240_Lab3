package Resturant;

import Foods.*;
import DS.StackInterface;
import DS.StackArray;
import java.util.Random;

public class Inventory {
	private StackInterface<Ingredient> bunStack;
	private StackInterface<Ingredient> pattyStack;
	private StackInterface<Ingredient> lettuceStack;
	private StackInterface<Ingredient> tomatoStack;
	private StackInterface<Ingredient> onionStack;
	private StackInterface<Ingredient> cheeseStack;
	
	private int wasteCheese, wasteBun, wastePatty, wasteLettuce, wasteTomato, wasteOnion;
	
	public Inventory(){
		bunStack = new StackArray<Ingredient>();
		pattyStack = new StackArray<Ingredient>();
		lettuceStack = new StackArray<Ingredient>();
		tomatoStack = new StackArray<Ingredient>();
		onionStack = new StackArray<Ingredient>();
		cheeseStack = new StackArray<Ingredient>();
		
		//TODO add default items to stack stack array
		
		wasteCheese = 0;
		wasteBun = 0;
		wastePatty = 0;
		wasteLettuce = 0;
		wasteTomato = 0; 
		wasteOnion = 0;
	}
	
	
	public void endOfDay(){
		sortItems(); //also ages
		//ageItems();
		tossItems();
	}
	
	
	public boolean makeItem(MenuItem item){
		boolean r = true;
		if (item instanceof Burger){
			if (!bunStack.isEmpty() && !pattyStack.isEmpty() && !lettuceStack.isEmpty() &&
				!tomatoStack.isEmpty() && !onionStack.isEmpty()){
				bunStack.pop();
				pattyStack.pop();
				lettuceStack.pop();
				tomatoStack.pop();
				onionStack.pop();
			}
			else r = false;
		}
		else if (item instanceof CheeseBurger){
			if (!bunStack.isEmpty() && !pattyStack.isEmpty() && !lettuceStack.isEmpty() &&
				!tomatoStack.isEmpty() && !onionStack.isEmpty() && !cheeseStack.isEmpty()){
				bunStack.pop();
				pattyStack.pop();
				lettuceStack.pop();
				tomatoStack.pop();
				onionStack.pop();
				cheeseStack.pop();
			}
			else r = false;
		}
		else if (item instanceof VeganLettuceWrapBurger){
			if (lettuceStack.getNumOfItems() >= 2 &&
				!tomatoStack.isEmpty() && !onionStack.isEmpty()){
				lettuceStack.pop();
				lettuceStack.pop();
				tomatoStack.pop();
				onionStack.pop();
			}
			else r = false;
		}
		else if (item instanceof BurgerNoOnion){
			if (!bunStack.isEmpty() && !pattyStack.isEmpty() && !lettuceStack.isEmpty() &&
				!tomatoStack.isEmpty()){
				bunStack.pop();
				pattyStack.pop();
				lettuceStack.pop();
				tomatoStack.pop();
			}
			else r = false;
		}
		else if (item instanceof CheeseBurgerNoOnion){
			if (!bunStack.isEmpty() && !pattyStack.isEmpty() && !lettuceStack.isEmpty() &&
				!tomatoStack.isEmpty() && !cheeseStack.isEmpty()){
				bunStack.pop();
				pattyStack.pop();
				lettuceStack.pop();
				tomatoStack.pop();
				cheeseStack.pop();
			}
			else r = false;
		}
		else if (item instanceof BurgerNoTomato){
			if (!bunStack.isEmpty() && !pattyStack.isEmpty() && !lettuceStack.isEmpty() &&
				!onionStack.isEmpty()){
				bunStack.pop();
				pattyStack.pop();
				lettuceStack.pop();
				onionStack.pop();
			}
			else r = false;
		}
		return r;
	}

	public int getWasteBun() {return wasteBun;}
	public int getWastePatty() {return wastePatty;}
	public int getWasteLettuce() {return wasteLettuce;}
	public int getWasteTomato() {return wasteTomato;}
	public int getWasteOnion() {return wasteOnion;}
	public int getWasteCheese() {return wasteCheese;}
	
	public boolean isEmptyBun() {return bunStack.isEmpty();}
	public boolean isEmptyPatty() {return pattyStack.isEmpty();}
	public boolean isEmptyLettuce() {return lettuceStack.isEmpty();}
	public boolean isEmptyTomato() {return tomatoStack.isEmpty();}
	public boolean isEmptyOnion() {return onionStack.isEmpty();}
	public boolean isEmptyCheese() {return cheeseStack.isEmpty();}
	
	public void sortItems(){
		bunStack.setStack(SelectiveSort(bunStack), bunStack.getNumOfItems());
		pattyStack.setStack(SelectiveSort(pattyStack), pattyStack.getNumOfItems());
		lettuceStack.setStack(SelectiveSort(lettuceStack), lettuceStack.getNumOfItems());
		tomatoStack.setStack(SelectiveSort(tomatoStack), tomatoStack.getNumOfItems());
		onionStack.setStack(SelectiveSort(onionStack), onionStack.getNumOfItems());
		cheeseStack.setStack(SelectiveSort(cheeseStack), cheeseStack.getNumOfItems());
	}

	/**
	 * Returns array of ages in ingredient stack
	 * @param a
	 * @return
	 */
	public int[] getAgeArray(StackInterface<Ingredient> a){
		Ingredient[] temp = a.toArray();
		int[] ages = new int[temp.length];
		for (int i = 0; i < temp.length; i++){
			ages[i] = temp[i].getAge();
		}
		return ages;
	}
	
	
	/**
	 * 
	 * @param temp int array of ages of Ingredients in stack
	 * @param stack Ingredient array
	 * @return
	 */
	private Ingredient[] SelectiveSort(StackInterface<Ingredient> s){
		Ingredient[] stack = s.toArray();
		int upper = s.getNumOfItems();
		int largest;
		for (int i = 0; i < upper; i++){
			largest = i;
			//System.out.println(c++);
			for (int j = i+1; j < upper; j++){
				
				// check all for least, swap least to i
				if (stack[j].getAge() > stack[largest].getAge())
					largest = j;
			}
			swap(stack,i,largest);
			stack[i].decrementExp();
		}
		return stack;
	}
	
	private void swap(Ingredient[] array, int a, int b){
		Ingredient temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	/// end sort
	
	/// Age
	
	private Ingredient[] age(StackInterface<Ingredient> s){
		Ingredient[] temp = s.toArray();
		int upper = s.getNumOfItems();
		int c = 0;
		for (int i = 0; i < upper; i++){
			System.out.println(c++);
			temp[i].decrementExp();
		}
		return temp;
	}
	
	public void ageItems(){
		bunStack.setStack(age(bunStack), bunStack.getNumOfItems());
		pattyStack.setStack(age(pattyStack), pattyStack.getNumOfItems());
		lettuceStack.setStack(age(lettuceStack), lettuceStack.getNumOfItems());
		tomatoStack.setStack(age(tomatoStack), tomatoStack.getNumOfItems());
		onionStack.setStack(age(onionStack), onionStack.getNumOfItems());
		cheeseStack.setStack(age(cheeseStack), cheeseStack.getNumOfItems());
	}
	
	///end age
	
	///toss
	public void tossItems(){
		toss(bunStack);
		toss(pattyStack);
		toss(lettuceStack);
		toss(tomatoStack);
		toss(onionStack);
		toss(cheeseStack);
	}
	
	private void toss(StackInterface<Ingredient> s){
		while (!s.isEmpty()){
			//System.out.println(c++);
			if (s.peek().isExpired()){
				
				Ingredient trash = s.pop();
				if (trash instanceof Bun) this.wasteBun++;
				else if (trash instanceof Patty) this.wastePatty++;
				else if (trash instanceof Lettuce) this.wasteLettuce++;
				else if (trash instanceof Tomato) this.wasteTomato++;
				else if (trash instanceof Onion) this.wasteOnion++;
				else if (trash instanceof Cheese) this.wasteCheese++;
			}
			else break;
		}
	}
	///end toss
		
	public void shipItems(){
		Random rand = new Random();
		int number;

		for (int food = 0; food < 6; food++){
			number = rand.nextInt(300) + 700;
			for (int i = 0; i < number; i++){
				if (food == 0){ // bun
					bunStack.push(new Bun());
				}
				else if (food == 1){ // patty
					pattyStack.push(new Patty());
				}
				else if (food == 2){ // lettuce
					lettuceStack.push(new Lettuce());
				}
				else if (food == 3){ // tomato
					tomatoStack.push(new Tomato());
				}
				else if (food == 4){ // onion
					onionStack.push(new Onion());
				}
				else if (food == 5){ //cheese
					cheeseStack.push(new Cheese());
				}
			}
		}
	}
	
	public void resetStats(){
		
		wasteCheese = 0;
		wasteBun = 0;
		wastePatty = 0;
		wasteLettuce = 0;
		wasteTomato = 0; 
		wasteOnion = 0;
	}
	
}
