package test;

import static org.junit.Assert.*;

import org.junit.Test;

import crack_interview.jumpgame2;

public class testJumpgame2 {

	@Test
	public void test() {
		jumpgame2 jp = new jumpgame2();
		int[] res = new int[250000];
		for(int i = 0; i < 250000; i++){
			res[i] = 250000-i;
		}
		assertEquals(1, jp.jump(res));
	}

}
