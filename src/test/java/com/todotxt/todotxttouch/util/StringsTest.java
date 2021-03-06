package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

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
		String expected = "abc";
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
		String expected = "abc";
		String actual = Strings.insertPadded("abc", 2, "abc");

		assertEquals(expected, actual);
	}
	// #3 Delims #1
	// ArrayList<String> actual = 
	// ArrayList<String> array String[]actual = split(";");
	// String[] actual = s.split(s);
	// ArrayList<String> expected = (ArrayList<String>) Arrays.asList("ab", "cd");
	// 2
	@Test 
	public static void split1(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, s.split(null, 3));
	}

	@Test 
	public void split2(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, "mid delim".split("abcdef", null));
	}

	@Test 
	public void split3(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, s.split("", ""));
	}

	@Test 
	public void split4(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, s.split("", 3));
	}

	@Test 
	public void split5(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, "no delim".split("abcdef", ""));
	}

	@Test 
	public void split6(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, "no delim".split("abcdef", 3));
	}

	@Test 
	public void split7(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, "init delim".split("abcdef", ""));
	}

	@Test 
	public void split8(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, "init delim".split("abcdef", 1));
	}

	@Test 
	public void split9(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, "end delim".split("abcdef"));
	}

	@Test 
	public void split10(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, "end delim".split("abcdef", 3));
	}

	@Test 
	public void split11(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");
		
		assertEquals(expected, "mid delim".split("abcdef"));
	}

	@Test 
	public void split12(String s, String delimeter) {
		ArrayList<String> expected = (ArrayList<String>) Arrays.asList("abc", "def");

		assertEquals(expected, "mid delim".split("abcdef", 3));
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
