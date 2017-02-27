package DS;

public final class QueueNode<T> implements QueueInterface<T> {

	private Node front, back;
	private int numOfItems;
	
	private static final int MAX_SIZE = 50;
	
	public QueueNode(){
		numOfItems = 0;
	}
	
	private class Node{
		T data;
		Node adr;
		
		public Node(T d, Node a){
			data = d;
			adr = a;
		}
	}
	
	@Override
	public void enqueue(T newEntry) {
		if (numOfItems + 1 <= MAX_SIZE){
			Node temp = new Node(newEntry, back);
			back = temp;
			if (front == null){
				front = temp;
			}
			numOfItems++;
		}
	}

	@Override
	public T dequeue() {
		T tempReturn = null;
		if (!isEmpty()){
			if (numOfItems == 1){
				tempReturn= front.data;
				front = null;
				back = null;
				numOfItems--;	
			}
			else {
				Node temp = back;
				for (int i = 0; i < numOfItems; i++){
					if (temp.adr == front){ // if found node pointing to front
						tempReturn= front.data;
						front = temp;
						front.adr = null;
						numOfItems--;
						break;
					}
					else
					{
						temp = temp.adr;
					}
				}
			}
		}
		return tempReturn;
	}

	@Override
	public T getFront() {
		T temp = null;
		if (!isEmpty())		
			temp = front.data;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;
		if (front == null)
			result = true;
		return result;
	}

	@Override
	public void clear() {
		front = null;
		back = null;
		numOfItems = 0;
	}

}
