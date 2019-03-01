package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {

	@Test
	public void testEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testPutGet() {
		MapADT<String, Integer> notEmpty = new JavaMap<>();
		notEmpty.put("a", 1);
		notEmpty.put("b", 2);
		assertTrue(notEmpty.get("a") == 1);
		assertTrue(notEmpty.get("b") == 2);
		assertNull(notEmpty.get("c"));
	}
	
	
	@Test
	public void testSize() {
		MapADT<String, Integer> full = new JavaMap<>();
		full.put("Hello", 1);
		full.put("Hi", 3);
		full.put("Howdy", 4);
		assertEquals(full.size(), 3);
	}
	
	@Test
	public void testRemove() {
		MapADT<String, Integer> full = new JavaMap<>();
		full.put("Hello", 1);
		full.put("Hi", 3);
		int x = full.remove("Hello");
		assertNull(full.get("Hello"));
		assertTrue(full.get("Hi") == 3);
		assertEquals(x, 1);
		assertEquals(full.size(), 1);
	}
	
	@Test
	public void testGetKeys() {
		MapADT<String, Integer> keys = new JavaMap<>();
		keys.put("a", 1);
		keys.put("b",  2);
		ListADT<String> list = keys.getKeys();
		// ListADT has no good contains method, so I used Java's native list instead
		List<String> list2 = list.toJava();
		assertTrue(list2.contains("a"));
		assertTrue(list2.contains("b"));
		assertEquals(list2.size(), 2);
	}
	
	@Test
	public void testGetEntries() {
		MapADT<String, Integer> entriesMap = new JavaMap<>();
		entriesMap.put("a", 1);
		ListADT<Pair<String, Integer>> entries = entriesMap.getEntries();
		assertEquals(entries.size(), 1);
		entriesMap.put("b", 2);
		entries = entriesMap.getEntries();
		assertEquals(entries.size(), 2);
		MapADT<String, Integer> emptyMap = new JavaMap<>();
		ListADT<Pair<String, Integer>> empty = emptyMap.getEntries();
		assertEquals(empty.size(), 0);
		
	}
	
	@Test
	public void testToJava() {
		MapADT<String, Integer> dict = new JavaMap<>();
		dict.put("a", 1);
		dict.put("b", 2);
		Map<String, Integer> dict2 = dict.toJava();
		assertTrue(dict2.containsKey("a"));
	}
	
}
