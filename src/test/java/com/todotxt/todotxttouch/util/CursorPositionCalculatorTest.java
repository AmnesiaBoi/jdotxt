package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CursorPositionCalculatorTest 
{
	/*
		Combinations:
		|  # | priorCursorPosition | priorValue | newValue |
		----------------------------------------------------
		|  1 |      negative       |    ""      |   "abc"  |
		----------------------------------------------------
		|  2 |         0           |   null     |   "abc"  |
		|  3 |         0           |   "abc"    |   null   |
		----------------------------------------------------
		|  4 |         0           |    ""      |    ""    |
		|  5 |         0           |    ""      |   "abc"  |
		|  6 |         0           |   "abc"    |    ""    |
		|  7 |         0           |   "abc"    |   "abc"  |
		----------------------------------------------------
		|  8 |      positive       |    ""      |    ""    |
		|  9 |      positive       |    ""      |   "abc"  |
		| 10 |      positive       |   "abc"    |    ""    |
		| 11 |      positive       |   "abc"    |   "abc"  |
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
		int actual = CursorPositionCalculator.calculate(0, null, "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3()
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "abc", null);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() 
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(0, "", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "abc", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test7() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(0, "abc", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test8() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(2, "", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test9() 
	{
		int expected = 3;
		int actual = CursorPositionCalculator.calculate(2, "", "abc");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test10() 
	{
		int expected = 0;
		int actual = CursorPositionCalculator.calculate(2, "abc", "");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test11() 
	{
		int expected = 2;
		int actual = CursorPositionCalculator.calculate(2, "abc", "abc");
		
		assertEquals(expected, actual);
	}
}
