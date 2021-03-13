package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.chschmid.jdotxt.Jdotxt;

public class JdotxtTest {
	
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
		Jdotxt.insertReplaceString("abcdef", "xxx", 6+1); // length + 1

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
