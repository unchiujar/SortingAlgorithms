package org.unchiujar.algorithms.sorting;


public class CocktailTest extends SortTest {
	Cocktail<Integer, String> cocktail = new Cocktail<Integer, String>();

	@Override
	protected SortingAlgorithm<Integer, String> getAlgorithm() {
		return cocktail;
	}

}
