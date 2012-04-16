package org.unchiujar.algorithms.sorting;

import static org.unchiujar.algorithms.sorting.Utils.actualSort;
import static org.unchiujar.algorithms.sorting.Utils.Distribution.DECREASING;
import static org.unchiujar.algorithms.sorting.Utils.Distribution.INCREASING;
import static org.unchiujar.algorithms.sorting.Utils.Distribution.RANDOM;
import static org.unchiujar.algorithms.sorting.Utils.Distribution.SAWTOOTH;

import java.util.LinkedHashMap;

import org.junit.Test;

public abstract class SortTest {

	private static final int LENGTH = 15;

	public SortTest() {
		super();
	}

	@Test
	public void random() throws Exception {
		LinkedHashMap<Integer, String> tested = RANDOM
				.generateData(LENGTH);
		actualSort(tested, getAlgorithm());
	}

	@Test
	public void increasing() throws Exception {
		LinkedHashMap<Integer, String> tested = INCREASING
				.generateData(LENGTH);
	
		actualSort(tested, getAlgorithm());
	}

	@Test
	public void decreasing() throws Exception {
		LinkedHashMap<Integer, String> tested = DECREASING
				.generateData(LENGTH);
		actualSort(tested, getAlgorithm());
	}

	@Test
	public void sawtooth() throws Exception {
		LinkedHashMap<Integer, String> tested = SAWTOOTH
				.generateData(LENGTH);
		actualSort(tested, getAlgorithm());
	}

	protected abstract SortingAlgorithm<Integer, String> getAlgorithm();

}