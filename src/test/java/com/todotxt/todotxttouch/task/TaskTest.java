package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class TaskTest {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	/*
	 * Task::new()
	 */
	
	@Test
	public void testNewEmptyTask()
	{
		Task t = new Task();
		
		assertEquals(0, t.getAmount());
		assertEquals("", t.getCompletionDate());
		assertEquals(Collections.EMPTY_LIST, t.getContexts());
		assertEquals(0, t.getDuration());
		assertEquals(0, t.getId());
		assertEquals(Collections.EMPTY_LIST, t.getLinks());
		assertEquals(Collections.EMPTY_LIST, t.getMailAddresses());
		assertEquals(Priority.NONE, t.getOriginalPriority());
		assertEquals("", t.getOriginalText());
		assertEquals(Collections.EMPTY_LIST, t.getPhoneNumbers());
		assertEquals("", t.getPrependedDate());
		assertEquals(Priority.NONE, t.getPriority());
		assertEquals(Collections.EMPTY_LIST, t.getProjects());
		assertEquals("", t.getRelativeAge());
		assertEquals("", t.getText());
		
		assertNull(t.getDueDate());
		assertNull(t.getThresholdDate());
		
		assertTrue(t.isDeleted()); // ???
		assertFalse(t.isCompleted());
		assertFalse(t.isHidden());
		assertFalse(t.isRec());
		assertFalse(t.isFromThreshold());
	}
	
	/*
	 * Task::equals(Object obj)
	 */
	
	@Test
	public void testEqualsNull()
	{
		Task t = new Task();
		
		assertFalse(t.equals(null));
	}
	
	@Test
	public void testEqualsSameTask()
	{
		Task t = new Task();
		
		assertTrue(t.equals(t));
	}
	
	/*
	 * Task::copyInto(Task destination)
	 */
	
	@Test
	public void testCopyInto()
	{
		Task from = new Task(0, "abc");
		Task into = new Task();
		
		from.copyInto(into);
		
		assertEquals(from, into);
	}
	
	/*
	 * Task::markComplete(Date date)
	 */
	
	@Test
	public void testMarkComplete()
	{
		Task t = new Task(0, "(A) abcdef");
		
		Date now = new Date();
		t.markComplete(now);
		
		assertEquals(Priority.NONE, t.getPriority());
		assertEquals(DATE_FORMAT.format(now), t.getCompletionDate());
		assertFalse(t.isDeleted());
		assertTrue(t.isCompleted());
	}
	
	@Test
	public void testMarkCompleteAgain()
	{
		Task t = new Task(0, "(A) abcdef");
		
		Date now = new Date();
		t.markComplete(now);
		
		now = new Date();
		t.markComplete(now);
		
		assertEquals(Priority.NONE, t.getPriority());
		assertEquals(DATE_FORMAT.format(now), t.getCompletionDate());
		assertFalse(t.isDeleted());
		assertTrue(t.isCompleted());
	}
	
	/*
	 * Task::markIncomplete()
	 */
	
	@Test
	public void testMarkIncomplete()
	{
		Task t = new Task(0, "(A) abcdef");
		
		Date now = new Date();
		t.markComplete(now);
		
		t.markIncomplete();
		
		assertEquals("", t.getCompletionDate());
		assertFalse(t.isCompleted());
	}
	
	@Test
	public void testMarkIncompleteAgain()
	{
		Task t = new Task(0, "(A) abcdef");
		
		t.markIncomplete();
		
		assertEquals("", t.getCompletionDate());
		assertFalse(t.isCompleted());
	}
	
	/*
	 * Task::delete()
	 */
	
	@Test
	public void testDeleteTask()
	{
		Task t = new Task(0, "(A) abdc +p @c");
		
		t.delete();
		
		assertTrue(t.isDeleted());
	}
	
	/*
	 * Task::inFileFormatHeader()
	 */
	
	@Test
	public void testInFileFormatHeaderEmptyTask()
	{
		Task t = new Task();
		
		assertEquals("", t.inFileFormatHeader());
	}
	
	@Test
	public void testInFileFormatHeaderPriority()
	{
		Task t = new Task(0, "(A) abdc +p @c");
		
		assertEquals("(A) ", t.inFileFormatHeader());
	}
	
	@Test
	public void testInFileFormatHeaderCompleted()
	{
		Task t = new Task(0, "abdc +p @c");

		Date now = new Date();
		t.markComplete(now);
		
		String expected = "x " + DATE_FORMAT.format(now) + " ";
		
		assertEquals(expected, t.inFileFormatHeader());
	}
	
	/*
	 * Task::inFileFormatHeader()
	 */
	
	@Test
	public void testInFileFormatHeaderNoDateEmptyTask()
	{
		Task t = new Task();
		
		assertEquals("", t.inFileFormatHeaderNoDate());
	}
	
	@Test
	public void testInFileFormatHeaderNoDateCompleted()
	{
		Task t = new Task(0, "abdc +p @c");

		Date now = new Date();
		t.markComplete(now);
		
		String expected = "x " + DATE_FORMAT.format(now) + " ";
		
		assertEquals(expected, t.inFileFormatHeaderNoDate());
	}
	/*
	 * new

	@Test
	public void getMailAdressesTest(){
		String a[] = new String[] { "abc@def.com", "def@abc.com"};
		List<String> actual = Arrays.asList(a);
		
		assertEquals(actual.getMailAddresses());
	}
	*/
}
