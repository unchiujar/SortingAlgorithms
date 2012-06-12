package org.unchiujar.algorithms.sorting;

import static org.unchiujar.algorithms.sorting.TestUtils.INT_COMPARATOR;
import static org.unchiujar.algorithms.sorting.TestUtils.actualSort;
import static org.unchiujar.algorithms.sorting.TestUtils.Distribution.DECREASING;
import static org.unchiujar.algorithms.sorting.TestUtils.Distribution.INCREASING;
import static org.unchiujar.algorithms.sorting.TestUtils.Distribution.RANDOM;
import static org.unchiujar.algorithms.sorting.TestUtils.Distribution.SAWTOOTH;

import org.junit.Test;

public abstract class SortTest {

	private static final int LENGTH = 10000;

	public SortTest() {
		super();
	}

	@Test
	public void random() throws Exception {
		Integer[] tested = RANDOM.generateData(LENGTH);
		actualSort(tested, INT_COMPARATOR, getAlgorithm());
	}

	@Test
	public void increasing() throws Exception {
		Integer[] tested = INCREASING.generateData(LENGTH);
		actualSort(tested, INT_COMPARATOR, getAlgorithm());
	}

	@Test
	public void decreasing() throws Exception {
		Integer[] tested = DECREASING.generateData(LENGTH);
		actualSort(tested, INT_COMPARATOR, getAlgorithm());
	}

	@Test
	public void sawtooth() throws Exception {
		Integer[] tested = SAWTOOTH.generateData(LENGTH);
		actualSort(tested, INT_COMPARATOR, getAlgorithm());
	}

	protected abstract SortingAlgorithm<Integer> getAlgorithm();

}