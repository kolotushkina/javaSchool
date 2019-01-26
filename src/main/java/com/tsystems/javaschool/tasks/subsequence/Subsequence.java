package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Subsequence {

	/**
	 * Checks if it is possible to get a sequence which is equal to the first one by
	 * removing some elements from the second one.
	 *
	 * @param x first sequence
	 * @param y second sequence
	 * @return <code>true</code> if possible, otherwise <code>false</code>
	 */
	@SuppressWarnings("rawtypes")
	public boolean find(List x, List y) {

		if (x == null || y == null) {
			throw new IllegalArgumentException();
		}

		boolean isPossible = true;

		/*
		 * We have to iterate over all the elements from list x one by one and compare
		 * them with the elements from list y.
		 */

		int k = 0; // we start going through list y from this index
		for (int i = 0; i < x.size(); i++) {
			if (!isPossible) {
				break;
			}
			isPossible = false;
			for (int j = k; j < y.size(); j++) {
				if (y.get(j).equals(x.get(i))) {
					k = j + 1;
					isPossible = true;
					break;
				}
			}
		}
		return isPossible;
	}
}
