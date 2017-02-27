package DS;
import java.util.Vector;

/**
 * Vector implementation of list
 * @author Jason Wu
 *
 * @param <T> generic data type
 */
public class ListVector<T> implements ListInterface<T>{
	private Vector<T> v;
	
	public ListVector(){
		v = new Vector<T>();
	}
	
	@Override
	public boolean add(T newEntry) {
		v.addElement(newEntry);
		return true;
	}

	@Override
	public boolean add(T newEntry, int index) {
		v.add(index, newEntry);
		return true;
	}

	@Override
	public boolean remove(T newEntry) {
		v.removeElement(newEntry);
		return true;
	}

	@Override
	public boolean remove(int index) {
		v.remove(index);
		return true;
	}

	@Override
	public boolean replace(T toReplace, T newEntry) {
		boolean result = false;
		int temp = v.indexOf(toReplace);
		if (temp != -1){
			v.add(temp, newEntry);
			result = true;
		}
		return result;
	}

	@Override
	public boolean replace(int index, T newEntry) {
		boolean result = false;
		if (v.elementAt(index)!= null){
			v.add(index, newEntry);
			result = true;
		}
		return result;
	}

	@Override
	public boolean replace(int index1, int index2) {
		boolean result = false;
		if (v.elementAt(index1) != null && v.elementAt(index2) != null){
			v.add(index1, v.elementAt(index2));
			result = true;
		}
		return result;
	}

	@Override
	public boolean check(T newEntry) {
		boolean result = false;
		if (v.indexOf(newEntry) != -1){
			result = true;
		}
		return result;
	}

	@Override
	public T lookAt(int index) {
		return v.elementAt(index);
	}

	@Override
	public int count() {
		return v.size();
	}

	@Override
	public boolean isEmpty() {
		return v.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] lookAtAll() {
		return (T[]) v.toArray();
	}

	@Override
	public boolean removeAll() {
		v.removeAllElements();
		return true;
	}

	@Override
	public int getLength() {
		return v.size();
	}

}
