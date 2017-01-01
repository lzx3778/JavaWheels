package wheels.math;

public class MatrixGenerator {
	public static int[][] random2DMatrix(int width, int length) {
		int[][] i1 = new int[length][width];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				i1[i][j] = i + j;
			}
		}
		return i1;
	}
}