package org.unchiujar.algorithms.sorting;



import org.unchiujar.algorithms.sorting.Bubble;

public class BubbleTest extends SortTest {

	private Bubble<Integer> bubble = new Bubble<Integer>();

	@Override
	protected SortingAlgorithm<Integer> getAlgorithm() {
		return bubble;
	}

}
