package org.unchiujar.algorithms.sorting;

import static org.unchiujar.algorithms.sorting.Utils.arrangeMap;

import java.util.LinkedHashMap;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickLessSwap<K extends Comparable<K>, T> implements
		SortingAlgorithm<K, T> {
	private static final Logger LOG = LoggerFactory
			.getLogger(QuickLessSwap.class);

	@Override
	public LinkedHashMap<K, T> sort(LinkedHashMap<K, T> data) {
		Object[] keys = data.keySet().toArray();
		// create sorted result
		keys = quicksort(keys, 0, keys.length - 1);
		return arrangeMap(data, keys);
	}

	private Random rnd = new Random();

	private Object[] quicksort(Object[] keys, final int left, final int right) {
		if (left < right) {
			// choose random pivot
			int pivot = left + rnd.nextInt(right - left);
			int pivotValue = (Integer) keys[pivot];

			// move pivot to the right
			keys[pivot] = keys[right];
			keys[right] = pivotValue;
			pivot = right;

			int leftCursor = left;
			int rightCursor = right - 1;

			int leftSwap = -1;
			int rightSwap = -1;
			int temp = 0;

			while (leftCursor < rightCursor) {

//				printStatus(keys, left, right + 1, pivot, rightCursor,
//						leftCursor);

				if ((Integer) keys[leftCursor] > pivotValue) {
					leftSwap = leftCursor;
				} else {
					leftCursor++;
				}

				if ((Integer) keys[rightCursor] < pivotValue) {
					rightSwap = rightCursor;
				} else {
					rightCursor--;
				}

				// if both values found swap
				if (leftSwap != -1 && rightSwap != -1) {
					// swap values
					temp = (Integer) keys[leftSwap];
					keys[leftSwap] = keys[rightSwap];
					keys[rightSwap] = temp;

					// reset found
					leftSwap = -1;
					rightSwap = -1;
				}

			}

			if ((Integer) keys[leftCursor] > pivotValue) {
				keys[pivot] = keys[leftCursor];
				keys[leftCursor] = pivotValue;
				pivot = leftCursor;

			} else if ((Integer) keys[rightCursor] < pivotValue) {

				keys[pivot] = keys[rightCursor + 1];
				keys[rightCursor + 1] = pivotValue;
				pivot = rightCursor + 1;
			}
//			printStatus(keys, left, right + 1, pivot, rightCursor, leftCursor);

			// sort smaller
			quicksort(keys, left, pivot - 1);
			// sort larger
			quicksort(keys, pivot + 1, right);
//			printStatus(keys, left, right + 1, pivot, rightCursor, leftCursor);

		}

		return keys;
	}

	@SuppressWarnings("unused")
	private void printStatus(Object[] keys, int start, int end, int pivot,
			int rightCursor, int leftCursor) {

		for (int i = start; i < end; i++) {
			if (i == pivot) {
				System.out.print("[" + keys[i] + "]");
			} else if (i == leftCursor) {
				System.out.print("(" + keys[i] + ")");

			} else if (i == rightCursor) {
				System.out.print("{" + keys[i] + "}");

			} else {
				System.out.print(keys[i] + " ");
			}
		}
		System.out.println();
	}
}
