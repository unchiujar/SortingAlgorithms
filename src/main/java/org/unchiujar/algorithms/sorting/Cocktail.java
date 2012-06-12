package org.unchiujar.algorithms.sorting;

import java.util.Comparator;
public class Cocktail<K> implements
		SortingAlgorithm<K> {

	@Override
	public K[] sort(K[] data, Comparator<? super K> comparator) {
		boolean sorted = false;
		int end = data.length - 1;
		int begin = 0;
		int lastSwapped = 0;

		while (!sorted) {
			sorted = true;
			for (int i = begin; i < end; i++) {
				if (comparator.compare(data[i + 1],data[i]) < 0) {
					// swap
					K temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
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
					if (comparator.compare(data[i], data[i - 1]) < 0) {
						// swap
						K temp = data[i];
						data[i] = data[i - 1];
						data[i - 1] = temp;
						sorted = false;
						lastSwapped = i;
					}
				}
				// do not attempt to sort before the last swap
				// since elements are already ordered
				begin = lastSwapped;
			}
		}

		return data;
	}
}
