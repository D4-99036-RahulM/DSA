package com.sunbeam;

public class BinarySearchDescending {

	public static void main(String[] args) {
		int[] sortedArray = { 8, 7, 6, 5, 4, 3, 2, 1 };
		int target = 5;
		int result = binarySearchDescending(sortedArray, target);

		if (result != -1) {
			System.out.println("Element found at index: " + result);
		} else {
			System.out.println("Element not found");
		}
	}

	public static int binarySearchDescending(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {

				left = mid + 1;
			} else {

				right = mid - 1;
			}
		}

		return -1;
	}
}
