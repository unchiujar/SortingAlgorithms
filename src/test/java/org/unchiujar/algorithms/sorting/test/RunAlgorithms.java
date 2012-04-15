package org.unchiujar.algorithms.sorting.test;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unchiujar.algorithms.sorting.BubbleSort;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class RunAlgorithms extends SimpleBenchmark {
    private static final Logger            LOG =
                                                       LoggerFactory
                                                               .getLogger(RunAlgorithms.class);

    @Param({ "10", "100", "1000", "10000" })
    private int                            length;
    @Param
    private Distribution                   distribution;

    private LinkedHashMap<Integer, String> values;
    private LinkedHashMap<Integer, String> copy;

    private BubbleSort<Integer, String> bubble = new BubbleSort<Integer, String>();

    @Override
    protected void setUp() throws Exception {
        LOG.debug("Setting up with length : {} and distribution {} ", length,  distribution);
        values = distribution.generateData(length);
        copy = new LinkedHashMap<Integer, String>(length);
    }

    @Test
    public void bubbleSort() throws Exception {
        Runner.main(RunAlgorithms.class, new String[] {});
    }

    public void timeBubbleSort(int reps) throws Exception {
        copy.putAll(values);
        for (int i = 0; i < reps; i++) {
             bubble.sort(copy);
        }
    }

    public enum Distribution {
        SAWTOOTH {
            @Override
            LinkedHashMap<Integer, String> generateData(int length) {
                LinkedHashMap<Integer, String> data =
                        new LinkedHashMap<Integer, String>(length);

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
                LinkedHashMap<Integer, String> data =
                        new LinkedHashMap<Integer, String>(length);

                for (int i = 0; i < length; i++) {
                    data.put(i, UUID.randomUUID().toString());
                }
                return data;

            }

        },
        DECREASING {
            @Override
            LinkedHashMap<Integer, String> generateData(int length) {
                LinkedHashMap<Integer, String> data =
                        new LinkedHashMap<Integer, String>(length);

                for (int i = length; i > 0; i--) {
                    data.put(i, UUID.randomUUID().toString());
                }
                return data;
            }

        },
        RANDOM {
            @Override
            LinkedHashMap<Integer, String> generateData(int length) {
                LinkedHashMap<Integer, String> data =
                        new LinkedHashMap<Integer, String>(length);
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
