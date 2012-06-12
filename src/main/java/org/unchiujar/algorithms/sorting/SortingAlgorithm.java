package org.unchiujar.algorithms.sorting;

import java.util.Comparator;

public interface SortingAlgorithm<K> {

    K[] sort(K[] data, Comparator<? super K> comparator);

}
