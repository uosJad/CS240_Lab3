package DS;

public final class QueueArray<T> implements QueueInterface<T> {
	T[] arr;
	
	private int front;
	private int back;
	
	private static final int MAX_SIZE = 50;
	
	@SuppressWarnings("unchecked")
	public QueueArray(){
		arr = (T[])new Object[MAX_SIZE+1]; //empty slot at end
		front = 0;
		back = 0;
	}
	
	@Override
	public boolean enqueue(T newEntry) {
		boolean r = true;
		if ((back+1)%arr.length != front){ // if not full
			arr[back] = newEntry;
			//System.out.print(back+": ");
			back++;
			if (back == arr.length){
				back = 0; // loopsback
			}
		}
		else r = false;
		return r;
		
	}

	

	@Override
	public T dequeue() {
		T temp = null;
		if (front != back){
			temp = arr[front];
			arr[front] = null;
			front++;
			if (front == arr.length){
				front = 0;
			}
			
			//System.out.print(back+", ");
			//System.out.print(front+": ");
			
		}
		
		
		
		return temp;
	}

	@Override
	public T getFront() {
		T temp = null;
		if (!isEmpty())
			temp = arr[front];
		return temp;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;
		if (front == back){
			result = true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		for (int i = 0; i < arr.length; i++){
			arr[i] = null;
		}
		front = 0;
		back = 0;
		
	}

}
