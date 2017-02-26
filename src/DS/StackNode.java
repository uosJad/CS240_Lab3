package DS;

public final class StackNode<T> implements StackInterface<T> {
	private Node lastNode;
	private int numOfItems;
	
	private static final int MAX_SIZE = 10;
	
	
	public StackNode(){
		lastNode = null;
		numOfItems = 0;
	}
	
	
	private class Node{
		private T data;
		private Node adr;
		
		public Node(T d, Node a){
			data = d;
			adr = a;
		}
		
	}

	@Override
	public void push(T newEntry) {
		if (numOfItems + 1 <= MAX_SIZE) {
			Node temp = new Node(newEntry, lastNode);
			lastNode = temp;
			numOfItems++;
		}
		
	}

	@Override
	public T pop() {
		T tempData = null;
		if (!isEmpty()){
			Node temp = lastNode;
			lastNode = temp.adr;
			temp.adr = null;
			tempData = temp.data;
			numOfItems--;
		}
		return tempData;
	}

	@Override
	public T peek() {
		T tempData = null;
		if (!isEmpty()){
			tempData = lastNode.data;
		}
		return tempData;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;
		if (lastNode == null)
			result = true;
		return result;
	}

	@Override
	public void clear() {
		lastNode = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] temp = null;
		if (!isEmpty()){
			Node tempPointer = lastNode;
			temp = (T[])new Object[numOfItems];
			for(int i = numOfItems - 1; i >= 0; i--){
				temp[i] = tempPointer.data;
				tempPointer = tempPointer.adr;
			}
		}
		return temp;
	}
	
}
