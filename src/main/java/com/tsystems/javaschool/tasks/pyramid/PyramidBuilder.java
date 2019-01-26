package com.tsystems.javaschool.tasks.pyramid;

import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

	/**
	 * Builds a pyramid with sorted values (with minumum value at the top line and
	 * maximum at the bottom, from left to right). All vacant positions in the array
	 * are zeros.
	 *
	 * @param inputNumbers to be used in the pyramid
	 * @return 2d array with pyramid inside
	 * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build
	 *         with given input
	 */

	public int[][] buildPyramid(List<Integer> inputNumbers)
			throws CannotBuildPyramidException {

		for (Integer inputNmber : inputNumbers) {
			if (inputNmber == null) {
				throw new CannotBuildPyramidException(
						"You can't build a pyramid using these numbers");
			}
		}

		// First of all we have to find out dimensions of the required array

		int pyramidHeight = getPyramidHeight(inputNumbers.size());
		int pyramidWidth = 2 * pyramidHeight - 1;
		int[][] pyramid = new int[pyramidHeight][pyramidWidth];

		Collections.sort(inputNumbers);

		int offsetFromSides = 0;
		int inputNumbersListIndex = 1;

		/*
		 * We fill the pyramid from bottom to top, from right to left. On each row
		 * offset from pyramid sides increases by 2. Notice, that the values to input
		 * are taken from the end of the inputNumbers list.
		 */

		for (int row = pyramidHeight - 1; row > -1; row--) {
			for (int column = pyramidWidth - 1
					- offsetFromSides; column >= offsetFromSides
							&& inputNumbersListIndex <= inputNumbers
									.size(); column -= 2) {
				pyramid[row][column] = inputNumbers
						.get(inputNumbers.size() - inputNumbersListIndex);
				inputNumbersListIndex++;
			}
			offsetFromSides++;
		}
		return pyramid;
	}

	/*
	 * In each row we use one digit more than in the previous row, therefore for
	 * calculating the height of the pyramid we can minus the size of the list 1 ,
	 * then minus 2, then minus 3, etc., while the size of the list is more than 0.
	 * At the end of the iterations inputSize should be equal to zero, otherwise we
	 * can't build a pyramid
	 */

	private static int getPyramidHeight(int inputNumberSize)
			throws CannotBuildPyramidException {
		int pyramidHeight = 0;
		while (inputNumberSize > 0) {
			inputNumberSize -= pyramidHeight;
			pyramidHeight++;
		}

		if (inputNumberSize < 0) {
			throw new CannotBuildPyramidException(
					"You can't build a pyramid using these numbers");
		} else {
			return pyramidHeight - 1;
		}
	}

}