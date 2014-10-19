package test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import crack_interview.addtionwithoutoperator;

public class add_test {

	@Test
	public void test() {
		addtionwithoutoperator test = new addtionwithoutoperator();
		Assert.assertEquals(11, test.add(5,6));
		Assert.assertEquals(31, test.add(11,20));
		Assert.assertEquals(-994, test.add(-1000,6));
	}

}
