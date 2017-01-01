package wheels.algorithms;

public class BubbleSort {
	public static int[] intSort(int[] targetArray) {
		int temp = 0;
		int swapCount = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < targetArray.length - 1; j++) {
				if (targetArray[j] > targetArray[j + 1]) {
					// core code of bubble sort
					temp = targetArray[j];
					targetArray[j] = targetArray[j + 1];
					targetArray[j + 1] = temp;

					swapCount++;
				}
			}
			if (swapCount == 0) {
				break;
			}
		}
		return targetArray;
	}
}