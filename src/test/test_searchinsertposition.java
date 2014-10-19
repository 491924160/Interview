package test;

import static org.junit.Assert.*;

import org.junit.Test;

import crack_interview.searchinsertposition;

public class test_searchinsertposition {
	
	@Test
	public void test() {
		searchinsertposition test = new searchinsertposition();
		int[] a = {1,3,5,6};
		assertEquals(2, test.searchInsert(a, 5));
		assertEquals(1, test.searchInsert(a, 2));
		assertEquals(4, test.searchInsert(a, 7));
		assertEquals(0, test.searchInsert(a, 0));
		int[] b = {3,5,7,9,10};
		
	}

}
