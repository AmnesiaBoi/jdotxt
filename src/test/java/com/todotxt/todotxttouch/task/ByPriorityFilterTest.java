package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.todotxt.todotxttouch.util.Tree;

public class ByPriorityFilterTest {
	
	/*
	 * ByPriorityFilter::new(List<Priority> priorities)
	 */
	
	private static final String String = null;

	@Test
	public void testNewPriorityFilterNullPriorities()
	{
		ByPriorityFilter filter = new ByPriorityFilter(null);
		
		List<Priority> expected = new ArrayList<>();
		List<Priority> actual = filter.getPriorities();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNewPriorityFilterWithPriorities()
	{
		List<Priority> priorities = Arrays.asList(Priority.A, Priority.B);
		
		ByPriorityFilter filter = new ByPriorityFilter(priorities);
		
		List<Priority> expected = priorities;
		List<Priority> actual = filter.getPriorities();
		
		assertEquals(expected, actual);
	}
	
	/*
	 * ByPriorityFilter::apply(Task input)
	 */
	
	@Test
	public void testFilterApply()
	{
		Task t = new Task(0, "(A) task");
		
		List<Priority> priorities = Arrays.asList(Priority.A);
		
		ByPriorityFilter filter = new ByPriorityFilter(priorities);
		
		boolean expected = true;
		boolean actual = filter.apply(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFilterApplyNoPriorities()
	{
		Task t = new Task(0, "(A) task");
		
		List<Priority> priorities = new ArrayList<>();
		
		ByPriorityFilter filter = new ByPriorityFilter(priorities);
		
		boolean expected = true;
		boolean actual = filter.apply(t);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFilterApplyTaskNoPriority()
	{
		Task t = new Task(0, "task");
		
		List<Priority> priorities = Arrays.asList(Priority.A);
		
		ByPriorityFilter filter = new ByPriorityFilter(priorities);
		
		boolean expected = false;
		boolean actual = filter.apply(t);
		
		assertEquals(expected, actual);
	}

	@Test
	public void PriorityRangeTest1() {
		List<Priority> expected = new ArrayList<>();
		expected.add(Priority.A);
		expected.add(Priority.B);
		expected.add(Priority.C);
		expected.add(Priority.D);
		expected.add(Priority.E);
		expected.add(Priority.F);

		assertEquals(expected, Priority.range(Priority.A, Priority.F));
	}

	@Test
	public void PriorityRangeTest2() {
		List<Priority> expected = new ArrayList<>();
		expected.add(Priority.F);
		expected.add(Priority.E);
		expected.add(Priority.D);
		expected.add(Priority.C);
		expected.add(Priority.B);
		expected.add(Priority.A);

		assertEquals(expected, Priority.range(Priority.F, Priority.A));
	}

	@Test
	public void PriorityRangeTest3() {
		List<Priority> expected = new ArrayList<>();
		expected.add(Priority.B);
		expected.add(Priority.C);
		expected.add(Priority.D);
		expected.add(Priority.E);
		expected.add(Priority.F);

		assertEquals(expected, Priority.rangeInCode(Priority.B, Priority.F));
	}

	@Test
	public void PriorityRangeTest4() {
		List<Priority> expected = new ArrayList<>();
		expected.add(Priority.X);
		expected.add(Priority.C);
		expected.add(Priority.D);
		expected.add(Priority.E);
		expected.add(Priority.F);

		assertEquals(expected, Priority.rangeInCode(Priority.X, Priority.F));
	}
}
