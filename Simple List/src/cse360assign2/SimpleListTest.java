/**
 * @author Daniel Alarcon
 * Class ID: 139
 * Assignment #: 2
 * 
 * Description:
 * 	SimpleListTest is a collection of methods that test for different aspects
 * of the SimpleList class. Each method focuses on one aspect of each method in
 * the SimpleList class to determine that it functions in an expected manner.
 */

package cse360assign2;

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
		
		assertEquals("", list.toString());
	}
	
	/**
	 * Test if the SimpleList is constructed with the correct values.
	 */
	@Test
	void testInitial() {
		SimpleList list = new SimpleList();

		assertEquals("", list.toString());
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

		assertEquals("3 2 1", list.toString());
		assertEquals(3, list.count());
	}

	/**
	 * Test if the SimpleList increases in size when full and the integer is
	 * inserted.
	 */
	@Test
	void testAddIncrease() {
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
		
		list.add(82);
		
		assertEquals("82 31 26 97 7 34 48 69 35 12 18", list.toString());
		assertEquals(11, list.count());
	}
	
	/**
	 * Test if the size of the SimpleList is increased by 50% every time an
	 * element is added when the SimpleList is full.
	 */
	@Test
	void testAddSize() {
		SimpleList list = new SimpleList();
		
		list.add(25);
		list.add(39);
		list.add(28);
		list.add(64);
		list.add(65);
		list.add(17);
		list.add(57);
		list.add(2);
		list.add(38);
		list.add(9);
		
		list.add(17);
		list.add(57);
		list.add(2);
		list.add(38);
		list.add(9);
		
		list.add(45);
		
		assertEquals(22, list.size());
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
		
		assertEquals("31 26 97 34 48 69 35 12 18", list.toString());
		assertEquals(9, list.count());
	}
	
	/**
	 * Test if the SimpleList decreases by 25% in size every time an element is
	 * removed and there is more than 25% unused space.
	 */
	@Test
	void testRemoveSize() {
		SimpleList list = new SimpleList();
		
		list.add(28);
		list.add(45);
		list.add(39);

		list.remove(45);
		list.remove(28);
		
		assertEquals(5, list.size());
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
	
	/**
	 * Test if an element is appended to the end of the SimpleList as described
	 * in the assignment.
	 */
	@Test
	void testAppend() {
		SimpleList list = new SimpleList();
		
		list.add(18);
		list.add(28);
		list.add(36);
		
		list.append(7);
		
		assertEquals("36 28 18 7", list.toString());
		assertEquals(4, list.count());
	}
	
	/**
	 * Test if the SimpleList increases in size when full and the integer is
	 * appended.
	 */
	@Test
	void testAppendIncrease() {
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
		
		list.append(82);
		
		assertEquals("31 26 97 7 34 48 69 35 12 18 82", list.toString());
		assertEquals(11, list.count());
	}
	
	/**
	 * Test if the size of the SimpleList is increased by 50% every time an
	 * element is appended when the SimpleList is full.
	 */
	@Test
	void testAppendSize() {
		SimpleList list = new SimpleList();
		
		list.add(25);
		list.add(39);
		list.add(28);
		list.add(64);
		list.add(65);
		list.add(17);
		list.add(57);
		list.add(2);
		list.add(38);
		list.add(9);
		
		list.append(17);
		list.append(57);
		list.append(2);
		list.add(38);
		list.add(9);
		
		list.append(45);
		
		assertEquals(22, list.size());
	}
	
	/**
	 * Test if the first method retrurns the first element of the SimpleList.
	 */
	@Test
	void testFirst() {
		SimpleList list = new SimpleList();
		
		list.add(18);
		list.add(12);
		list.add(35);
		list.add(69);
		list.add(48);
		list.add(34);
		list.add(7);
		list.remove(7);
		
		assertEquals(34, list.first());
	}
	
	/**
	 * Test if the first method returns a -1 if there is no first element.
	 */
	@Test
	void testFirstNull() {
		SimpleList list = new SimpleList();
		
		assertEquals(-1, list.first());
	}
	
	/**
	 * Test if the last method returns the last element of the SimpleList.
	 */
	@Test
	void testLast() {
		SimpleList list = new SimpleList();
		
		list.add(25);
		list.add(39);
		list.add(28);
		list.add(64);
		list.add(65);
		list.add(17);
		list.add(57);
		list.add(2);
		list.add(38);
		list.add(9);
		
		list.add(17);
		list.add(57);
		list.add(2);
		list.add(38);
		list.add(9);
		
		list.add(45);
		
		assertEquals(25, list.last());
	}
	
	/**
	 * Test if the last method returns a -1 if there is no last element.
	 */
	@Test
	void testLastNull() {
		SimpleList list = new SimpleList();
		
		assertEquals(-1, list.last());
	}
}