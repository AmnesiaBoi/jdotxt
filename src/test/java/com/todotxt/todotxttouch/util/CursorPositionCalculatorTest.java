package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CursorPositionCalculatorTest 
{
	
	/*
	 *  CursorPosition.calculate(int priorCursorPosition, String priorValue, String newValue)
	 *  
	 *  Variations:
	 *  	priorCursorPosition: <0, 0, <=priorValue.length(), >priorValue.length()
	 *  	priorValue         : null, "", "abc"
	 *  	newValue           : null, "", "abc"
	 *  
	 *  Combinations:    (R for Redundant)
	 *  	#  - <priorCursorPosition>  , <priorValue>, <newValue>, <expected>
	 *  
	 *  	1  - <0                     , ""          , "abc"     , 3
	 *      2  - >priorValue.length()   , ""          , "abc"     , 3
	 *      
	 *      3  - 0                      , null        , "abc"     , 3
	 *      4  - 0                      , ""          , null      , 0
	 *      
	 *      5  - 0                      , ""          , ""        , 0
	 *      6  - 0                      , ""          , "abc"     , 3
	 *      7  - 0                      , "abc"       , ""        , 0
	 *      8  - 0                      , "abc"       , "abc"     , 0
	 *      
	 *      R  - <=priorValue.length()  , ""          , ""        , 0
	 *      R  - <=priorValue.length()  , ""          , "abc"     , 3 
	 *      9  - <=priorValue.length()  , "abc"       , ""        , 0
	 *      10 - <=priorValue.length()  , "abc"       , "abc"     , priorCursorPosition
	 */
	
	@Test
	public void test1()
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(-2, "", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2()
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(2, "", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3()
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(0, null, "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "", null);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() 
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(0, "", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test7() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "abc", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test8() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "abc", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test9() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(2, "abc", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test10() 
	{
		int expected = 2;
		int actual = CursorPositionCalculator.calculate(2, "abc", "abc");
		
		assertEquals(expected, actual);
	}
}
