package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public void split1() {
		List<String> expected = Arrays.asList("abc", "def");
		ArrayList<String> actual = Util.split(null, ";");

		assertNotEquals(expected, actual);
	}

	@Test
	public void split2() {
		List<String> expected = Arrays.asList("abc", "def");
		List<String> actual = Util.split("", null);

		assertNotEquals(expected, actual);
	}

	@Test 
	public void split3() {
		List<String> expected = new ArrayList<String>();
		List<String> actual = Util.split("", "");

		assertEquals(expected, actual);
	}

	@Test
	public void split4() {
		List<String> expected = Arrays.asList("");
		List<String> actual = Util.split("", ";");

		assertEquals(expected, actual);
	}

	@Test
	public void split5() {
		List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f");
		List<String> actual = Util.split("abcdef", "");

		assertEquals(expected, actual);
	}

	@Test
	public void split6() {
		List<String> expected = Arrays.asList("abcdef");
		List<String> actual = Util.split("abcdef", ";");
		
		assertEquals(expected, actual);
	}

	@Test 
	public void split7() {
		List<String> expected = Arrays.asList(";", "a", "b", "c", "d", "e", "f");
		List<String> actual = Util.split(";abcdef", "");
		
		assertEquals(expected, actual);
	}

	@Test 
	public void split8() {
		List<String> expected = Arrays.asList("","abcdef");
		List<String> actual = Util.split(";abcdef", ";");
		
		assertEquals(expected, actual);
	}

	@Test 
	public void split9() {
		List<String> expected = Arrays.asList("abcdef");
		List<String> actual = Util.split("abcdef;", ";");
		
		assertEquals(expected, actual);
	}

	@Test 
	public void split10() {
		List<String> expected = Arrays.asList("abcdef;");
		List<String> actual = Util.split("abcdef;", ";");
		
		assertEquals(expected, actual);
	}

	@Test 
	public void split11() {
		List<String> expected = Arrays.asList("abc;def");
		List<String> actual = Util.split("abc;def", "");
		
		assertEquals(expected, actual);
	}

	@Test 
	
	public void split12() {
		List<String> expected = Arrays.asList("abc", "def");
		List<String> actual = Util.split("abc;def", ";");

		assertNotEquals(expected, actual);
	}

	// #4 delim Join
	@Test 
	// public static String join(Collection<?> s, String delimiter)
	public void join1() {
		List<String> original = null;
		String expected = null;
		String actual = Util.join(original, ",");

		assertEquals(expected, actual);
	}

	public void join2() {
		List<String> original = Arrays.asList("abc", "def");
		String expected = "abc,def";
		String actual = Util.join(original, null);

		assertEquals(expected, actual);
	}

	public void join3() {
		List<String> original = Arrays.asList("");
		String expected = "";
		String actual = Util.join(original, "");

		assertEquals(expected, actual);
	}

	public void join4() {
		List<String> original = Arrays.asList("");
		String expected = "";
		String actual = Util.join(original, ",");

		assertEquals(expected, actual);
	}

	public void join5() {
		List<String> original = Arrays.asList("abc", "def");
		String expected = "";
		String actual = Util.join(original, "");

		assertEquals(expected, actual);
	}

	public void join6() {
		List<String> original = Arrays.asList("abc", "def");
		String expected = "abc,def";
		String actual = Util.join(original, ",");

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
