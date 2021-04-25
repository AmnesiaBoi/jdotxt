package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CursorPositionCalculatorTest 
{
	
	/*
	 *  Category Partition tests for:
	 *    CursorPosition.calculate(int priorCursorPosition, String priorValue, String newValue)
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
	public void calculateTest1()
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(-2, "", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateTest2()
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(2, "", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateTest3()
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(0, null, "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateTest4() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "", null);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateTest5() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateTest6() 
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(0, "", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateTest7() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "abc", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateTest8() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "abc", "abc");

		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateTest9() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(2, "abc", "");

		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateTest10() 
	{
		int expected = 2;
		int actual = CursorPositionCalculator.calculate(2, "abc", "abc");

		assertEquals(expected, actual);
	}
	
	
	
	/*
	 * Boundary Value Analysis tests for: 
	 * 	 CursorPosition.calculate(int priorCursorPosition, String priorValue, String newValue)
	 * 
	 * # | Boundary/Partition                         | Type      | Value
	 * ------------------------------------------------------------------------------------------
	 * 1 | priorCursorPosition >= 0                   | On-point  | priorCursorPosition = 0
	 * 2 |                                            | Off-point | priorCursorPosition = -1
	 * 3 | priorCursorPosition <= priorValue.length() | On-point  | priorCursorPosition = priorValue.length()
	 * 4 |                                            | Off-point | priorCursorPosition = priorValue.length() + 1
	 */

	@Test
	public void calculateTestBVA01() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "abcdef", "abcdef");

		assertEquals(expected, actual);
	}

	@Test
	public void calculateTestBVA02() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(-1, "abcdef", "abcdef");

		assertEquals(expected, actual);
	}

	@Test
	public void calculateTestBVA03() 
	{
		int expected = 6;
		int actual = CursorPositionCalculator.calculate(6, "abcdef", "abcdef");

		assertEquals(expected, actual);
	}

	@Test
	public void calculateTestBVA04() 
	{
		int expected = 6;
		int actual = CursorPositionCalculator.calculate(6+1, "abcdef", "abcdef");

		assertEquals(expected, actual);
	}
	/*
	 * new
	 */
	@Test
	public void calculateTestBVA05() 
	{
		int expected = 1;
		int actual = CursorPositionCalculator.calculate(0, "", "a");

		assertEquals(expected, actual);
	}
}
