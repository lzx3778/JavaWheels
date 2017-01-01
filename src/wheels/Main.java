package wheels;

import wheels.Graphic.Wave;
import wheels.algorithms.BucketSort;
import wheels.no_Graphic.PrintArray;

public class Main {

	public static void main(String[] args) {
		int[] a = { 1, 5, 4, 7, 8, 3, 8, 9, 5, 5, 5, 33, 2, 1, 1, 2, 6 };
		int[] b = BucketSort.intSort(a);

		PrintArray.IntArray(b);
	}
}
