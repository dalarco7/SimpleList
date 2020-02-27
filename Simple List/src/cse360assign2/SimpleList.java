/**
 * @author Daniel Alarcon
 * Class ID: 139
 * Assignment #: 2
 * 
 * Description:
 * 	SimpleList, by default, is an array of ten integers. Integers can be added
 * with the add method and integers can be removed with the remove method. The
 * count method returns the number of added integers in the SimpleList.
 * 
 * 	When integers are added, the contents of the SimpleList are shifted to the
 * right, to the next higher index value, and the new integer is inserted into
 * index 0. The count is then incremented. If the Simple List is full when a
 * new integer is being added, the size of Simple List is increased by 50%
 * before inserting a new integer. The count is then incremented.
 * 
 * 	When integers are removed, the search method finds the integer in the
 * SimpleList and returns the index of that integer. Otherwise, the search
 * method returns a -1. Using that index, the contents of the SimpleList are
 * shifted to the left, to the next lower index value, starting from that index
 * from the search method. The integer is essentially overwritten. After the
 * integer has been removed, if there is more than 25% of unused space in the
 * Simple List, then the size of the Simple List is decreased by 25%. If the
 * queried integer is not found in the SimpleList, which the search method
 * returns a -1, the SimpleList is not modified and the remove method exits.
 * 
 *	The toString method returns the SimpleList as a String. The String returned
 * is the integers in the SimpleList separated by a space. However, the last
 * integer in the String does not have a space after it.
 */

package cse360assign2;

public class SimpleList {
	
	final int DEFAULT_SIZE = 10;
	final int SMALLEST_SIZE = 1;
	final float INCREASE_SIZE = 1.5f;
	final float DECREASE_SIZE = 0.75f;
	final float EMPTY_THRESHOLD = 0.25f;
	
	private int[] list;
	private int count;
	
	/**
	 * Class constructor for SimpleList.
	 */
	public SimpleList() {
		list = new int[DEFAULT_SIZE];
		count = 0;
	}
	
	/**
	 * Add an element to index 0 by shifting all elements to the right starting
	 * from the highest index. If the list is full, then the list is copied
	 * over to a new list that is 50% bigger in size.
	 * 
	 * @param element	the integer to be added to the SimpleList
	 */
	public void add(int element) {
		if (count == list.length) {
			int[] tempList = new int[list.length];
			
			for (int iterate = 0; iterate < list.length; iterate++)
				tempList[iterate] = list[iterate];
			
			list = new int[(int) (list.length * INCREASE_SIZE)];
			
			for (int iterate = 0; iterate < tempList.length; iterate++)
				list[iterate] = tempList[iterate];
		}
		
		for (int iterate = list.length - 1; iterate > 0; iterate--)
			list[iterate] = list[iterate - 1];
		
		list[0] = element;
		++count;
	}
	
	/**
	 * Remove an element from the index the search method returns and then
	 * shifting all elements to the right of it to the left. After the element
	 * is removed, if more than 25% of the Simple List is unused then the list
	 * is copied over to a new list that is 25% smaller in size.
	 * 
	 * @param element	the integer to be removed from the SimpleList
	 */
	public void remove(int element) {
		int position = search(element);
		if (position == -1) return;
		
		while (position < (count - 1)) {
			list[position] = list[position + 1];
			position++;
		}

		count--;
		float sizeOfEmpty = 1 - ((float) count / list.length);
		
		if (list.length != SMALLEST_SIZE && sizeOfEmpty > EMPTY_THRESHOLD) {
			int[] tempList = new int[list.length];
			
			for (int iterate = 0; iterate < list.length; iterate++)
				tempList[iterate] = list[iterate];
			
			list = new int[(int) (list.length * DECREASE_SIZE)];
			
			for (int iterate = 0; iterate < list.length; iterate++)
				list[iterate] = tempList[iterate];
		}
	}
	
	/**
	 * Gets the count of elements in the SimpleList.
	 * 
	 * @return	the number of elements currently in the SimpleList
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Returns the String representation of the SimpleList.
	 * 
	 * @return	the SimpleList as a readable String
	 */
	public String toString() {
		String listString = "";
		
		for (int iterate = 0; iterate < count; iterate++) {
			listString = listString.concat(Integer.toString(list[iterate]));
			
			if (iterate != (count - 1))
				listString = listString.concat(" ");
		}
		return listString;
	}
	
	/**
	 * Gets the position of the queried element.
	 * 
	 * @param element	the integer to be searched in the SimpleList
	 * @return			the index of the queried element
	 */
	public int search(int element) {
		int index = -1;
		
		for (int iterate = 0; iterate < count; iterate++)
			if (list[iterate] == element)
				index = iterate;
		
		return index;
	}
}