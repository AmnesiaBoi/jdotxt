package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilTest 
{
	
	/*
	 * Util.split(String s, String delimeter)
	 * 
	 * Variations:
	 * 		s        : null, "", no delim, with delim
	 * 		delimeter: null, "", delim
	 * 
	 * Combinations:   (R for Redundant)
	 * 		#  , s         , delimeter, expected
	 * 
	 * 		1  , null      , delim    , NullPointerException
	 * 		2  , no delim  , null     , NullPointerException
	 * 
	 *      3  , ""        , ""       , []
	 *      4  , ""        , delim    , []
	 *      5  , no delim  , ""       , Arrays.asList(s.split(""))
	 *      6  , no delim  , delim    , [s]
	 *      7  , with delim, ""       , Arrays.asList(s.split(""))
	 *      8  , with delim, delim    , Arrays.asList(s.split(delimeter))
	 *      
	 */
	
	@Test(expected=NullPointerException.class)
	public void splitTest1() {
		Util.split(null, ";");
	}

	@Test(expected=NullPointerException.class)
	public void splitTest2() {
		Util.split("abcdef", null);
	}

	@Test 
	public void splitTest3() {
		List<String> expected = new ArrayList<>();
		List<String> actual = Util.split("", "");

		assertEquals(expected, actual);
	}

	@Test
	public void splitTest4() {
		List<String> expected = new ArrayList<>();
		List<String> actual = Util.split("", ";");

		assertEquals(expected, actual);
	}

	@Test
	public void splitTest5() {
		List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f");
		List<String> actual = Util.split("abcdef", "");

		assertEquals(expected, actual);
	}

	@Test
	public void splitTest6() {
		List<String> expected = Arrays.asList("abcdef");
		List<String> actual = Util.split("abcdef", ";");
		
		assertEquals(expected, actual);
	}

	@Test 
	public void splitTest7() {
		List<String> expected = Arrays.asList("a", "b", "c", ";", "d", "e", "f");
		List<String> actual = Util.split("abc;def", "");
		
		assertEquals(expected, actual);
	}

	@Test 
	public void splitTest8() {
		List<String> expected = Arrays.asList("abc", "def");
		List<String> actual = Util.split("abc;def", ";");
		
		assertEquals(expected, actual);
	}

	
	/*
	 * Util.join(Collection<?> s, String delimiter)
	 * 
	 * Variations:
	 * 		s        : null, empty, some
	 * 		delimiter: null, "", delim
	 * 
	 * Combinations:   (R for Redundant)
	 * 		#  , s    , delimiter, expected
	 * 
	 *      1  , null , delim    , NullPointerException
	 *      2  , some , null     , NullPointerException
	 *      
	 *      3  , empty, ""       , ""
	 *      4  , empty, delim    , ""
	 *      5  , some , ""       , some[0] + some[1] ..
	 *      6  , some , delim    , some[0] + delim + some[1] ..
	 */
	
	@Test(expected=NullPointerException.class)
	public void joinTest1() {
		List<String> original = null;
		Util.join(original, ",");
	}

	@Test(expected=NullPointerException.class)
	public void joinTest2() {
		List<String> original = Arrays.asList("abc", "def");
		Util.join(original, null);
	}

	@Test
	public void joinTest3() {
		List<String> original = Arrays.asList();
		String expected = "";
		String actual = Util.join(original, "");

		assertEquals(expected, actual);
	}

	@Test
	public void joinTest4() {
		List<String> original = Arrays.asList();
		String expected = "";
		String actual = Util.join(original, ",");

		assertEquals(expected, actual);
	}

	@Test
	public void joinTest5() {
		List<String> original = Arrays.asList("abc", "def");
		String expected = "abcdef";
		String actual = Util.join(original, "");

		assertEquals(expected, actual);
	}

	@Test
	public void joinTest6() {
		List<String> original = Arrays.asList("abc", "def");
		String expected = "abc,def";
		String actual = Util.join(original, ",");

		assertEquals(expected, actual);
	}
}