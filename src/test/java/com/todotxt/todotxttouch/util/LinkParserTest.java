package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.todotxt.todotxttouch.task.LinkParser;

public class LinkParserTest {

	
	@Test
	public void testLinkParser1() throws MalformedURLException{
		String oracle = "http://www.oracle.com";
		List<URL> actual = LinkParser.getInstance().parse(oracle);

		URL url = new URL("http://www.oracle.com");
		List<URL> expected = new ArrayList<URL>();
		expected.add(url);

		assertEquals(expected, actual);
	}
	
	@Test
	public void testLinkParser3() throws MalformedURLException{
		String oracle = null;
		List<URL> actual = LinkParser.getInstance().parse(oracle);
		List<URL> expected = new ArrayList<URL>();

		assertEquals(expected, actual);
	}
}