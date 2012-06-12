package org.unchiujar.algorithms.sorting;

import java.util.LinkedHashMap;

public class Utils {

	
	public static <K, T> LinkedHashMap<K, T> arrangeMap(LinkedHashMap<K, T> data,
			Object[] keys) {
		LinkedHashMap<K, T> result = new LinkedHashMap<K, T>();
		for (int i = 0; i < keys.length; i++) {
			result.put((K) keys[i], (T) data.get(keys[i]));
		}
		return result;
	}
}
