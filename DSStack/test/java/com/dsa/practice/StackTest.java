package com.dsa.practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		Stack stack=new Stack();
		assertEquals(true, stack.isEmpty()); 
		try {
			stack.push("first");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("first", stack.peek());
		assertEquals(false, stack.isEmpty());
		try {
			stack.push("second");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("second", stack.peek());
		stack.pop();
		assertEquals("first", stack.peek());
	}

}
