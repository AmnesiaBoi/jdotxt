package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringsTest 
{

	/*
	 * Category Partition tests for:
	 * 	 Strings.insertPadded(String s, int insertAt, String stringToInsert)
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
	
	@Test
	public void insertPaddedTest1() {
		String expected = "abc";
		String actual = Strings.insertPadded(null, 0, "abc");

		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedTest2() {
		String expected = "";
		String actual = Strings.insertPadded("", 0, null);

		assertEquals(expected, actual);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void insertPaddedTest3() {
		Strings.insertPadded("abc", -2, "abc");
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void insertPaddedTest4() {
		Strings.insertPadded("abc", 5, "abc");
	}

	@Test
	public void insertPaddedTest5() {
		String expected = "";
		String actual = Strings.insertPadded("", 0, "");

		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedTest6() {
		String expected = "abc";
		String actual = Strings.insertPadded("", 0, "abc");

		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedTest7() {
		String expected = "abc";
		String actual = Strings.insertPadded("abc", 0, "");

		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedTest8() {
		String expected = "abc abc";
		String actual = Strings.insertPadded("abc", 0, "abc");

		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedTest9() {
		String expected = "abc";
		String actual = Strings.insertPadded("abc", 2, "");

		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedTest10() {
		String expected = "ab abc c";
		String actual = Strings.insertPadded("abc", 2, "abc");

		assertEquals(expected, actual);
	}
	

	/*
	 * Boundary Value Analysis tests for: 
	 * 	 Strings.insertPadded(String s, int insertAt, String stringToInsert)
	 * 
	 * # | Boundary/Partition            | Type      | Value
	 * ------------------------------------------------------------------------------------------
	 * 1 | insertAt >= 0                 | On-point  | insertAt = 0
	 * 2 |                               | Off-point | insertAt = -1
	 * 3 | insertAt <= s.length()        | On-point  | insertAt = s.length()
	 * 4 |                               | Off-point | insertAt = s.length() + 1
	 */

	@Test
	public void insertPaddedTestBVA01() {
		String expected = "abc abc";
		String actual = Strings.insertPadded("abc", 0, "abc");

		assertEquals(expected, actual);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void insertPaddedTestBVA02() {
		Strings.insertPadded("abc", -1, "abc");
	}

	@Test
	public void insertPaddedTestBVA03() {
		String expected = "abc abc";
		String actual = Strings.insertPadded("abc", 3, "abc");

		assertEquals(expected, actual);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void insertPaddedTestBVA04() {
		Strings.insertPadded("abc", 3+1, "abc");
	}

	@Test
	public void insertPaddedTestBVA05() {
		String expected = "a abc abc";
		String actual = Strings.insertPadded("a  abc", 2, "abc");

		assertEquals(expected, actual);
	}
	@Test
	public void insertPaddedTestBVA06() {
		String expected = "ab abc";
		String actual = Strings.insertPadded(" abc", 0, "ab");

		assertEquals(expected, actual);
	}

	
	/* Line coverage tests
	 * 
	 * isBlank
	 * 
	 */

	@Test
	public void isBlankTest1() {
		String expected = null;
		String s = null;
		boolean actual = Strings.isBlank(s);

		assertTrue(expected, actual);
	}

	@Test
	public void isBlankTest2() {
		String expected = "";
		String s = "";
		boolean actual = Strings.isBlank(s);

		assertTrue(expected, actual);
	}

	@Test
	public void isBlankTest3() {
		String expected = "abcdef";
		String s = "abcdef";
		boolean actual = Strings.isBlank(s);

		assertFalse(expected, actual);
	}

	@Test
	public void isBlankTest4() {
		String expected = " ";
		String s = " ";
		boolean actual = Strings.isBlank(s);

		assertTrue(expected, actual);
	}

	/*
	 * insertPaddedIfNeeded
	 */
	@Test
	public void insertPaddedIfNeededTest1() {
		int insertAt = 3;
		String s = "abcdef";
		String stringToInsert = "xxx";
		String expected = "abc xxx def";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedIfNeededTest2() {
		int insertAt = 3;
		String s = "abc def ghi";
		String stringToInsert = "def";
		String expected = "abc def ghi ";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedIfNeededTest3() {
		int insertAt = 0;
		String s = "abcdef";
		String stringToInsert = "xxx";
		String expected = "xxx abcdef";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedIfNeededTest4() {
		int insertAt = 0;
		String s = "abc defghi";
		String stringToInsert = "abc";
		String expected = "abc defghi ";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedIfNeededTest5() {
		int insertAt = 0;
		String s = "";
		String stringToInsert = "xxx";
		String expected = "xxx";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertPaddedIfNeededTest6() {
		int insertAt = 8;
		String s = "abcdef";
		String stringToInsert = "xxx";
		String expected = "abcdefxxx";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertPaddedIfNeededTest7() {
		int insertAt = -3;
		String s = "abcdef";
		String stringToInsert = "abc";
		String expected = "abcdef";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	@Test(expected = NullPointerException.class)
	public void insertPaddedIfNeededTest8() {
		int insertAt = 1;
		String s = null;
		String stringToInsert = "xxx";
		String expected = "xxx";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedIfNeededTest9() {
		int insertAt = 1;
		String s = "abc";
		String stringToInsert = null;
		String expected = "abc";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedIfNeededTest10() {
		int insertAt = 1;
		String s = "abc";
		String stringToInsert = "";
		String expected = "abc";
		String actual = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);
		
		assertEquals(expected, actual);
	}

	/*
	 * EmptyOrNull
	 */

	@Test
	public void EmptyOrNullTest1() {
		String expected = null;
		String s = null;
		boolean actual = Strings.isEmptyOrNull(s);

		assertTrue(expected, actual);
	}
	
	@Test
	public void EmptyOrNullTest2() {
		String expected = "";
		String s = "";
		boolean actual = Strings.isEmptyOrNull(s);

		assertTrue(expected, actual);
	}

	@Test
	public void EmptyOrNullTest3() {
		String expected = "abcdef";
		String s = "abcdef";
		boolean actual = Strings.isEmptyOrNull(s);

		assertFalse(expected, actual);
	}

	@Test
	public void EmptyOrNullTest4() {
		String expected = " ";
		String s = " ";
		boolean actual = Strings.isEmptyOrNull(s);

		assertFalse(expected, actual);
	}

}
