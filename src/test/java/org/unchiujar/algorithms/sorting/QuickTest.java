package org.unchiujar.algorithms.sorting;


public class QuickTest extends SortTest {
	Quick<Integer> quick = new Quick<Integer>();

	@Override
	protected SortingAlgorithm<Integer> getAlgorithm() {
		return quick;
	}

}
