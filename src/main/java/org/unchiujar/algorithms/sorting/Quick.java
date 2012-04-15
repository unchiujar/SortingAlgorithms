package org.unchiujar.algorithms.sorting;

import java.util.LinkedHashMap;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quick<K extends Comparable<K>, T> implements
		SortingAlgorithm<K, T> {
	private static final Logger LOG = LoggerFactory.getLogger(Quick.class);

	@SuppressWarnings("unchecked")
	@Override
	public LinkedHashMap<K, T> sort(LinkedHashMap<K, T> data) {
		Object[] keys = data.keySet().toArray();
		// create sorted result
		keys = quicksort(keys, 0, keys.length - 1);
		LinkedHashMap<K, T> result = new LinkedHashMap<K, T>();
		for (int i = 0; i < keys.length; i++) {
			result.put((K) keys[i], (T) data.get(keys[i]));
		}
		return result;
	}

	private Random rnd = new Random();

	private Object[] quicksort(Object[] keys, int left, int right) {
		if (left < right) {
			// choose random pivot
			int pivot = left + rnd.nextInt(right - left);
			int pivotValue = (Integer) keys[pivot];

			// move pivot to the right
			keys[pivot] = keys[right];
			keys[right] = pivotValue;
			pivot = right;
			int storeIndex = left;
			// partition
			for (int i = left; i < right; i++) {
				// swap if bigger and before
				if ((Integer) keys[i] < pivotValue) {
					int temp = (Integer) keys[storeIndex];
					keys[storeIndex] = keys[i];
					keys[i] = temp;
					storeIndex++;
				}

			}

			keys[pivot] = keys[storeIndex];
			keys[storeIndex] = pivotValue;
			pivot = storeIndex;

			// sort smaller
			quicksort(keys, left, pivot - 1);
			// sort larger
			quicksort(keys, pivot + 1, right);
		}

		return keys;
	}

}
