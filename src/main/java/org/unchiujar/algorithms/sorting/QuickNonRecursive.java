package org.unchiujar.algorithms.sorting;

import java.util.Comparator;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickNonRecursive<K> implements SortingAlgorithm<K> {
	private static final Logger LOG = LoggerFactory
			.getLogger(QuickNonRecursive.class);

	@Override
	public K[] sort(K[] data, Comparator<? super K> comparator) {
		return quicksort(data, comparator, 0, data.length - 1);
	}

	private Random rnd = new Random();

	private K[] quicksort(K[] data, Comparator<? super K> c, int left, int right) {
		// initialize stack
		int[][] stack = new int[data.length][2];
		// to track elements inserted in stack, termination condition
		// push low, high on stack
		int stackIndex = 0;
		stack[0][0] = left;
		stack[0][1] = right;
		int currentHigh = 0;
		int currentLow = 0;
		int pivot = 0;
		K pivotValue;
		while (stackIndex > -1) {
			// process stack
			currentLow = stack[stackIndex][0];
			currentHigh = stack[stackIndex][1];

			stackIndex--;
			// generate pivot
			pivot = currentLow + rnd.nextInt(currentHigh - currentLow);
			pivotValue = data[pivot];

			// move pivot to the right
			data[pivot] = data[currentHigh];
			data[currentHigh] = pivotValue;
			pivot = currentHigh;
			int storeIndex = currentLow;
			// partition
			for (int i = currentLow; i < currentHigh; i++) {
				// swap if bigger and before
				if (c.compare(pivotValue, data[i]) > 0) {
					K temp = data[storeIndex];
					data[storeIndex] = data[i];
					data[i] = temp;
					storeIndex++;
				}

			}
			// put pivot back
			data[pivot] = data[storeIndex];
			data[storeIndex] = pivotValue;
			pivot = storeIndex;

			// store left and right on the stack
			if (currentLow < pivot - 1) {
				stackIndex++;
				stack[stackIndex][0] = currentLow;
				stack[stackIndex][1] = pivot - 1;
			}
			if (pivot + 1 < currentHigh) {
				stackIndex++;
				stack[stackIndex][0] = pivot + 1;
				stack[stackIndex][1] = currentHigh;
			}
		}

		// move elements around pivot
		// process low, high from stack
		// push low, pivot, pivot high on stack
		// repeat until low = high
		// repeat until stack is empty

		return data;
	}

}
