package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HiddenFilterTest {

	@Test
	public void testFilterHiddenTask()
	{
		Task t = new Task(0, "h:1");
		
		HiddenFilter filter = new HiddenFilter();
		
		boolean actual = filter.apply(t);
		
		assertFalse(actual);
	}
	
	@Test
	public void testFilterNotHiddenTask()
	{
		Task t = new Task(0, "task");
		
		HiddenFilter filter = new HiddenFilter();
		
		boolean actual = filter.apply(t);
		
		assertTrue(actual);
	}
	
}
