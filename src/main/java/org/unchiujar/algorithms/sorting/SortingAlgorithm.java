package org.unchiujar.algorithms.sorting;

import java.util.LinkedHashMap;

interface SortingAlgorithm<K extends Comparable<K>, T> {

    LinkedHashMap<K, T> sort(LinkedHashMap<K, T> data);
}
