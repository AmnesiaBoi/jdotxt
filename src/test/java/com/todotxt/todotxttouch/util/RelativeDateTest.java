package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.chschmid.jdotxt.gui.JdotxtGUI;

public class RelativeDateTest 
{
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final String N_MONTHS  = "2 months ago";
	private static final String ONE_MONTH = "1 month ago";
	private static final String N_DAYS    = "2 days ago";
	private static final String ONE_DAY   = "1 day ago";
	private static final String TODAY     = "today";
	
	
	@Before
	public void setup()
	{
		JdotxtGUI.loadLookAndFeel("English");
	}
	
	// Test for null
	@Test
	public void testGetRelativeDate1()
	{
		Calendar calendar = null;
		
		String expected = TODAY;
		String actual = RelativeDate.getRelativeDate(calendar);
		
		assertEquals(expected, actual);
	}
	
	// Test for today
	@Test
	public void testGetRelativeDate2()
	{
		// Today
		Calendar calendar = new GregorianCalendar();
		
		String expected = TODAY;
		String actual = RelativeDate.getRelativeDate(calendar);
		
		assertEquals(expected, actual);
	}
	
	// Test for yesterday
	@Test
	public void testGetRelativeDate3()
	{
		// Today
		Calendar calendar = new GregorianCalendar();
		// Roll one day backwards
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		String expected = ONE_DAY;
		String actual = RelativeDate.getRelativeDate(calendar);
		
		assertEquals(expected, actual);
	}
	
	// Test for 2 days ago
	@Test
	public void testGetRelativeDate4()
	{
		// Today
		Calendar calendar = new GregorianCalendar();
		// Roll two days backwards
		calendar.add(Calendar.DAY_OF_MONTH, -2);
		
		String expected = N_DAYS;
		String actual = RelativeDate.getRelativeDate(calendar);
		
		assertEquals(expected, actual);
	}
	
	// Test for a month ago
	@Test
	public void testGetRelativeDate5()
	{
		// Today
		Calendar calendar = new GregorianCalendar();
		// Roll two days backwards
		calendar.add(Calendar.MONTH, -1);
		
		String expected = ONE_MONTH;
		String actual = RelativeDate.getRelativeDate(calendar);
		
		assertEquals(expected, actual);
	}
	
	// Test for 2 months ago
	@Test
	public void testGetRelativeDate6()
	{
		// Today
		Calendar calendar = new GregorianCalendar();
		// Roll two days backwards
		calendar.add(Calendar.MONTH, -2);
		
		String expected = N_MONTHS;
		String actual = RelativeDate.getRelativeDate(calendar);
		
		assertEquals(expected, actual);
	}
	
	// Test for a year ago
	@Test
	public void testGetRelativeDate7()
	{
		// Today
		Calendar calendar = new GregorianCalendar();
		// Roll one year backwards
		calendar.add(Calendar.YEAR, -1);
		
		String expected = FORMAT.format(calendar.getTime());
		String actual = RelativeDate.getRelativeDate(calendar);
		
		assertEquals(expected, actual);
	}
	
	// Test for 2 years ago
	@Test
	public void testGetRelativeDate8()
	{
		// Today
		Calendar calendar = new GregorianCalendar();
		// Roll two years backwards
		calendar.add(Calendar.YEAR, -2);
		
		String expected = FORMAT.format(calendar.getTime());
		String actual = RelativeDate.getRelativeDate(calendar);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * String getRelativeDate(Calendar calendar)
	 */
	
	@Test
	public void getRelativeDateWithCalendarTest()
	{
		Calendar today = new GregorianCalendar();
		
		String expected = TODAY;
		String actual = RelativeDate.getRelativeDate(today);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * String getRelativeDate(Date date)
	 */
	
	// Needed because project was made using the deprecated Date object
	@SuppressWarnings("deprecation") 
	@Test
	public void getRelativeDateWithDateTest()
	{
		Date today = new Date();
		
		today.setDate(today.getDate() - 1);
		
		String expected = ONE_DAY;
		String actual = RelativeDate.getRelativeDate(today);
		
		assertEquals(expected, actual);
	}
}
