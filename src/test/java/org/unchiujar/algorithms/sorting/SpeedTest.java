package org.unchiujar.algorithms.sorting;

import java.util.LinkedHashMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unchiujar.algorithms.sorting.Bubble;
import org.unchiujar.algorithms.sorting.Utils.Distribution;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class SpeedTest extends SimpleBenchmark {

	private static final Logger LOG = LoggerFactory
			.getLogger(SpeedTest.class);

	@Param({ "10000"})
	private int length;
	@Param
	private Distribution distribution;

	private LinkedHashMap<Integer, String> values;
	private LinkedHashMap<Integer, String> copy;

	private Bubble<Integer, String> bubble = new Bubble<Integer, String>();
	private Cocktail<Integer, String> cocktail = new Cocktail<Integer, String>();

	private Quick<Integer, String> quick = new Quick<Integer, String>();


	@Override
	protected void setUp() throws Exception {
		LOG.debug("Setting up with length : {} and distribution {} ", length,
				distribution);
		values = distribution.generateData(length);
		copy = new LinkedHashMap<Integer, String>(length);
	}

	@Test
	public void bubbleSort() throws Exception {
		Runner.main(SpeedTest.class, new String[] {});
	}


	public void timeBubble(int reps) throws Exception {
		copy.putAll(values);
		for (int i = 0; i < reps; i++) {
			bubble.sort(copy);
		}
	}
	public void timeCocktail(int reps) throws Exception {
		copy.putAll(values);
		for (int i = 0; i < reps; i++) {
			cocktail.sort(copy);
		}
	}

	public void timeQuick(int reps) throws Exception {
		copy.putAll(values);
		for (int i = 0; i < reps; i++) {
			quick .sort(copy);
		}
	}

}
