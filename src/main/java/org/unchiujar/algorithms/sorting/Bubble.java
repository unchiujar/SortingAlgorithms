package org.unchiujar.algorithms.sorting;

import static org.unchiujar.algorithms.sorting.Utils.arrangeMap;

import java.util.LinkedHashMap;

public class Bubble<K extends Comparable<K>, T> implements
		SortingAlgorithm<K, T> {

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<K, T> sort(LinkedHashMap<K, T> data) {
		Object[] keys = data.keySet().toArray();
		boolean sorted = false;
		int length = keys.length - 1;
		int lastSwapped = 0;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < length; i++) {
				if (((K) keys[i + 1]).compareTo((K) keys[i]) < 0) {
					// swap
					Object temp = keys[i];
					keys[i] = keys[i + 1];
					keys[i + 1] = temp;
					sorted = false;
					lastSwapped = i;
				}
			}
			// do not attempt to sort after the last swap
			// since elements are already ordered			
			length = lastSwapped;
		}
		return arrangeMap(data, keys);
	}
}
