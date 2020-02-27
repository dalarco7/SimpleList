/**
 * @author Daniel Alarcon
 * Class ID: 139
 * Assignment #: 1
 * 
 * Description:
 * 	SimpleList is an array of ten integers. Integers can be added with the add
 * method and integers can be removed with the remove method. The count method
 * returns the number of added integers in the SimpleList.
 * 
 * 	When integers are added, the contents of the SimpleList are shifted to the
 * right, to the next higher index value, and the new integer is inserted into
 * index 0. The count is then incremented. When the SimpleList is full and a 
 * new integer is being added, the last integer essentially "falls off" and is
 * lost. The count remains the same because the number of integers in the 
 * SimpleList has not changed.
 * 
 * 	When integers are removed, the search method finds the integer in the
 * SimpleList and returns the index of that integer. Otherwise, the search
 * method returns a -1. Using that index, the contents of the SimpleList are
 * shifted to the left, to the next lower index value, starting from that index
 * from the search method. The integer is essentially overwritten. Finally, the
 * last integer of the SimpleList is cleared to 0 and the count is decremented.
 * If the queried integer is not found in the SimpleList, which the search
 * method returns a -1, the SimpleList is not modified and the remove method
 * exits.
 * 
 *	The toString method returns the SimpleList as a String. The String returned
 * is the integers in the SimpleList separated by a space. However, the last
 * integer in the String does not have a space after it.
 */

package cse360assign2;

public class SimpleList {
	
	final int MAXSIZE = 10;
	
	private int[] list;
	private int count;
	
	/**
	 * Class constructor for SimpleList.
	 */
	public SimpleList() {
		list = new int[MAXSIZE];
		count = 0;
	}
	
	/**
	 * Add an element to index 0 by shifting all elements to the right starting
	 * from the highest index.
	 * 
	 * @param element	the integer to be added to the SimpleList
	 */
	public void add(int element) {
		for (int iterate = MAXSIZE - 1; iterate > 0; iterate--)
			list[iterate] = list[iterate - 1];
		
		list[0] = element;
		count = count == MAXSIZE ? count : ++count;
	}
	
	/**
	 * Remove an element from the index the search method returns and then
	 * shifting all elements to the right of it to the left.
	 * 
	 * @param element	the integer to be removed from the SimpleList
	 */
	public void remove(int element) {
		int position = search(element);
		if (position == -1) return;
		
		while (position < (MAXSIZE - 1)) {
			list[position] = list[position + 1];
			position++;
		}
		
		list[MAXSIZE - 1] = 0;
		count--;
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
		
		for (int iterate = 0; iterate < MAXSIZE; iterate++) {
			listString = listString.concat(Integer.toString(list[iterate]));
			
			if (iterate != (MAXSIZE - 1))
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
		
		for (int iterate = 0; iterate < MAXSIZE; iterate++)
			if (list[iterate] == element)
				index = iterate;
		
		return index;
	}
}