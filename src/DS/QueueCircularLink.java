package DS;

public final class QueueCircularLink<T>  implements QueueInterface<T>{
	private Node free, back;
	private int numOfItems;
	
	private static final int MAX_SIZE = 10;
	
	public QueueCircularLink(){
		free = new Node(null,null);
		free.adr = free;
		back = free;
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
		
		Node temp = getBackNode();
		
		// if free is point to self or back, create new node
		if (temp == free && numOfItems + 1 <= MAX_SIZE){
			temp = new Node(newEntry, back);
			back = temp;
			free.adr = back;
			numOfItems++;
			System.out.print("new node1:");
		}		
		// else, if existing null node that is not free, reuse existing
		else if (numOfItems + 1 <= MAX_SIZE && temp.data == null){ 
			temp.data = newEntry;
			back = temp;
			//free.adr = back;
			numOfItems++;
			System.out.print("reuse:");
		}

	}

	@Override
	public T dequeue() {
		T temp = free.data;
		if(!isEmpty()){
			temp = getFrontNode().data;
			getFrontNode().data = null;
			free = getFrontNode();
			numOfItems--;
		}

		return temp;
	}

	@Override
	public T getFront() {
		Node temp = free;
		
		//if point to the free
		while (true){
			if (temp.adr == free){
				break;
			}
			temp = temp.adr;
		}
		return temp.data;
	}
	
	private Node getFrontNode(){
		Node temp = free;
		//if point to the free
		while (true){
			if (temp.adr == free){
				break;
			}
			temp = temp.adr;
		}
		return temp;
	}
	
	private Node getBackNode(){
		Node temp = free;
		//if point to the back
		while (true){
			if (temp.adr == back){
				break;
			}
			temp = temp.adr;
		}
		return temp;
	}

	

	@Override
	public boolean isEmpty() {
		boolean result = false;
		if (free == back)
			result = true;
		return result;
	}

	@Override
	public void clear() {
		Node temp = free;
		
		//if point to the free
		while (true){
			if (temp.adr == free){
				break;
			}
			dequeue();
		}
		
	}

}
