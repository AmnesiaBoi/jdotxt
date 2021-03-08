package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringsTest 
{

	/*
	 * Strings.insertPadded(String s, int insertAt, String stringToInsert)
	 * 
	 * Variations:
	 * 		s              : null, "", "abc"
	 * 		insertAt       : <0, 0, <=s.length(), >s.length()
	 * 		stringToInsert : null, "", "abc"
	 * 
	 * Combinations:   (R for Redundant)
	 * 		#  , s    , insertAt    , stringToInsert, expected
	 * 
	 * 		1  , null , 0           , "abc"         , "abc"
	 *      2  , ""   , 0           , null          , ""
	 *      
	 *      3  , ""   , <0          , "abc"         , IndexOutOfBoundsException
	 *      4  , ""   , >s.length() , "abc"         , IndexOutOfBoundsException
	 *      
	 *      5  , ""   , 0           , ""            , ""
	 *      6  , ""   , 0           , "abc"         , "abc"
	 *      R  , ""   , <=s.length(), ""            , ""
	 *      R  , ""   , <=s.length(), "abc"         , "abc"
	 *      7  , "abc", 0           , ""            , "abc"
	 *      8  , "abc", 0           , "abc"         , "abc abc"
	 *      9  , "abc", <=s.length(), ""            , "abc"
	 *      10 , "abc", <=s.length(), "abc"         , "ab abc c"
	 * 
	 */
	
	// #1 String to Insert

	@Test
	public void test1() {
		String expected = "abc";
		String actual = Strings.insertPadded(null, 0, "abc");

		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		String expected = "";
		String actual = Strings.insertPadded("", 0, null);

		assertEquals(expected, actual);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void test3() {
		Strings.insertPadded("", -2, "abc");
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void test4() {
		Strings.insertPadded("", 1, "abc");
	}
	
	@Test
	public void test5() {
		String expected = "";
		String actual = Strings.insertPadded("", 0, "");

		assertEquals(expected, actual);
	}

	@Test
	public void test6() {
		String expected = "abc";
		String actual = Strings.insertPadded("", 0, "abc");

		assertEquals(expected, actual);
	}

	@Test
	public void test7() {
		String expected = "abc";
		String actual = Strings.insertPadded("abc", 0, "");

		assertEquals(expected, actual);
	}

	@Test
	public void test8() {
		String expected = "abc abc";
		String actual = Strings.insertPadded("abc", 0, "abc");

		assertEquals(expected, actual);
	}
	
	@Test
	public void test9() {
		String expected = "abc";
		String actual = Strings.insertPadded("abc", 2, "");

		assertEquals(expected, actual);
	}

	@Test
	public void test10() {
		String expected = "ab abc c";
		String actual = Strings.insertPadded("abc", 2, "abc");

		assertEquals(expected, actual);
	}
	
}
