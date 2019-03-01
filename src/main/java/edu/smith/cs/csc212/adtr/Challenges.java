package edu.smith.cs.csc212.adtr;

import java.util.List;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class Challenges {

	// The union of two sets is the set of elements that either contains.
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		ListADT<Integer> leftList = left.toList();
		ListADT<Integer> rightList = right.toList();
		for(Integer entry: leftList) {
			output.insert(entry);
		} 
		for(Integer entry: rightList) {
			output.insert(entry);
		}
		return output;
	}
	
	// The intersection of two sets is the set of elements that both contain.
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		List<Integer> leftList = left.toList().toJava();
		List<Integer> rightList = right.toList().toJava();
		for(Integer entry: leftList) {
			if(rightList.contains(entry)) {
				output.insert(entry);
			}
		}
		return output;
	}
	
	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		for(String word: words) {
			// If the word is in the keys list (clunky but it works)
			if(!output.getKeys().toJava().contains(word)) {
				output.put(word, 1);
			} else {
				Integer x = output.get(word);
				x++;
				output.put(word, x);
			}
		}
		return output;
	}
}
