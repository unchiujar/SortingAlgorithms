package org.unchiujar.algorithms.sorting.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unchiujar.algorithms.sorting.BubbleSort;
import org.unchiujar.algorithms.sorting.SortingAlgorithm;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class RunAlgorithms extends SimpleBenchmark {
	private static final int CORRECTNESS_LENGTH = 100;

	private static final Logger LOG = LoggerFactory
			.getLogger(RunAlgorithms.class);

	@Param({ "10", "100", "1000", "10000" })
	private int length;
	@Param
	private Distribution distribution;

	private LinkedHashMap<Integer, String> values;
	private LinkedHashMap<Integer, String> copy;

	private BubbleSort<Integer, String> bubble = new BubbleSort<Integer, String>();

	@Override
	protected void setUp() throws Exception {
		LOG.debug("Setting up with length : {} and distribution {} ", length,
				distribution);
		values = distribution.generateData(length);
		copy = new LinkedHashMap<Integer, String>(length);
	}

	@Test
	@Ignore
	public void bubbleSort() throws Exception {
		Runner.main(RunAlgorithms.class, new String[] {});
	}

	@Test
	public void bubbleSortRandomCorrectness() throws Exception {
		LinkedHashMap<Integer, String> tested = Distribution.RANDOM
				.generateData(CORRECTNESS_LENGTH);
		actualSort(tested, bubble);
	}

	@Test
	public void bubbleSortIncreasingCorrectness() throws Exception {
		LinkedHashMap<Integer, String> tested = Distribution.INCREASING
				.generateData(CORRECTNESS_LENGTH);

		actualSort(tested, bubble);
	}

	@Test
	public void bubbleSortDeacreasingCorrectness() throws Exception {
		LinkedHashMap<Integer, String> tested = Distribution.DECREASING
				.generateData(CORRECTNESS_LENGTH);
		actualSort(tested, bubble);
	}

	@Test
	public void bubbleSortSawtoothCorrectness() throws Exception {
		LinkedHashMap<Integer, String> tested = Distribution.SAWTOOTH
				.generateData(CORRECTNESS_LENGTH);
		actualSort(tested, bubble);
	}

	public void timeBubbleSort(int reps) throws Exception {
		copy.putAll(values);
		for (int i = 0; i < reps; i++) {
			bubble.sort(copy);
		}
	}

	private void actualSort(LinkedHashMap<Integer, String> tested,
			SortingAlgorithm<Integer, String> algo) {
		TreeMap<Integer, String> expected = new TreeMap<Integer, String>(tested);

		LinkedHashMap<Integer, String> result = algo.sort(tested);

		ArrayList<String> expectedValues = new ArrayList<String>(
				expected.values());
		ArrayList<String> resultValues = new ArrayList<String>(result.values());

		for (int i = 0; i < expectedValues.size() - 1; i++) {
			assertTrue(expectedValues.get(i).equals(resultValues.get(i)));
		}
	}

	public enum Distribution {
		SAWTOOTH {
			@Override
			LinkedHashMap<Integer, String> generateData(int length) {
				LinkedHashMap<Integer, String> data = new LinkedHashMap<Integer, String>(
						length);

				for (int i = 0; i < length; i += 5) {
					data.put(i, UUID.randomUUID().toString());
					data.put(i + 1, UUID.randomUUID().toString());
					data.put(i + 2, UUID.randomUUID().toString());
					data.put(i + 3, UUID.randomUUID().toString());
					data.put(i + 4, UUID.randomUUID().toString());
				}
				return data;
			}
		},
		INCREASING {

			@Override
			LinkedHashMap<Integer, String> generateData(int length) {
				LinkedHashMap<Integer, String> data = new LinkedHashMap<Integer, String>(
						length);

				for (int i = 0; i < length; i++) {
					data.put(i, UUID.randomUUID().toString());
				}
				return data;

			}

		},
		DECREASING {
			@Override
			LinkedHashMap<Integer, String> generateData(int length) {
				LinkedHashMap<Integer, String> data = new LinkedHashMap<Integer, String>(
						length);

				for (int i = length; i > 0; i--) {
					data.put(i, UUID.randomUUID().toString());
				}
				return data;
			}

		},
		RANDOM {
			@Override
			LinkedHashMap<Integer, String> generateData(int length) {
				LinkedHashMap<Integer, String> data = new LinkedHashMap<Integer, String>(
						length);
				for (int i = 0; i < length; i++) {
					data.put(new Random().nextInt(), UUID.randomUUID()
							.toString());
				}
				return data;
			}
		};

		abstract LinkedHashMap<Integer, String> generateData(int length);
	}
}
