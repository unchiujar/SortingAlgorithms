package org.unchiujar.algorithms.sorting;

public class JavaSortTest extends SortTest {
	JavaSort<Integer> java = new JavaSort<Integer>();

	@Override
	protected SortingAlgorithm<Integer> getAlgorithm() {
		return java;
	}

}
