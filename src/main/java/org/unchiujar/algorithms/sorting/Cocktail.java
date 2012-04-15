package org.unchiujar.algorithms.sorting;

import java.util.LinkedHashMap;

public class Cocktail<K extends Comparable<K>, T> implements
		SortingAlgorithm<K, T> {

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<K, T> sort(LinkedHashMap<K, T> data) {
		Object[] keys = data.keySet().toArray();
		boolean sorted = false;
		int end = keys.length - 1;
		int begin = 0;
		int lastSwapped = 0;

		while (!sorted) {
			sorted = true;
			for (int i = begin; i < end; i++) {
				if (((K) keys[i + 1]).compareTo((K) keys[i]) < 0) {
					// swap
					Object temp = keys[i];
					keys[i] = keys[i + 1];
					keys[i + 1] = temp;
					sorted = false;
					lastSwapped = i;
				}
			}
			if (!sorted) {
				// do not attempt to sort after the last swap
				// since elements are already ordered
				end = lastSwapped;
				sorted = true;
				for (int i = end; i > begin; i--) {
					if (((K) keys[i]).compareTo((K) keys[i - 1]) < 0) {
						// swap
						Object temp = keys[i];
						keys[i] = keys[i - 1];
						keys[i - 1] = temp;
						sorted = false;
						lastSwapped = i;
					}
				}
				// do not attempt to sort before the last swap
				// since elements are already ordered
				begin = lastSwapped;
			}
		}

		// create sorted result
		LinkedHashMap<K, T> result = new LinkedHashMap<K, T>();
		for (int i = 0; i < keys.length; i++) {
			result.put((K) keys[i], (T) data.get(keys[i]));
		}
		return result;
	}

}
