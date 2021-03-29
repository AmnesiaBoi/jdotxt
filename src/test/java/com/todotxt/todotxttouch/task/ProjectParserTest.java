package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ProjectParserTest {
	private String task;
	private Set<String> expected;
	private Set<String> actual;

	@Before
	public void setUp() {
		task = null;
		expected = new HashSet<String>();
		actual = new HashSet<String>();
	}

	@Test
	public void ProjectParserTest1() {
		task = "+prankTime 2021-04-01 do cool prank";
		expected.add("prankTime");
		actual.addAll(ProjectParser.getInstance().parse(task));

		assertEquals(expected, actual);
	}

	@Test
	public void ProjectParserTest2() {
		task = null;
		actual.addAll(ProjectParser.getInstance().parse(task));

		assertEquals(expected, actual);
	}
}
