package DS;
/**
 *
 * Array implementation of stack ADT
 * @author Jason Wu
 *
 * @param <T> generic data type
 */
public final class StackArray<T> implements StackInterface<T>{
	private T[] arr;
	private int numOfItems; // numOfItems - 1 = index of last item in
	
	private static final int DEFAULT_SIZE = 10;
	
	public StackArray(){
		this(DEFAULT_SIZE);
	}
	
	public StackArray(int s){
		
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[s];
		arr = temp;
		numOfItems = 0;
	}
	
	@Override
	public void push(T newEntry) {
		if (numOfItems < arr.length){
			arr[numOfItems] = newEntry;
			numOfItems++;
		}
	}

	@Override
	public T pop() {
		T temp = null;
		if (!isEmpty()){
			temp = arr[numOfItems - 1];
			numOfItems--;
		}
		return temp;
	}

	@Override
	public T peek() {
		T temp = null;
		if (!isEmpty())
			temp = arr[numOfItems - 1];
		return temp;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;
		if (numOfItems <= 0)
			result = true;
		return result;
	}

	@Override
	public void clear() {
		for (int i = 0; i < numOfItems; i++){
			pop();
		}
	}
	
	/**
	 * @return copy of array
	 */
	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[arr.length];
		for (int i = 0; i < arr.length; i++){
			temp[i] = arr[i];
		}
		return temp;
	}

}
