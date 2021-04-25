package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
	 * 		1  , null      , delim    , [""]
	 * 		2  , no delim  , null     , [nodelim]
	 * 
	 *      3  , ""        , ""       , []
	 *      4  , ""        , delim    , []
	 *      5  , no delim  , ""       , Arrays.asList(s.split(""))
	 *      6  , no delim  , delim    , [s]
	 *      7  , with delim, ""       , Arrays.asList(s.split(""))
	 *      8  , with delim, delim    , Arrays.asList(s.split(delimeter))
	 *      
	 */
	
	@Test
	public void splitTest1() {
		List<String> expected = new ArrayList<>();
		List<String> actual = Util.split(null, ";");
		
		assertEquals(expected, actual);
	}

	@Test
	public void splitTest2() {
		List<String> expected = Arrays.asList("abcdef");
		List<String> actual = Util.split("abcdef", null);
		
		assertEquals(expected, actual);
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
	 *      
	 *      # dataflow coverage
	 *      7 , single, delim    , single[0] ..
	 */
	
	@Test
	public void joinTest1() {
		String expected = "";
		String actual = Util.join(null, ",");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void joinTest2() {
		List<String> original = Arrays.asList("abc", "def");
		String expected = "abcdef";
		String actual = Util.join(original, null);
		
		assertEquals(expected, actual);
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
	
	/*
	 * path coverage tests
	 */
	@Test
	public void joinTest7() {
		List<String> original = Arrays.asList("abc");
		String expected = "abc";
		String actual = Util.join(original, ",");

		assertEquals(expected, actual);
	}
	
	/*
	 * String readStream(InputStream is)
	 */
	
	@Test
	public void readNullStreamTest() 
	{
		String actual = Util.readStream(null);
		
		assertNull(actual);
	}
	
	@Test
	public void readEmptyStreamTest() 
	{
		String expected = "";
		
		InputStream in = new ByteArrayInputStream(expected.getBytes());
		
		String actual = Util.readStream(in);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void readStreamTest() 
	{
		String expected = "something";
		
		InputStream in = new ByteArrayInputStream(expected.getBytes());
		
		String actual = Util.readStream(in);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void readClosedStreamTest() throws IOException 
	{
		File temporary = File.createTempFile("abc", null);
		
		InputStream in = new FileInputStream(temporary);
		in.close();
		
		String actual = Util.readStream(in);
		
		assertNull(actual);
	}
	
	/*
	 * void writeFile(InputStream is, File file)
	 */
	
	@Test
	public void writeFileTest() throws IOException 
	{
		String expected = "something";
		
		File temporary = File.createTempFile("abc", null);
		InputStream in = new ByteArrayInputStream(expected.getBytes());
		
		Util.writeFile(in, temporary);
		
		String actual = Util.readStream(new FileInputStream(temporary));
		
		assertEquals(expected, actual);
	}
	
	/*
	 * boolean isDeviceWritable()
	 */
	
	// TODO: Method not implemented yet, therefore no tests
	
	/*
	 * boolean isDeviceReadable()
	 */
	
	// TODO: Method not implemented yet, therefore no tests
	
	/*
	 * void copyFile(File origFile, File newFile, boolean overwrite)
	 */
	
	@Test
	public void copyFileTest() throws IOException
	{
		String expected = "something";
		
		File temporaryFrom = File.createTempFile("fromfile", null);
		InputStream in = new ByteArrayInputStream(expected.getBytes());
		Util.writeFile(in, temporaryFrom);
		
		File temporaryTo = File.createTempFile("tofile", null);
		
		
		Util.copyFile(temporaryFrom, temporaryTo, true);
		
		
		String actual = Util.readStream(new FileInputStream(temporaryTo));
		
		assertEquals(expected, actual);
	}
	
	/*
	 * void prependString(ArrayList<String> list, String prepend)
	 */
	
	@Test
	public void prependStringTest()
	{
		List<String> list = Arrays.asList("1", "2", "3");
		String prepend = "A";
		
		List<String> expected = Arrays.asList("A1", "A2", "A3");
		
		Util.prependString(list, prepend);
		
		assertEquals(expected, list);
	}
	
	/*
	 * integerList2IntArray(List<Integer> integerlist)
	 */
	
	@Test
	public void integerList2IntArrayTest()
	{
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
		int[] expected = {1, 2, 3, 4};
		int[] actual = Util.integerList2IntArray(list);
		
		assertArrayEquals(expected, actual);
	}
}
