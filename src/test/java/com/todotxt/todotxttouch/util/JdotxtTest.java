package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chschmid.jdotxt.Jdotxt;

public class JdotxtTest {
	
	
	/*
	 * Boundary Value Analysis tests for: 
	 * 	 Jdotxt.insertReplaceString(String original, String replace, int offset)
	 * 
	 * # | Boundary/Partition                       | Type      | Value
	 * ------------------------------------------------------------------------------------------
	 * 1 | offset >= 0                              | On-point  | offset = 0
	 * 2 |                                          | Off-point | offset = -1
	 * 3 | offset <= original.length()              | On-point  | offset = original.length()
	 * 4 |                                          | Off-point | offset = original.length() + 1
	 * 
	 * 5 | offset < 0                               | Partition | offset = -3
	 * 6 | offset >= 0 && offset <= original.length | Partition | offset = 3
	 * 7 | offset > original.length                 | Partition | offset = original.length() + 3
	 */
	
	
	@Test
	public void insertReplaceStringTestBVA01() {
		String expected = "xxxdef";
		String actual = Jdotxt.insertReplaceString("abcdef", "xxx", 0);

		assertEquals(expected, actual);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void insertReplaceStringTestBVA02() {
		Jdotxt.insertReplaceString("abcdef", "xxx", -1);
	}

	@Test
	public void insertReplaceStringTestBVA03() {
		String expected = "abcdefxxx";
		String actual = Jdotxt.insertReplaceString("abcdef", "xxx", 6);

		assertEquals(expected, actual);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void insertReplaceStringTestBVA04() {
		Jdotxt.insertReplaceString("abcdef", "xxx", 6+1);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void insertReplaceStringTestBVA05() {
		Jdotxt.insertReplaceString("abcdef", "xxx", -3);
	}

	@Test
	public void insertReplaceStringTestBVA06() {
		String expected = "abcxxx";
		String actual = Jdotxt.insertReplaceString("abcdef", "xxx", 3);

		assertEquals(expected, actual);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void insertReplaceStringTestBVA07() {
		Jdotxt.insertReplaceString("abcdef", "xxx", 6+3);
	}
}
