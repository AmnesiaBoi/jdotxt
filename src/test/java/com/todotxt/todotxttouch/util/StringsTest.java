package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringsTest 
{

	/*
	   	|   s   |   insertAt   | stringToInsert |
		-----------------------------------------
		| null  |      0       |      "abc"     |  null strings  
		| "abc" | <s.length()  |      null      |
		-----------------------------------------
		| "abc" |   negative   |      "abc"     |  negative insertAt
		| "abc" | >=s.length() |      "abc"     |  <=s.length()
		-----------------------------------------
		|  ""   |      0       |       ""       |  combinations  
		|  ""   |      0       |      "abc"     |
		|  ""   | <s.length()  |       ""       |
		|  ""   | <s.length()  |      "abc"     |
		| "abc" |      0       |       ""       |  
		| "abc" |      0       |      "abc"     |
		| "abc" | <s.length()  |       ""       |
		| "abc" | <s.length()  |      "abc"     |
	 */
	
	// #1 String to Insert

	@Test
	public void insertStringTest1() {
		String expected = "abc";
		String actual = Strings.insertPadded(null, 0, "abc");

		assertEquals(expected, actual);
	}

	@Test
	public void insertStringTest2() {
		String expected = "abc";
		String actual = Strings.insertPadded("abc", 2, null);

		assertEquals(expected, actual);
	}

	@Test
	public void insertStringTest3() {
		String expected = "abc";
		String actual = Strings.insertPadded("abc", -2, null);

		assertEquals(expected, actual);
	}

	@Test
	public void insertStringTest4() {
		String expected = "abc";
		String actual = Strings.insertPadded("abc", 3, "abc");

		assertEquals(expected, actual);
	}
	
	@Test
	public void insertStringTest5() {
		String expected = "abc";
		String actual = Strings.insertPadded("", 0, "");

		assertEquals(expected, actual);
	}

	@Test
	public void insertStringTest6() {
		String expected = "abc";
		String actual = Strings.insertPadded("", 0, "abc");

		assertEquals(expected, actual);
	}

	@Test
	public void insertStringTest7() {
		String expected = "abc";
		String actual = Strings.insertPadded("", 2, "");

		assertEquals(expected, actual);
	}

	@Test
	public void insertStringTest8() {
		String expected = "abc";
		String actual = Strings.insertPadded("", 2, "abc");

		assertEquals(expected, actual);
	}
	
	@Test
	public void insertStringTest9() {
		String expected = "abc";
		String actual = Strings.insertPadded("abc", 0, "");

		assertEquals(expected, actual);
	}

	@Test
	public void insertStringTest10() {
		String expected = "abc abc";
		String actual = Strings.insertPadded("abc", 0, "abc");

		assertEquals(expected, actual);
	}

	@Test
	public void insertStringTest11() {
		String expected = "abc";
		String actual = Strings.insertPadded("abc", 2, "");

		assertEquals(expected, actual);
	}

	@Test
	public void insertStringTest12() {
		String expected = "ab abc c";
		String actual = Strings.insertPadded("abc", 2, "abc");

		assertEquals(expected, actual);
	}

	@Test
	//PADDED TEST #1
	public void insertPaddedTest_NULL(){
		//int random = randomFunction();
		assertEquals("TestNULL", Strings.insertPadded("TestNULL", 10, null));
	}
	
	@Test
	//PADDED TEST #2
	public void insertPaddedTest_notNULL(){
		assertEquals("TestnotNUL helloworld L", Strings.insertPadded("TestnotNULL", 10, "helloworld"));
		// "TestnotNUL helloworld L"
	}
	
}
