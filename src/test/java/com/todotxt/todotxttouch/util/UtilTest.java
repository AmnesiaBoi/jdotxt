package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilTest 
{
	@Test 
	public void split1() {
		List<String> expected = Arrays.asList("abc", "def");
		List<String> actual = Util.split(null, ";");

		assertEquals(expected, actual);
	}

	@Test
	public void split2() {
		List<String> expected = Arrays.asList("abc", "def");
		List<String> actual = Util.split("", null);

		assertEquals(expected, actual);
	}

	@Test 
	public void split3() {
		List<String> expected = new ArrayList<String>();
		List<String> actual = Util.split("", "");

		assertEquals(expected, actual);
	}

	@Test
	public void split4() {
		List<String> expected = new ArrayList<String>();
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

		assertEquals(expected, actual);
	}

	@Test 
	public void join1() {
		List<String> original = null;
		String expected = null;
		String actual = Util.join(original, ",");

		assertEquals(expected, actual);
	}

	@Test
	public void join2() {
		List<String> original = Arrays.asList("abc", "def");
		String expected = "abc,def";
		String actual = Util.join(original, null);

		assertEquals(expected, actual);
	}

	@Test
	public void join3() {
		List<String> original = Arrays.asList("");
		String expected = "";
		String actual = Util.join(original, "");

		assertEquals(expected, actual);
	}

	@Test
	public void join4() {
		List<String> original = Arrays.asList("");
		String expected = "";
		String actual = Util.join(original, ",");

		assertEquals(expected, actual);
	}

	@Test
	public void join5() {
		List<String> original = Arrays.asList("abc", "def");
		String expected = "";
		String actual = Util.join(original, "");

		assertEquals(expected, actual);
	}

	@Test
	public void join6() {
		List<String> original = Arrays.asList("abc", "def");
		String expected = "abc,def";
		String actual = Util.join(original, ",");

		assertEquals(expected, actual);
	}
}
