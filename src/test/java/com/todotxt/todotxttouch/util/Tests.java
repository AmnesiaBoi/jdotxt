package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class Tests {

	// Eduardo
	// https://www.vogella.com/tutorials/JUnit/article.html
	
/* category partition of CursorPositionCalcTest1
 * 
 *  cursor position <0 -> RETURNS cursor position > 0
 *  cursor position = 0 -> RETURNS cursor position > 0
 *  cursor position > 0 -> RETURNS SysOut ("all good")
 */
	
	@Test
	//Cursor Position #1
	public void CursorPositionCalcTest1(){
		String newValue = "helloes";
		String priorValue = "worlds";
		int task = (newValue.length() - priorValue.length());
		assertTrue(task >= 0);
	}

	public void CursorPositionCalcTest2(){
		String newValue = "bang";
		String priorValue = "bong";
		int task = (newValue.length() - priorValue.length());
		assertTrue(task >= 0);
	}

	@Test
	//Cursor Position #2
	public void CursorPositionCalcTest3(){
		//int random = randomFunction();
		
		

		int priorValue = -90;
		int newValue = 80;
		assertTrue("Error, random is too high", newValue - priorValue >= 0);
		System.out.println("Test passed: " + newValue + " higher than " + priorValue);
		//Eduardo
	}

	

}
