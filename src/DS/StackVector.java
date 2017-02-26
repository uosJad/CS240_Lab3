package DS;
import java.util.Vector;


public final class StackVector<T> implements StackInterface<T>{

	private Vector<T> v;
	
	private static final int MAX_SIZE = 10;
	
	public StackVector(){
		v = new Vector<T>(0,1);
	}
	
	@Override
	public void push(T newEntry) {
		if (v.size() < MAX_SIZE)
			v.add(newEntry);
	}

	@Override
	public T pop() {
		T temp = null;
		if (!isEmpty())
			temp = v.remove(v.size()-1);
		return temp;
	}

	@Override
	public T peek() {
		return v.lastElement();
	}

	@Override
	public boolean isEmpty() {
		return v.isEmpty();
	}

	@Override
	public void clear() {
		v.clear();
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] temp = null;
		
		if (!isEmpty()){
			
			temp = (T[])new Object[v.size()]; 
			for (int i = 0; i < v.size(); i++){
				temp[i] = v.get(i);
			}
		}
		
		return temp;
	}

	
}
