package com.todotxt.todotxttouch.util;

import org.junit.Test;
//import org.junit.jupiter.api.Test;

public class Tests {

	// Eduardo
	// https://www.vogella.com/tutorials/JUnit/article.html
	@Test

	public void CursorPositionCalcTest(newValue, task){
		String newValue = "hello";
		String piorValue = "world";
		task = newValue - priorValue;
			return task;
	}

	@Test
	public void CursorPositionCalcTest2(){
		  //int random = randomFunction();
		  int piorValue = -90;
		  int newValue = 80;
		  assertTrue("Error, random is too high", newValue - piorValue >= 0);
		  System.out.println("Test passed: " + newValue + " higher than " + high + " piorValue");
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
	public void insertPaddedTest_NULL(){
		//int random = randomFunction();
		assertEquals("TestNULL", Strings.insertPadded("TestNULL", 10, null));
	}
	@Test
	public void insertPaddedTest_notNULL(){
		//int random = randomFunction();
		assertEquals("TestnotNULL", Strings.insertPadded("TestnotNULL", 10, "helloworld"));
	}
}
