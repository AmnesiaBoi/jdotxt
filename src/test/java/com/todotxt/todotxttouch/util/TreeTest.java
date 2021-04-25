package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TreeTest {

	@Test
	public void TreeWithDataTest() {
		String expected = "Hello";
		Tree<String> tree = new Tree<String>(expected);
		String actual = tree.getData();
		assertEquals(actual, "Hello");
	}
	
	@Test
	public void TreeWithoutParentTest() {
		Tree<String> tree = new Tree<String>(null);
		assertNull(tree.getParent());
	}

	@Test
	public void TreeWithParentTest() {
		Tree<String> parent = new Tree<String>("pai");
		Tree<String> child = new Tree<String>(parent, "filho");
		assertEquals(child.getParent(), parent);
	}

	@Test
	public void TreeAddChildTest() {
		Tree<String> parent = new Tree<String>("pai");
		parent.addChild("filho");
		assertEquals(parent.getChild(0).getData(), "filho");
	}
	@Test
	public void TreeAddChildTest2() {
		Tree<String> parent = new Tree<String>("pai");
		Tree<String> parent2 = new Tree<String>("mae");
		
		Tree<String> actual = parent.addChild(parent2);

		assertEquals(parent2, actual);
	}
	@Test
	public void TreeAddChildTest3() {
		Tree<String> parent = new Tree<>("pai");

		String child = "filho";
		Tree<String> ret = parent.addChild(child);

		assertEquals(child, ret.getData());
	}
/**
	@Test
	public void TreeAddChildNullTest() {
		Tree<String> parent = new Tree<String>("pai");
		Tree<String> child = null;
		parent.addChild(child);
		assertNull(parent.getChild(0));
	}
**/
	@Test
	public void TreeIsUnloadedTest() {
		Tree<String> tree = new Tree<String>(null);
		assertFalse(tree.isLoaded());
	}

	@Test
	public void TreeIsLoadedTest() {
		Tree<String> tree = new Tree<String>("1");
		tree.addChild("1");
		assertTrue(tree.isLoaded());
	}

	@Test
	public void setLoadedTest() {
		Tree<String> tree = new Tree<String>("1");
		tree.setLoaded();
		assertTrue(tree.isLoaded());
	}
	
	@Test
	public void setLoadedLoadedNullTest() {
		Tree<String> tree = new Tree<String>("1");
		tree.addChild("2");
		tree.setLoaded();
		assertTrue(tree.isLoaded());
	}

	@Test
	public void getChildrenNullTest() {
		Tree<String> tree = new Tree<String>("1");
		List<Tree<String>> children = tree.getChildren();
		assertNull(children);
	}
	
	@Test
	public void getChildrenTest() {
		Tree<String> tree = new Tree<String>("1");
		tree.addChild("filho");
		List<Tree<String>> children = tree.getChildren();
		assertNotNull(children);
	}

	@Test
	public void getTreeContainChildTest() {
		Tree<String> tree = new Tree<String>("1");
		Tree<String> child = new Tree<String>(tree,"2");
		tree.addChild(child);
		assertTrue(tree.contains(child));
	}

	@Test
	public void getTreeContainChildWithOrfaoTest() {
		Tree<String> tree = new Tree<String>("1");
		Tree<String> child = new Tree<String>(tree,"2");
		tree.addChild(child);
		Tree<String> orfao = new Tree<String>(null, "3");
		assertFalse(tree.contains(orfao));
	}
	
	@Test
	public void getTreeContainChildNullTest() {
		Tree<String> tree = new Tree<String>("1");
		Tree<String> orfao = new Tree<String>(null, "3");
		assertFalse(tree.contains(orfao));
	}
	
	@Test
	public void getTreeContainNoDataTest() {
		Tree<String> tree = new Tree<String>("1");
		assertFalse(tree.contains("2"));
	}
	
	@Test
	public void getTreeContainWrongDataTest() {
		Tree<String> tree = new Tree<String>("1");
		Tree<String> child = new Tree<String>(tree,"2");
		tree.addChild(child);
		Tree<String> orfao = new Tree<String>(null, "3");
		tree.addChild(orfao);
		assertFalse(tree.contains("4"));
	}

	@Test
	public void getTreeContainTrueTest() {
		Tree<String> tree = new Tree<String>("1");
		Tree<String> child = new Tree<String>(tree,"2");
		tree.addChild(child);
		Tree<String> orfao = new Tree<String>(null, "3");
		tree.addChild(orfao);
		assertTrue(tree.contains("2"));
	}
}
