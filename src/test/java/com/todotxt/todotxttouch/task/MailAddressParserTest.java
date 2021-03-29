package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MailAddressParserTest {

	/*
	 * MailAddressParser::parse(String inputText)
	 */
	
	@Test
	public void testParseNullText()
	{
		List<String> actual = MailAddressParser.getInstance().parse(null);
		List<String> expected = new ArrayList<>();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testParseEmptyMails()
	{
		List<String> actual = MailAddressParser.getInstance().parse("");
		List<String> expected = new ArrayList<>();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testParseSomeMails()
	{
		List<String> actual = MailAddressParser.getInstance().parse("alice@work.com bob@home.co.uk");
		List<String> expected = Arrays.asList("alice@work.com", "bob@home.co.uk");
		
		assertEquals(expected, actual);
	}
	
}
