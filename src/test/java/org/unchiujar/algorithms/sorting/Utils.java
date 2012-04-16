package org.unchiujar.algorithms.sorting;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;

import org.unchiujar.algorithms.sorting.SortingAlgorithm;

public class Utils {
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
		},
		
		GAUSSIAN {
			@Override
			LinkedHashMap<Integer, String> generateData(int length) {
				LinkedHashMap<Integer, String> data = new LinkedHashMap<Integer, String>(
						length);
				for (int i = 0; i < length; i++) {
					data.put((int)(new Random().nextGaussian()*Integer.MAX_VALUE), UUID.randomUUID()
							.toString());
				}
				return data;
			}
			
		};

		abstract LinkedHashMap<Integer, String> generateData(int length);
	}
	
	public static void actualSort(LinkedHashMap<Integer, String> tested,
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
	
	public static <K, T> LinkedHashMap<K, T> arrangeMap(LinkedHashMap<K, T> data,
			Object[] keys) {
		LinkedHashMap<K, T> result = new LinkedHashMap<K, T>();
		for (int i = 0; i < keys.length; i++) {
			result.put((K) keys[i], (T) data.get(keys[i]));
		}
		return result;
	}
}
