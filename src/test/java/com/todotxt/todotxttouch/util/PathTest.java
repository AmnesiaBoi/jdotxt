package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PathTest {

	@Test
	public void PathFileNameBlankTest() {
		assertEquals(Path.fileName(""), "");
	}
	
	@Test
	public void tPathFileNameEndsSlashTest() {
		assertEquals(Path.fileName("file/"), "file");
		assertEquals(Path.fileName("file"), "file");
		
	}

	@Test
	public void ParentPathEndingSlahTest(){
		assertEquals(Path.parentPath("/"),"");
	}

	@Test
	public void ParentPathIsBlankTest(){
		assertEquals(Path.parentPath(""),"");
	}

	@Test
	public void ParentPathIsNullTest(){
		assertEquals(Path.parentPath(null),"");
	}

	@Test
	public void ParentPathIsSubstringEndsSlashTest(){
		assertEquals(Path.parentPath("file1/file/"),"file1/");
	}

	@Test
	public void ParentPathIsSubstringNotEndsSlashTest(){
		assertEquals(Path.parentPath("file"),"");
	}
}
