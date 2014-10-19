package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import crack_interview.permutation;

public class Permutaion_test {
	@BeforeClass
	public static void a(){
		int[] num = {-1,-1,-1,3};
	}
	@Test
	public void test() {
		int[] num = {-1,-1,-1,3};
		permutation test = new permutation();
		test.permutation(num, 0);
	}
	
	@Test
	public void test2() {
		int[] num = {-1,-1,-1,3};
		permutation test = new permutation();
		test.permuteUnique(num);
	}

}
