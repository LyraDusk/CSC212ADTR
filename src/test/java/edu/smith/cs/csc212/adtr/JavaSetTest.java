package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testInsert() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("b");
		abc.insert("c");
		assertEquals(abc.size(), 3);
	}
	
	@Test
	public void testSet() {
		SetADT<String> tripleA = new JavaSet<>();
		tripleA.insert("a");
		tripleA.insert("a");
		tripleA.insert("a");
		assertEquals(tripleA.size(), 1);
	}
	
	@Test
	public void testContains() {
		SetADT<String> container = new JavaSet<>();
		container.insert("a");
		assertTrue(container.contains("a"));
	}
	
	
	@Test
	public void testRemove() {
		SetADT<String> fill = new JavaSet<>();
		fill.insert("a");
		fill.insert("b");
		fill.remove("a");
		assertEquals(fill.size(), 1);
		assertTrue(fill.contains("b"));
	}
	
	@Test
	public void testToList() {
		SetADT<String> set = new JavaSet<>();
		set.insert("A");
		ListADT<String> list = set.toList();
		assertTrue(list instanceof ListADT);
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void testToJava() {
		SetADT<String> adtset = new JavaSet<>();
		adtset.insert("a");
		Set<String> normalSet = adtset.toJava();
		assertTrue(normalSet instanceof Set);
		assertEquals(normalSet.size(), 1);
	}
}
