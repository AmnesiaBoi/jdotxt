package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.chschmid.jdotxt.gui.JdotxtGUI;

public class JdotxtTaskBagImplTest {
	
	@Before
	public void setup()
	{
		JdotxtGUI.loadLookAndFeel("English");
	}
	
	/*
	 * JdotxtTaskBagImpl::new(LocalTaskRepository localRepository)
	 */
	
	@Test
	public void testNewJdotxtTaskBagNullRepo()
	{
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		
		assertEquals(0, taskBag.size());
		assertEquals(Collections.EMPTY_LIST, taskBag.getTasks());
		assertEquals(Collections.EMPTY_LIST, taskBag.getContexts(false));
		assertEquals(Collections.EMPTY_LIST, taskBag.getPriorities());
		assertEquals(Collections.EMPTY_LIST, taskBag.getProjects(false));
	}
	
	/*
	 * JdotxtTaskBagImpl::addAsTask(String input)
	 */
	
	@Test
	public void testAddAsTask()
	{
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		
		taskBag.addAsTask("task t +p @c");
		
		List<Task> actual = taskBag.getTasks(); 
		List<Task> expected = Arrays.asList(new Task(0, "task t +p @c", new Date()));
		
		assertEquals(expected, actual);
	}
	
	/*
	 * JdotxtTaskBagImpl::delete(Task task)
	 */
	
	@Test
	public void testDeleteTask()
	{
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		
		Task t = new Task(0, "task t +p @c", new Date());
		
		taskBag.addAsTask("task t +p @c");
		taskBag.delete(t);
		
		List<Task> actual = taskBag.getTasks(); 
		List<Task> expected = new ArrayList<>();
		
		assertEquals(expected, actual);
	}
}
