package wheels.math;

public class Matrix {
	public Matrix() {
		int[][] m1 = MatrixGenerator.random2DMatrix(3, 2);
		int[][] m2 = MatrixGenerator.random2DMatrix(2, 3);
		int[][] ans = TwoDMatrix(m1, m2);
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[1].length; j++) {
				System.out.print(m1[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2[1].length; j++) {
				System.out.print(m2[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[1].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static int[][] TwoDMatrix(int[][] i1, int[][] i2) {
		int[][] i3 = new int[i1.length][i2[1].length];
		for (int i = 0; i < i3.length - 1; i++) {
			for (int j = 0; j < i3[i].length - 1; j++) {
				i3[i][j] = i1[i][j] * i2[i][j] + i1[i][j + 1] + i2[i + 1][j];
			}
		}
		return i3;
	}
}