package org.unchiujar.algorithms.sorting;

import java.util.Comparator;

public class Quick<K> implements SortingAlgorithm<K> {
	@Override
	public K[] sort(K[] data, Comparator<? super K> comparator) {
		return quicksort(data, comparator, 0, data.length - 1);
	}

	// private Random rnd = new Random();

	private K[] quicksort(K[] data, Comparator<? super K> comparator, int left,
			int right) {
		if (left < right) {
			// choose random pivot
			int pivot = left + (right - left) / 2;// rnd.nextInt(right - left);
			K pivotValue = data[pivot];

			// move pivot to the right
			data[pivot] = data[right];
			data[right] = pivotValue;
			pivot = right;
			int storeIndex = left;
			// partition
			for (int i = left; i < right; i++) {
				// swap if bigger and before
				if (comparator.compare(data[i], pivotValue) < 0) {
					K temp = data[storeIndex];
					data[storeIndex] = data[i];
					data[i] = temp;
					storeIndex++;
				}

			}

			data[pivot] = data[storeIndex];
			data[storeIndex] = pivotValue;
			pivot = storeIndex;

			// sort smaller
			quicksort(data, comparator, left, pivot - 1);
			// sort larger
			quicksort(data, comparator, pivot + 1, right);
		}

		return data;
	}

}
