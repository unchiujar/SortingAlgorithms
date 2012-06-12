package org.unchiujar.algorithms.sorting;

import java.util.Comparator;

public class Bubble<K> implements SortingAlgorithm<K> {

	@Override
	public K[] sort(K[] data, Comparator<? super K> comparator) {
		boolean sorted = false;
		int length = data.length - 1;
		int lastSwapped = 0;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < length; i++) {
				if (comparator.compare(data[i + 1], data[i]) < 0) {
					// swap
					K temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					sorted = false;
					lastSwapped = i;
				}
			}
			// do not attempt to sort after the last swap
			// since elements are already ordered
			length = lastSwapped;
		}
		return data;
	}
}
