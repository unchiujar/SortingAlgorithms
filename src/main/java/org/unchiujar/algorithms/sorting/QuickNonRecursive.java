package org.unchiujar.algorithms.sorting;

import static org.unchiujar.algorithms.sorting.Utils.arrangeMap;

import java.util.LinkedHashMap;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickNonRecursive<K extends Comparable<K>, T> implements
		SortingAlgorithm<K, T> {
	private static final Logger LOG = LoggerFactory
			.getLogger(QuickNonRecursive.class);

	@Override
	public LinkedHashMap<K, T> sort(LinkedHashMap<K, T> data) {
		Object[] keys = data.keySet().toArray();
		// create sorted result
		keys = quicksort(keys, 0, keys.length - 1);
		return arrangeMap(data, keys);
	}

	private Random rnd = new Random();

	private Object[] quicksort(Object[] keys, int left, int right) {

		int[] pivotStack = new int[keys.length];
		int pivotStackCursor = 0;
		int pivot = left + rnd.nextInt(right - left);
		// put pivot
		pivotStack[pivotStackCursor++] = pivot;

		while (pivotStack[0] != -1) {

			pivot = sort(keys, left, right, pivot);
			
			pivotStack[pivotStackCursor++] = pivot;
			
			pivot = sort(keys, left, pivot-1, pivot);
			
			
		}
		return keys;
	}

	private int sort(Object[] keys, int left, int right, int pivot) {

		while (left < right) {

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

		}

		return pivot;
	}

}
