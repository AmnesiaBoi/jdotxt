package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
//import org.junit.jupiter.api.Test;

public class Tests {

	// Eduardo
	// https://www.vogella.com/tutorials/JUnit/article.html
	@Test
	//Cursor Position #1
	public void CursorPositionCalcTest(newValue, task){
		String newValue = "hello";
		String piorValue = "world";
		task = newValue - priorValue;
			return task;
	}

	@Test
	//Cursor Position #2
	public void CursorPositionCalcTest2(){
		  //int random = randomFunction();
		  int piorValue = -90;
		  int newValue = 80;
		  assertTrue("Error, random is too high", newValue - piorValue >= 0);
		  System.out.println("Test passed: " + newValue + " higher than " + piorValue);
	//Eduardo
	}

/*
 * 	public static String insertPadded(String s, int insertAt,
			String stringToInsert) {
		if (Strings.isEmptyOrNull(stringToInsert)) {
			return s;
		}

		if (insertAt < 0) {
			throw new IndexOutOfBoundsException("Invalid insertAt of ["
					+ insertAt + "] for string [" + s + "]");
		}
 */

	@Test
	//PADDED TEST #1
	public void insertPaddedTest_NULL(){
		//int random = randomFunction();
		assertEquals("TestNULL", Strings.insertPadded("TestNULL", 10, null));
	}
	@Test
	//PADDED TEST #2
	public void insertPaddedTest_notNULL(){
		//int random = randomFunction();
		assertEquals("TestnotNULL", Strings.insertPadded("TestnotNULL", 10, "helloworld"));
	}
	
	/*
	 * 	public static String getRelativeDate(Calendar calendar) {
		Calendar today = new GregorianCalendar();
		today.set(GregorianCalendar.HOUR_OF_DAY, 0);
		today.set(GregorianCalendar.MINUTE, 0);
		today.set(GregorianCalendar.SECOND, 0);
		today.set(GregorianCalendar.MILLISECOND,0);
		
		return getRelativeDate(today, calendar);
	}
	 */
	
	// reference - https://www.baeldung.com/java-string-valid-date
	//Valid Date #2

	@Test
	public void dateMustBeValid implements void DateValidator(){
		DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
		GregorianCalendar validator = new GregorianCalendar();
			//today.set(GregorianCalendar.HOUR_OF_DAY, 32);
			//today.set(GregorianCalendar.MINUTE, 4234);
			//today.set(GregorianCalendar.SECOND, 2424);
			//today.set(GregorianCalendar.MILLISECOND,23434);
				assertTrue(validator.isValid("2019-02-28"));
				assertFalse(validator.isValid("2019-02-30"));
	}

}
