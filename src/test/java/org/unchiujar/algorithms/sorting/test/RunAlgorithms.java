package org.unchiujar.algorithms.sorting.test;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unchiujar.algorithms.sorting.BubbleSort;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class RunAlgorithms extends SimpleBenchmark {
    private static final Logger LOG = LoggerFactory
                                            .getLogger(RunAlgorithms.class);

    @Test
    public void bubbleSort() throws Exception {
        Runner.main(RunAlgorithms.class, new String[] {});
    }

    public void timeBubbleSort(int reps) throws Exception {
        BubbleSort<Integer, String> bubble = new BubbleSort<Integer, String>();
        for (int i = 0; i < reps; i++) {
            LinkedHashMap<Integer, String> data = generateData(10000);
            LOG.debug("The sorted list is : {}", bubble.sort(data));
        }
    }

    
    public void timeGenerateData(int reps){
        for (int i = 0; i < reps; i++) {
            LinkedHashMap<Integer, String> data = generateData(10000);
        }
        
    }
    
    private LinkedHashMap<Integer, String> generateData(int size) {
        LinkedHashMap<Integer, String> data =
                new LinkedHashMap<Integer, String>();
        for (int i = 0; i < size; i++) {
            data.put(new Random().nextInt(), UUID.randomUUID().toString());
        }
        return data;
    }
}
