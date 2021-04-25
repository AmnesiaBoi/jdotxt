package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class AndFilterTest {

	@Test
	public void emptyFilterTest()
	{
		AndFilter filter = new AndFilter();
		
		Task t = new Task();
		
		assertTrue(filter.apply(t));	
	}
	
	@Test
	public void oneFilterTrueTest()
	{
		AndFilter filter = new AndFilter();
		ByContextFilter contextFilter = new ByContextFilter(Arrays.asList("context"));
		filter.addFilter(contextFilter);
		
		Task t = new Task(0, "@context");
		
		assertTrue(filter.apply(t));
	}
	/*
	 * diogo
	@Test
	public void oneFilterFalseTest()
	{
		AndFilter filter = new AndFilter();
		ByContextFilter contextFilter = new ByContextFilter(Arrays.asList("context"));
		filter.addFilter(contextFilter);
		
		Task t = new Task(0, "@other");
		
		assertTrue(filter.apply(t));
	}
	*/
	@Test(expected=NullPointerException.class)
	public void andFilterTest1(){
		AndFilter filter = new AndFilter();
		ByContextFilter contextFilter = new ByContextFilter(Arrays.asList(null));
		filter.addFilter(contextFilter);
		
		Task t = new Task(9, null);
		
		assertTrue(filter.apply(t));
	}
}
