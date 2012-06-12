package org.unchiujar.algorithms.sorting;


public class CocktailTest extends SortTest {
	Cocktail<Integer> cocktail = new Cocktail<Integer>();

	@Override
	protected SortingAlgorithm<Integer> getAlgorithm() {
		return cocktail;
	}

}
