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
		sortItems();
		ageItems();
		tossItems();
	}
	
	public boolean popBun(){
		boolean r = false;
		if (!bunStack.isEmpty()) bunStack.pop();
		return r;
	}
	
	public boolean popPatty(){
		boolean r = false;
		if (!pattyStack.isEmpty()) pattyStack.pop();
		return r;
	}
	
	public boolean popLettuce(){
		boolean r = false;
		if (!lettuceStack.isEmpty()) lettuceStack.pop();
		return r;
	}
	
	public boolean popTomato(){
		boolean r = false;
		if (!tomatoStack.isEmpty()) tomatoStack.pop();
		return r;
	}
	
	public boolean popOnion(){
		boolean r = false;
		if (!onionStack.isEmpty()) onionStack.pop();
		return r;
	}
	
	public boolean popCheese(){
		boolean r = false;
		if (!cheeseStack.isEmpty()) cheeseStack.pop();
		return r;
	}
	
	public int getWasteBun() {return wasteBun;}
	public int getWastePatty() {return wastePatty;}
	public int getWasteLettuce() {return wasteLettuce;}
	public int getWasteTomato() {return wasteTomato;}
	public int getWasteOnion() {return wasteOnion;}
	public int getWasteCheese() {return wasteCheese;}
	
	public void sortItems(){
		bunStack.setStack(SelectiveSort(getAgeArray(bunStack),bunStack.toArray()));
		pattyStack.setStack(SelectiveSort(getAgeArray(pattyStack),pattyStack.toArray()));
		lettuceStack.setStack(SelectiveSort(getAgeArray(lettuceStack),lettuceStack.toArray()));
		tomatoStack.setStack(SelectiveSort(getAgeArray(tomatoStack),tomatoStack.toArray()));
		onionStack.setStack(SelectiveSort(getAgeArray(onionStack),onionStack.toArray()));
		cheeseStack.setStack(SelectiveSort(getAgeArray(cheeseStack),cheeseStack.toArray()));
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
	private Ingredient[] SelectiveSort(int[] temp, Ingredient[] stack){
		
		int largest;
		for (int i = 0; i < temp.length; i++){
			largest = i;
			for (int j = i+1; j < temp.length; j++){
				// check all for least, swap least to i
				if (temp[j] > temp[largest])
					largest = j;
			}
			swap(temp,i,largest);
			swap(stack,i,largest);
		}
		return stack;
	}
	
	private void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	private void swap(Ingredient[] array, int a, int b){
		Ingredient temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	/// end sort
	
	/// Age
	
	private Ingredient[] age(Ingredient[] temp){
		for (int i = 0; i < temp.length; i++){
			temp[i].decrementExp();
		}
		return temp;
	}
	
	public void ageItems(){
		bunStack.setStack(age(bunStack.toArray()));
		pattyStack.setStack(age(pattyStack.toArray()));
		lettuceStack.setStack(age(lettuceStack.toArray()));
		tomatoStack.setStack(age(tomatoStack.toArray()));
		onionStack.setStack(age(onionStack.toArray()));
		cheeseStack.setStack(age(cheeseStack.toArray()));
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
		int number = new Random().nextInt(300) + 700;
		Random rand = new Random();
		int food;
		for (int i = 0; i < number; i++){
			food = rand.nextInt(5);
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
