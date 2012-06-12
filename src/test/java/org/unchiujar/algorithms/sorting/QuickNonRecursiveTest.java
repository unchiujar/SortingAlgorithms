package org.unchiujar.algorithms.sorting;


public class QuickNonRecursiveTest extends SortTest {
	QuickNonRecursive<Integer> quick = new QuickNonRecursive<Integer>();

	@Override
	protected SortingAlgorithm<Integer> getAlgorithm() {
		return quick;
	}

}
