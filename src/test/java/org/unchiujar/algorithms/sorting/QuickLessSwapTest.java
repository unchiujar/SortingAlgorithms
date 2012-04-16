package org.unchiujar.algorithms.sorting;


public class QuickLessSwapTest extends SortTest {
	QuickLessSwap<Integer, String> quick = new QuickLessSwap<Integer, String>();

	@Override
	protected SortingAlgorithm<Integer, String> getAlgorithm() {
		return quick;
	}

}
