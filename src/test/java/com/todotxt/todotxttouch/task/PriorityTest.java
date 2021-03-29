package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PriorityTest {
	
	@Test
	public void testPriorityRangeForward() {
		List<Priority> actual = Priority.range(Priority.A, Priority.D);
		List<Priority> expected = Arrays.asList(Priority.A, 
				                                Priority.B, 
				                                Priority.C,
				                                Priority.D);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testPriorityRangeBackwards() {
		List<Priority> actual = Priority.range(Priority.D, Priority.A);
		List<Priority> expected = Arrays.asList(Priority.D,
							                    Priority.C,
							                    Priority.B,
							                    Priority.A);

		assertEquals(expected, actual);
	}

	@Test
	public void testPriorityRangeInCode() {
		List<String> actual = Priority.rangeInCode(Priority.X, Priority.P);
		List<String> expected = Arrays.asList("X", "W", "V", "U", "T", "S", "R", "Q", "P");

		assertEquals(expected, actual);
	}
	
	@Test
	public void testInCode()
	{
		List<Priority> priorities = Arrays.asList(Priority.A, 
				                                  Priority.B);
		
		List<String> actual = Priority.inCode(priorities); 
		List<String> expected = Arrays.asList("A", "B");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testListToPriority()
	{
		List<String> codes = Arrays.asList("A", "B");
		
		List<Priority> actual = Priority.toPriority(codes);
		List<Priority> expected = Arrays.asList(Priority.A,
				                                Priority.B);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNullStringToPriority()
	{
		Priority actual = Priority.toPriority((String) null);
		Priority expected = Priority.NONE;
		
		assertEquals(expected, actual);
	}
	
}
