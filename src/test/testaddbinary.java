package test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import crack_interview.addbinary;

public class testaddbinary {
	addbinary bn;
	@Before
	public void before(){
		bn = new addbinary();
	}
	@Test
	public void testAddBinary() {
		assertEquals("100", bn.addBinary("11", "1")); }

}
