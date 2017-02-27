package DS;


/**
 * Interface of list ADT
 * @author Jason Wu
 * 
 * @param <T> generic data type
 */
public interface ListInterface <T> {
	
	/**
	 * Adds item to end of list
	 * @param newEntry to add
	 * @return true if successful, else false
	 */
	public boolean add(T newEntry);
	
	/**
	 * Adds item to index
	 * @param newEntry to add
	 * @param index to add at
	 * @return true if successful, else false
	 */
	public boolean add(T newEntry, int index);
	
	/**
	 * Removes first occurrence of item
	 * @param newEntry to remove
	 * @return true if successful, else if not found, false
	 */
	public boolean remove(T newEntry);
	
	/**
	 * Remove item at index
	 * @param index to remove
	 * @return true if successful, else false
	 */
	public boolean remove(int index);
	
	/**
	 * Removes all elements in list
	 * @return true is successful, else false
	 */
	public boolean removeAll();
	
	/**
	 * Replaces first occurrence of toReplace, with newEntry
	 * @param toReplace item to replace
	 * @param newEntry item to fill
	 * @return true if successful, else false
	 */
	public boolean replace(T toReplace, T newEntry);
	
	/**
	 * Replaces item at index with newEntry2
	 * @param index to replace
	 * @param newEntry to fill
	 * @return true if successful, else false
	 */
	public boolean replace(int index, T newEntry);
	
	/**
	 * Replaces a copy of index2 to index1
	 * @param index1 to replace
	 * @param index2 to copy from and fill
	 * @return true if successful, else false
	 */
	public boolean replace(int index1, int index2);
	
	/**
	 * Checks if an item is in the list
	 * @param newEntry to check
	 * @return true if found
	 */
	public boolean check(T newEntry);

	/**
	 * Gets item at index
	 * @param index to look at
	 * @return T at the index, null if index not valid
	 */
	public T lookAt(int index);
	
	/**
	 * Returns the number of items in the list
	 * @return number of items in the list
	 */
	public int count();
	
	/**
	 * Checks to see if the list is empty
	 * @return true if empty, else false
	 */
	public boolean isEmpty();
	
	/**
	 * Returns a copy of the list
	 * @return an array that is a copy of the list
	 */
	public T[] lookAtAll();
	
	public int getLength();
}
