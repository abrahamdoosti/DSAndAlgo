package com.dsa.practice.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	Queue q;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		 q=new Queue(3);
	}

	@Test
	void test() {
		assertEquals(true, q.isEmpty());
		q.enqueue("first");		
		assertEquals(false, q.isEmpty());		
		q.enqueue("second");
		q.peek();
		q.enqueue("third");		
		assertEquals("first",q.dequeue());
		q.enqueue("fourth");		
		//assertEquals("second",q.dequeue());
		q.enqueue("fifth");
	}

}
