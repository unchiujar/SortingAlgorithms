package org.unchiujar.algorithms.sorting;

import static org.unchiujar.algorithms.sorting.TestUtils.INT_COMPARATOR;

import java.util.Arrays;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unchiujar.algorithms.sorting.TestUtils.Distribution;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class SpeedTest extends SimpleBenchmark {

	private static final Logger LOG = LoggerFactory.getLogger(SpeedTest.class);

	@Param({ "100" })
	private int length;
	@Param
	private Distribution distribution;

	private Integer[] values;
	private Integer[] copy;

	private Bubble<Integer> bubble = new Bubble<Integer>();
	private Cocktail<Integer> cocktail = new Cocktail<Integer>();
	private Selection<Integer> insert = new Selection<Integer>();

	
	private Quick<Integer> quick = new Quick<Integer>();
	private QuickNonRecursive<Integer> quickNonRecursive = new QuickNonRecursive<Integer>();
	

	@Override
	protected void setUp() throws Exception {
		LOG.debug("Setting up with length : {} and distribution {} ", length,
				distribution);
		copy = new Integer[length];
		values = distribution.generateData(length);
	}

	@Test
	public void benchmark() throws Exception {
		Runner.main(SpeedTest.class, new String[] {});
	}

	public void timeArraySort(int reps) throws Exception {
		copy = Arrays.copyOf(values, values.length);		
		for (int i = 0; i < reps; i++) {
			// create sorted result
			Arrays.sort(copy, INT_COMPARATOR);			
		}
		
	}
	public void timeInsert(int reps) throws Exception {
		copy = Arrays.copyOf(values, values.length);		
		for (int i = 0; i < reps; i++) {
			insert.sort(copy, INT_COMPARATOR);
		}
	}

	public void timeBubble(int reps) throws Exception {
		copy = Arrays.copyOf(values, values.length);		
		for (int i = 0; i < reps; i++) {
			bubble.sort(copy, INT_COMPARATOR);
		}
	}

	public void timeCocktail(int reps) throws Exception {
		copy = Arrays.copyOf(values, values.length);		
		for (int i = 0; i < reps; i++) {
			cocktail.sort(copy, INT_COMPARATOR);
		}
	}

	public void timeQuick(int reps) throws Exception {
		copy = Arrays.copyOf(values, values.length);		
		for (int i = 0; i < reps; i++) {
			quick.sort(copy, INT_COMPARATOR);
		}
	}

	public void timeQuickNonRecursive(int reps) throws Exception {
		copy = Arrays.copyOf(values, values.length);		
		for (int i = 0; i < reps; i++) {
			quickNonRecursive.sort(copy,INT_COMPARATOR);
		}
	}

	
}
