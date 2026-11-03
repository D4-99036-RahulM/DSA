package com.sunbeam;

public class NonRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				         int[] inputArray = {1, 2, 3,
				 -1, 2, 1, 0, 4, -1, 7, 8};
				         int result =
				 findFirstNonRepeating(inputArray);
				         System.out.println("Firstnon-repeating element: " + result);
				     }

	public static int findFirstNonRepeating(int[] array) {

		for (int i = 0; i < array.length; i++) {
			boolean isNonRepeating = true;

			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i] == array[j]) {

					isNonRepeating = false;
					break;
				}
			}

			if (isNonRepeating) {
				return array[i];
			}
		}

		return -1;
	}
}


