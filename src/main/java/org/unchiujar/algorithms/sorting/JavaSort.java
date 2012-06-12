package org.unchiujar.algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class JavaSort<K> implements SortingAlgorithm<K> {

	@Override
	public K[] sort(K[] data, Comparator<? super K> comparator) {
		Arrays.sort(data, comparator);
		return data;
	}
}
