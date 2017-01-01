package wheels.algorithms;

public class BucketSort {
	public static int[] intSort(int[] targetArray) {
		// deal with the negative numbers and the size of tempArray
		int largest = 0;
		for (int i = 0; i < targetArray.length; i++) {
			if (targetArray[i] <= 0) {
				targetArray[i] = Math.abs(targetArray[i]);
			}
			if (targetArray[i] > largest) {
				largest = targetArray[i];
			}
		}
		largest++;

		// initialize values
		int[] tempArray = new int[largest];
		int[] returnArray = new int[targetArray.length];
		int count = 0;

		// the core of bucket sort
		for (int i = 0; i < targetArray.length; i++) {
			tempArray[targetArray[i]]++;
		}

		// ergodic tempArray
		for (int i = 0; i < tempArray.length; i++) {
			// put the [i] (position number) into the [count] position of
			// returnArray
			// [j] (number stored in that position) times
			for (int j = 0; j < tempArray[i]; j++) {
				returnArray[count] = i;
				count++;
			}
		}
		return returnArray;
	}

}
