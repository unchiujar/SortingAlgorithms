package org.unchiujar.algorithms.sorting;

import java.util.Comparator;

public class Selection<K> implements
		SortingAlgorithm<K> {

	@Override
	public K[] sort(K[] keys, Comparator<? super K> comparator) {
		int pos = 0;
		K min =  keys[0];
		K temp;
		boolean sorted = false;
		while (!sorted ) {
			sorted = true;
			for (int i = pos + 1; i < keys.length; i++) {
				
				if(comparator.compare(keys[i],min)<0) {
					sorted = false;
					temp = keys[i];
					keys[i] = min;
					min = temp;
					pos = i;
				}
			}
		}
		return keys;
	}
}
