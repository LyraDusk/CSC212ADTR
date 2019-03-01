package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaChallengeTest {
	
	@Test
	public void unionTest() {
		SetADT<Integer> a = new JavaSet<>();
		a.insert(1);
		a.insert(2);
		SetADT<Integer> b = new JavaSet<>();
		b.insert(2);
		b.insert(3);
		SetADT<Integer> ab = Challenges.union(a,b);
		assertEquals(ab.size(),3);
		assertTrue(ab.contains(1));
		assertTrue(ab.contains(2));
		assertTrue(ab.contains(3));
	}
	
	@Test
	public void intersectionTest() {
		SetADT<Integer> a = new JavaSet<>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		SetADT<Integer> b = new JavaSet<>();
		b.insert(2);
		b.insert(3);
		b.insert(4);
		SetADT<Integer> ab = Challenges.intersection(a, b);
		assertEquals(ab.size(), 2);
		assertTrue(ab.contains(2));
		assertTrue(ab.contains(3));
		assertFalse(ab.contains(1));
		assertFalse(ab.contains(4));
		}
	
	
	
}
