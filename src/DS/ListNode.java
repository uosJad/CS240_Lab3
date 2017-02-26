package DS;

/**
 * Single linked Node implementation of list
 * @author Jason Wu
 *
 * @param <T> generic data type
 */
public class ListNode<T> implements ListInterface<T>{
	Node first, last;
	int numOfItems;

	public ListNode(){
		first = null;
		last = null;
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
	public boolean add(T newEntry) {
		Node temp = new Node(newEntry, first);
		last = temp;
		if (first == null){
			first = temp;
		}
		numOfItems++;
		return true;
	}

	@Override
	public boolean add(T newEntry, int index) {
		Boolean result = true;
		Node temp = nodeAtIndex(index);
		if (temp != null){
			temp.data = newEntry;
		}
		else result = false;
		numOfItems++;
		return result;
	}

	@Override
	public boolean remove(T newEntry) {
		boolean result = true;
		int t = firstIndexOf(newEntry);
		if (t != -1){
			Node a = nodeAtIndex(t);
			if (t == 0){
				first = a.adr;
				if (a == last){
					last = null;
				}
			}
			else {
				Node b = nodeAtIndex(t - 1);
				b.adr = a.adr;
				if (a == last){
					last = b;
				}
			}
			numOfItems--;
		}
		else result = false;
		return result;
	}

	@Override
	public boolean remove(int index) {
		boolean result = true;
		Node a = nodeAtIndex(index);
		if (a != null){
			if (index == 0){
				first = a.adr;
				if (a == last){
					last = null;
				}
			}
			else {
				Node b = nodeAtIndex(index - 1);
				b.adr = a.adr;
				if (a == last){
					last = b;
				}
			}
			numOfItems++;
		}
		else result = false;
		return result;
	}

	@Override
	public boolean replace(T toReplace, T newEntry) {
		boolean result = false;
		int temp = firstIndexOf(toReplace);
		if (temp != -1){
			add(toReplace, temp);
			result = true;
		}
		return result;
	}

	@Override
	public boolean replace(int index, T newEntry) {
		boolean result = false;
		if (index >= 0 && index < numOfItems){
			add(newEntry, index);
			result = true;
		}
		return result;
	}

	@Override
	public boolean replace(int index1, int index2) {
		boolean result = false;
		Node a = nodeAtIndex(index1);
		Node b = nodeAtIndex(index2);
		if (a != null && b != null){
			a.data = b.data;
			result = true;
		}
		return result;
	}

	@Override
	public boolean check(T newEntry) {
		boolean result = false;
		if (firstIndexOf(newEntry) != -1){
			result = true;
		}
		return result;
	}

	@Override
	public T lookAt(int index) {
		T temp = null;
		Node a = nodeAtIndex(index);
		if (a != null){
			temp = a.data;
		}
		return temp;
	}

	@Override
	public int count() {
		return numOfItems;
	}

	@Override
	public boolean isEmpty() {
		Boolean result = false;
		if (numOfItems == 0){
			result = true;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public T[] lookAtAll() {
		T[] temp = (T[])new Object[numOfItems];
		for (int i = 0; i < numOfItems; i++){
			temp[i] = nodeAtIndex(i).data;
		}
		
		return temp;
	}
	
	@Override
	public boolean removeAll() {
		first = null;
		last = null;
		numOfItems = 0;
		return true;
	}
	
	
	/**
	 * Gets the node at index
	 * @param index to get node
	 * @return node at index, else null
	 */
	private Node nodeAtIndex(int index){
		Node temp = first;
		if (index < 0 || index >= numOfItems){
			temp = null;
		}
		else {
			for (int i = 0; i < numOfItems; i++){
				if (temp == null){
					break;
				}
				else if (i == index){
					break;
				}
				temp = temp.adr;
			}
		}
		return temp;
	}
	
	/**
	 * Gets the first index of a node containing the specific entry
	 * @param newEntry to search for
	 * @return index of found node, else -1
	 */
	private int firstIndexOf(T newEntry){
		int temp = -1;
		Node t = first;
		for (int i = 0; i < numOfItems; i++){
			if (t == null){
				break;
			}
			else if (t.data == newEntry){
				temp = i;
				break;
			}
			t = t.adr;
		}
		return temp;
	}

}
