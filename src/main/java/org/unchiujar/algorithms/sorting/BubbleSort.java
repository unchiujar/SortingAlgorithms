package org.unchiujar.algorithms.sorting;

import java.util.LinkedHashMap;

public class BubbleSort<K extends Comparable<K>, T> implements
        SortingAlgorithm<K, T> {

    @Override
    public LinkedHashMap<K, T> sort(LinkedHashMap<K, T> data) {
        Object[] keys = data.keySet().toArray();
        boolean sorted = false;
        while (!sorted ) {
            sorted = true;
            for (int i = 0; i < keys.length - 1; i++) {
                if (((K) keys[i+1]).compareTo((K) keys[i]) < 0) {
                    // swap
                    Object temp = keys[i];
                    keys[i] = keys[i + 1];
                    keys[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        // create sorted result
        LinkedHashMap result = new LinkedHashMap<K, T>();
        for (int i = 0; i < keys.length - 1; i++) {
            result.put((K) keys[i], (T) data.get(keys[i]));
        }
        return result;
    }
}
