package DS;
import Foods.Ingredient;


/**
	Integer array implementation of sorting algorithms
	@author Jason Wu
*/
public class Sorting {
	private int[] arr;
	private int maxSize = 10;
	private int countMove, countCompare;
	
	//TODO implement initialization check
	//private boolean intialized = false;
	
	public Sorting(int[] a){
		arr = CopyArray(a);
	}
	
	public int[] toArray() {
		//@SuppressWarnings("unchecked")
		//T[] temp = (T[])new Object[a.length];
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++){
			temp[i] = arr[i];
		}
		return temp;
	}
	
	public int[] CopyArray(int[] a) {
		//@SuppressWarnings("unchecked")
		//T[] temp = (T[])new Object[a.length];
		int[] temp = new int[a.length];
		for (int i = 0; i < a.length; i++){
			temp[i] = a[i];
		}
		return temp;
	}
	
	public int[] CopyArray(int[] a, int low, int high) {
		//@SuppressWarnings("unchecked")
		//T[] temp = (T[])new Object[a.length];
		int[] temp = new int[high-low];
		for (int i = low; i < high; i++){
			temp[i-low] = a[i];
		}
		return temp;
	}
	
	/**
	 * Applies an iterative implementation of selective sort to array
	 * @return sorted array
	 */
	public int[] SelectiveSortIterative(){
		countMove = 0;
		countCompare = 0;
		int[] temp = CopyArray(arr);
		
		int least;
		for (int i = 0; i < temp.length; i++){
			least = i;
			countCompare++;
			for (int j = i+1; j < temp.length; j++){
				// check all for least, swap least to i
				if (temp[j] < temp[least])
					least = j;
				countCompare++;
				countCompare++;
			}
			
			swap(temp,i,least);
			countMove++;
			
		}
		
		printCounts();
		return temp;
	}
	
	public void printCounts(){
		System.out.println("cm: "+ countMove + ", cc:" + countCompare);
	}
	
	public void rc(){
		countMove = 0;
		countCompare = 0;
	}
	/**
	 * User access version of SelectiveSortRecursive
	 * @return copy of sorted array
	 */
	public int[] SelectiveSortRecursive(){
		return SelectiveSortRecursive(CopyArray(arr), 0, 1, -1);
	}
	
	/**
	 * Implementation of recursive selective sorting algorithm
	 * @param tempArray array to sort
	 * @param currentIndex starting index (i)
	 * @param checkingIndex should always equal current index + 1 at start (j)
	 * @param least records index with least value, -1 if starting to check for least
	 * @return copy of sorted array
	 */
	private int[] SelectiveSortRecursive(int[] tempArray, int currentIndex, int checkingIndex, int least){
		
		if (currentIndex < tempArray.length) { // if current index less than length
			if (least == -1){ //if on new current index, set least
				least = currentIndex;
			}
			if (checkingIndex < tempArray.length){ // if checking is less then length
				if (tempArray[checkingIndex] < tempArray[least]) { //set checking to least if least
					least = checkingIndex;
				}
				//do recursive again with checkingIndex++
				return SelectiveSortRecursive(tempArray,  currentIndex, checkingIndex+1, least);
			}
			else //if finished checking for least (j loop)
			{
				swap(tempArray, currentIndex, least);
			}
		}
		else {
			return tempArray; // executes once recursive stack completes	
		}
		//assign least to -1 to get reassigned
		return SelectiveSortRecursive(tempArray,  currentIndex+1, currentIndex+2, -1);
	}
	
	/**
	 * iterative implementation of insertion sort
	 * @return copy of sorted array
	 */
	public int[] InsertionSortIterative(){
		countMove = 0;
		countCompare = 0;
		int[] temp = CopyArray(arr);
		int e;
		for (int i = 1; i < temp.length; i++){
			countCompare++;
			e = i;
			for (int j = i-1; j >= 0; j--){
				countCompare++;
				countCompare++;
				if (temp[e] < temp[j]){
					
					swap(temp,e,j);
					countMove++;
					e = j;
				}
				else break;
			}
		}
		
		printCounts();
		
		return temp;
	}
	
	
	/**
	 * client use of recursive implementation of insertion sort
	 * @return copy of sorted array
	 */
	public int[] InsertionSortRecursive(){
		return InsertionSortRecursive(CopyArray(arr),1,0,-1);
	}
	
	/**
	 * implementation of insertion sort through recursion
	 * @param temp array to sort
	 * @param i counter through element
	 * @param j counter to check
	 * @param e current index
	 * @return copy of sorted array
	 */
	private int[] InsertionSortRecursive(int[] temp, int i, int j, int e) {
		if (i < temp.length){
			if (e == -1){
				e = i;
			}
			
			if (j >=0){
				if (temp[e] < temp[j]){
					swap(temp,e,j);
					e = j;
				}
				return InsertionSortRecursive(temp, i,j-1,e);
			}
		}
		else{
			return temp;
		}
		//if finish check
		return InsertionSortRecursive(temp, i+1, i,-1);
	}
	
	/**
	 * iterative implementation of shell sort
	 * @return copy of sorted array
	 */
	public int[] ShellSortIterative(){
		rc();
		
		int[] temp = CopyArray(arr);
		
		int hib = 0;

		while (hib < temp.length/2){
			countCompare++;
			hib = hib*2+1;
		}
		
		int e = hib;
		int count = e;
		
		while (hib != 0){
			
			//if less, swap, else increase by 1. if increase is above length, refactor hib;
			countCompare++;
			if (e - hib >= 0 && temp[e] < temp[e-hib]){
				swap(temp,e,e-hib);
				countMove++;
				e = e-hib;
			}
			else{ // if e is < 0 or if element is not less than
				count++;
				e = count;
				
				//go down one sequence
				countCompare++;
				if (count >= arr.length){
					hib = (hib - 1)/2;
					e = hib;
					count = e;
				}
			}
		}
		printCounts();
		return temp;
	}
	
	/**
	 * client use of recursive shell sort
	 * @return
	 */
	public int[] ShellSortRecursive(){
		int[] temp = CopyArray(arr);
		
		int hib = 0;

		while (hib < temp.length/2){
			hib = hib*2+1;
		}
		
		return ShellSortRecursive(temp, hib, hib, hib);
		
	}
	
	/**
	 * implementation of recursive shell sort
	 * @param temp array to sort
	 * @param hib hibbard sequence number
	 * @param e checking index
	 * @param count current index
	 * @return
	 */
	private int[] ShellSortRecursive(int[] temp, int hib, int e, int count){
		
		if (hib != 0){
			
			//if less, swap, else increase by 1. if increase is above length, refactor hib;
			if (e - hib >= 0 && temp[e] < temp[e-hib]){
				swap(temp,e,e-hib);
				e = e-hib;
			}
			else{ // if e is < 0 or if element is not less than
				count++;
				e = count;
				
				//go down one sequence
				if (count >= arr.length){
					hib = (hib - 1)/2;
					e = hib;
					count = e;
				}
			}
		}
		else{
			return temp;
		}
		return ShellSortRecursive(temp, hib, e, count);
	}
	
	/**
	 * client use of iterative merge sort
	 * @return copy of sorted array
	 */
	public int[] MergeSortIterative(){
		rc();
		return MergeSortIterative(CopyArray(arr));
	}
	
	/**
	 * implementation of iterative merge sort
	 * @param temp array to sort
	 * @return sorted array
	 */
	private int[] MergeSortIterative(int[] temp){
		countCompare++;
		if (temp.length <= 1)
			return temp;
		int[] a = CopyArray(temp,0,temp.length/2);
		int[] b = CopyArray(temp,a.length, temp.length);
		
		//return sorted
		return MergeArraysIterative(MergeSortRecursive(a),MergeSortRecursive(b));
	}
	
	
	/**
	 * client use of recursive merge sort
	 * @return copy of sorted array
	 */
	public int[] MergeSortRecursive(){
		return MergeSortRecursive(CopyArray(arr));
	}
	
	/**
	 * implementation of recursive merge sort
	 * @param temp array to sort
	 * @return sorted array
	 */
	private int[] MergeSortRecursive(int[] temp){
		if (temp.length <= 1){
			return temp;
		}
		
		int[] a = CopyArray(temp,0,temp.length/2);
		int[] b = CopyArray(temp,a.length, temp.length);
		
		//return sorted
		return MergeArraysRecursive(MergeSortRecursive(a),MergeSortRecursive(b));
	}
	
	/**
	 * Merges arrays and sorts them, must insert sorted arrays first,iterative
	 * @param a array1
	 * @param b array 2
	 * @return merged array
	 */
	private int[] MergeArraysIterative(int[] a, int[] b){
		int[] temp = new int[a.length + b.length];
		int c1 = 0;
		int c2 = 0;
		int tempCount = 0;
		
		while (tempCount < temp.length){
			
			countCompare++;
			if (c1 < a.length && c2 < b.length){
				countCompare++;
				if (a[c1] < b[c2]){
					countMove++;
					temp[tempCount] = a[c1];
					c1++;
					tempCount++;
				}
				else if (a[c1] >= b[c2]){
					countCompare++;
					countMove++;
					temp[tempCount] = b[c2];
					c2++;
					tempCount++;
				}
			}
			else if (c1 < a.length){
				countCompare++;
				countMove++;
				temp[tempCount] = a[c1];
				c1++;
				tempCount++;
			}
			else if (c2 < b.length){
				countCompare++;
				countMove++;
				temp[tempCount] = b[c2];
				c2++;
				tempCount++;
			}
			
		}
		
		return temp;
	}
	
	/**
	 * Merges arrays and sorts them, must insert sorted arrays first,recursive
	 * @param a array1
	 * @param b array 2
	 * @return merged array
	 */
	private int[] MergeArraysRecursive(int[] a, int[] b){
		return MergeArraysRecursive(a,b,new int[a.length + b.length],0,0,0);
	}
	
	/**
	 * Implementation of merge arrays and sorts them, must insert sorted arrays first,recursive
	 * @param a array1
	 * @param b array 2
	 * @param temp working array
	 * @param c1 counter for a
	 * @param c2 counter for b
	 * @param tempCount counter for temp
	 * @return
	 */
	private int[] MergeArraysRecursive(int[] a, int[] b, int[] temp, int c1, int c2, int tempCount){
		
		if (tempCount < temp.length){
			if (c1 < a.length && c2 < b.length){
				if (a[c1] < b[c2]){
					temp[tempCount] = a[c1];
					c1++;
					tempCount++;
				}
				else if (a[c1] >= b[c2]){
					temp[tempCount] = b[c2];
					c2++;
					tempCount++;
				}
			}
			else if (c1 < a.length){
				temp[tempCount] = a[c1];
				c1++;
				tempCount++;
			}
			else if (c2 < b.length){
				temp[tempCount] = b[c2];
				c2++;
				tempCount++;
			}
			
		}
		else return temp;
		
		return MergeArraysRecursive(a, b, temp, c1, c2, tempCount);
	}
	
	
	public int[] QuickSortIterative(){
		rc();
		return QuickSortIterative(CopyArray(arr), 0, arr.length-1);
	}
	
	private int[] QuickSortIterative(int[] temp, int lower, int upper){
		int pivot = temp[lower+(upper-lower)/2]; // rearrange around the middle
		
		int eLower = lower;
		int eUpper= upper;
		while (eLower <= eUpper){//till index over laps
			countCompare++;
			while (temp[eLower] < pivot){ //increase till found one that is higher
				countCompare++;
				eLower++;
			}
			while (temp[eUpper] > pivot){ //decrease till one found that is lower
				countCompare++;
				eUpper--;
			}
			
			countCompare++;
			if (eLower <= eUpper){ // if lower check is less than higher check, swap
				swap(temp, eLower, eUpper);
				countMove++;
				eLower++;
				eUpper--;
			}
			
		}
		countCompare++;
		if (lower < eUpper)
			QuickSortIterative(temp, lower, eUpper);
		countCompare++;
		if (eLower < upper)
			QuickSortIterative(temp, eLower, upper);
		
		return temp;
	}
	
	public int[] QuickSortRecursive(){
		return QuickSortIterative(CopyArray(arr), 0, arr.length-1);
	}
	
	private int[] QuickSortRecursive(int[] temp, int lower, int upper){
		int pivot = temp[lower+(upper-lower)/2]; // rearrange around the middle
		
		int eLower = lower;
		int eUpper= upper;
		if (eLower <= eUpper){//till index over laps
			if (temp[eLower] < pivot){ //increase till found one that is higher
				eLower++;
			}
			
			if (temp[eUpper] > pivot){ //decrease till one found that is lower
				eUpper--;
			}
			
			if (eLower <= eUpper){ // if lower check is less than higher check, swap
				swap(temp, eLower, eUpper);
				eLower++;
				eUpper--;
			}
			
		}
		else
		{
			if (lower < eUpper)
				QuickSortIterative(temp, lower, eUpper);
			if (eLower < upper)
				QuickSortIterative(temp, eLower, upper);
			
			return temp;
		}
		
		return QuickSortRecursive(temp, lower, upper);
		
	}

	public int[] RadixSortIterative(){
		int[] temp = CopyArray(arr);
		int i = 1;
		rc();
		while (i <= 100000){
			
			temp = RadixSort(temp,i);
			i*=10;
		}
		return temp;
	}
	
	private int[] RadixSort(int[] t, int decimal){
		int[] temp = new int[t.length];
		int[] b = new int[10];
		
		int i = 0;

		while (i < temp.length){
			countCompare++;
			int digit = getDigit(t[i], decimal);
			b[digit] += 1;
			countMove++;
			i++;
		}
		
		i = 1;
		while (i < b.length){
			countCompare++;
			b[i] += b[i-1];
			countMove++;
			i++;
		}
		
		i = t.length-1;
		while (i >= 0){
			countCompare++;
			int digit = getDigit(t[i], decimal); 
			
			temp[b[digit]-1] = t[i];
			countMove++;
			b[digit]--;
			i--;
		}
		
		return temp;
	}
	
	public int[] RadixSortRecursive(){
		return RadixSortRecursive(CopyArray(arr), 1);
	}
	
	
	public int[] RadixSortRecursive(int[] temp, int i){

		
		if (i <= 100000){
			temp = RadixSort(temp,i);
			i*=10;
		}
		else return temp;
		
		return RadixSortRecursive(temp, i);
	}
	
	private int getDigit(int n, int d){
		return ((n/d)%10);
	}	
	
	/**
	 * Swaps the values of the current array at index a and b
	 * @param array array to swap
	 * @param a first index
	 * @param b second index
	 */
	private void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
