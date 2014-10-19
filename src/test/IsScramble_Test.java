package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import crack_interview.isScramble;

public class IsScramble_Test {
	isScramble test;
	@Before
	public void Before(){
		test = new isScramble();
	}
	@Test
	public void test() {
		System.out.println(test.isScramble("sqksrqzhhmfmlmqvlbnaqcmebbkqfy", "abbkyfqemcqnblvqmlmfmhhzqrskqs"));
	}
	@Test
	public void test2(){
		System.out.println(test.isScramble1("sqksrqzhhmfmlmqvlbnaqcmebbkqfy", "abbkyfqemcqnblvqmlmfmhhzqrskqs"));
	}

}
