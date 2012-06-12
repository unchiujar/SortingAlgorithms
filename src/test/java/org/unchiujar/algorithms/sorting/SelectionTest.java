package org.unchiujar.algorithms.sorting;




public class SelectionTest extends SortTest {

	private Selection<Integer> selection = new Selection<Integer>();

	@Override
	protected SortingAlgorithm<Integer> getAlgorithm() {
		return selection;
	}

}
