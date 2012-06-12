package org.unchiujar.algorithms.sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class TestUtils {
	public enum Distribution {
		SAWTOOTH {
			@Override
			Integer[] generateData(int length) {
				Integer[] data = new Integer[length];

				for (int i = 0; i < length; i += 5) {
					data[i] = i;
					data[i + 1] = i + 1;
					data[i + 2] = i + 2;
					data[i + 3] = i + 3;
					data[i + 4] = i + 4;
				}
				return data;
			}
		},
		INCREASING {
			@Override
			Integer[] generateData(int length) {
				Integer[] data = new Integer[length];
				for (int i = 0; i < length; i++) {
					data[i] = i;
				}
				return data;
			}
		},
		DECREASING {
			@Override
			Integer[] generateData(int length) {
				Integer[] data = new Integer[length];
				for (int i = length; i > 0; i--) {
					data[i-1] = i-1;
				}
				return data;
			}

		},
		RANDOM {
			@Override
			Integer[] generateData(int length) {
				Integer[] data = new Integer[length];
				Random rand = new Random();
				for (int i = 0; i < length; i++) {
					data[i] = rand.nextInt();
				}
				return data;
			}
		},

		GAUSSIAN {
			@Override
			Integer[] generateData(int length) {
				Integer[] data = new Integer[length];
				Random rand = new Random();
				for (int i = 0; i < length; i++) {
					data[i] =  (int)(rand.nextGaussian() * Integer.MAX_VALUE);
				}
				return data;
			}

		};

		abstract Integer[] generateData(int length);
	}

	public static void actualSort(Integer[] tested, Comparator<Integer> comp,
			SortingAlgorithm<Integer> algo) {

		Integer[] result = algo.sort(tested, comp);
		Arrays.sort(tested, comp);
		assertArrayEquals(tested, result);
	}
	
	public final static Comparator<Integer> INT_COMPARATOR = new Comparator<Integer>(){

		@Override
		public int compare(Integer int1, Integer int2) {
			return int1-int2;
		}
		
	};

}
