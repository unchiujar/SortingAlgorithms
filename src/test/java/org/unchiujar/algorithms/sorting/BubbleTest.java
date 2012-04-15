package org.unchiujar.algorithms.sorting;



import org.unchiujar.algorithms.sorting.Bubble;

public class BubbleTest extends SortTest {

	private Bubble<Integer, String> bubble = new Bubble<Integer, String>();

	@Override
	protected SortingAlgorithm<Integer, String> getAlgorithm() {
		return bubble;
	}

}
