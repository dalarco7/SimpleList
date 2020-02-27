/**
 * @author Daniel Alarcon
 * Class ID: 139
 * Assignment #: 1
 * 
 * Description:
 * 	SimpleListTest is a collection of methods that test for different aspects
 * of the SimpleList class. Each method focuses on one aspect of each method in
 * the SimpleList class to determine that it functions in an expected manner.
 */

package assign1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {
	
	/**
	 * Test if the created SimpleList is not null when allocated.
	 */
	@Test
	void testSimpleList() {
		SimpleList list = new SimpleList();

		assertNotNull(list);
	}

	/**
	 * Test if the toString method works as described in the assignment.
	 */
	@Test
	void testToString() {
		SimpleList list = new SimpleList();
		
		assertEquals("0 0 0 0 0 0 0 0 0 0", list.toString());
		assertNotEquals("0 0 0 0 0 0 0 0 0 0 ", list.toString());
	}
	
	/**
	 * Test if the SimpleList is constructed with the correct values.
	 */
	@Test
	void testInitial() {
		SimpleList list = new SimpleList();

		assertEquals("0 0 0 0 0 0 0 0 0 0", list.toString());
		assertEquals(0, list.count());
	}

	/**
	 * Test if elements are added to the SimpleList as described in the
	 * assignment.
	 */
	@Test
	void testAdd() {
		SimpleList list = new SimpleList();
		
		list.add(1);
		list.add(2);
		list.add(3);

		assertEquals("3 2 1 0 0 0 0 0 0 0", list.toString());
		assertEquals(3, list.count());
	}

	/**
	 * Test if an element "falls off" when the SimpleList is full and does
	 * not affect the count.
	 */
	@Test
	void testAddAll() {
		SimpleList list = new SimpleList();
		
		list.add(18);
		list.add(12);
		list.add(35);
		list.add(69);
		list.add(48);
		list.add(34);
		list.add(7);
		list.add(97);
		list.add(26);
		list.add(31);
		
		assertEquals("31 26 97 7 34 48 69 35 12 18", list.toString());
		assertEquals(10, list.count());
		
		list.add(82);
		
		assertEquals("82 31 26 97 7 34 48 69 35 12", list.toString());
		assertEquals(10, list.count());
	}
	
	/**
	 * Test if the search method returns the correct index of the queried
	 * element.
	 */
	@Test
	void testSearchFound() {
		SimpleList list = new SimpleList();
		
		list.add(18);
		list.add(12);
		list.add(35);
		list.add(69);
		list.add(48);
		list.add(34);
		list.add(7);
		list.add(97);
		list.add(26);
		list.add(31);
		
		assertEquals(7, list.search(35));
	}
	
	/**
	 * Test if the search method returns a -1 when the queried element is not
	 * found.
	 */
	@Test
	void testSearchNotFound() {
		SimpleList list = new SimpleList();
		
		list.add(18);
		list.add(12);
		list.add(35);
		list.add(69);
		list.add(48);
		list.add(34);
		list.add(7);
		list.add(97);
		list.add(26);
		list.add(31);
		
		assertEquals(-1, list.search(77));
	}
	
	/**
	 * Test if an element is removed, the count is decremented, and the 
	 * SimpleList is modified as described in the assignment.
	 */
	@Test
	void testRemove() {
		SimpleList list = new SimpleList();
		
		list.add(18);
		list.add(12);
		list.add(35);
		list.add(69);
		list.add(48);
		list.add(34);
		list.add(7);
		list.add(97);
		list.add(26);
		list.add(31);
		
		list.remove(7);
		
		assertEquals("31 26 97 34 48 69 35 12 18 0", list.toString());
		assertEquals(9, list.count());
	}
	
	/**
	 * Test if the count is not decremented and the SimpleList does not
	 * change when trying to remove an element not in the SimpleList.
	 */
	@Test 
	void testRemoveNotFound() {
		SimpleList list = new SimpleList();
		
		list.add(18);
		list.add(12);
		list.add(35);
		list.add(69);
		list.add(48);
		list.add(34);
		list.add(7);
		list.add(97);
		list.add(26);
		list.add(31);
		
		list.remove(98);
		
		assertEquals("31 26 97 7 34 48 69 35 12 18", list.toString());
		assertEquals(10, list.count());
	}
}