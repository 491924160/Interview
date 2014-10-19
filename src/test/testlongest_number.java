package test;
import static org.junit.Assert.*;

import org.junit.Test;

import crack_interview.longest_numberstring;

public class testlongest_number {

	@Test
	public void test() {
		assertEquals("12345", new longest_numberstring().longest("12345"));
		assertEquals("123", new longest_numberstring().longest("abc123"));
		assertEquals("12356", new longest_numberstring().longest("12356abc123"));
		
	}

}
