package org.unchiujar.algorithms.sorting;


public class QuickTest extends SortTest {
	Quick<Integer, String> quick = new Quick<Integer, String>();

	@Override
	protected SortingAlgorithm<Integer, String> getAlgorithm() {
		return quick;
	}

}
