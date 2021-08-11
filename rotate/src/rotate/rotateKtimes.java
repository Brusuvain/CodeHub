package rotate;

public class rotateKtimes {
	static int[][] test;

	public static void antiClockwise(int matrix[][], int begin, int end) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		int temp = matrix[begin][begin];
		// Shifting the top row by 1 element (anticlockwise)
		for (int i = begin; i < end; i++) {
			matrix[begin][i] = matrix[begin][i + 1];

		}
		// Shifting the last column by 1 element (anticlockwise)
		for (int i = begin; i < end; i++) {
			matrix[i][end] = matrix[i + 1][end];

		}
		// Shifting the last row by 1 element (anticlockwise)
		for (int i = end; i > begin; i--) {
			matrix[end][i] = matrix[end][i - 1];

		}
		// Shifting the first column by 1 element (anticlockwise)
		for (int i = end; i > begin; i--) {
			matrix[i - 1][begin] = matrix[i - 1][begin];
		}
		matrix[begin + 1][begin] = temp;

		// printing final matrix
		System.out.println();
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void clockwise(int matrix[][], int begin, int end) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		int temp = matrix[begin][begin];
		int temp2 = 0;
		// Shifting the top row by 1 element
		for (int i = begin; i < end; i++) {
			temp2 = matrix[begin][i + 1];
			matrix[begin][i + 1] = temp;
			temp = temp2;

		}
		// Shifting the last column by 1 element
		for (int i = begin; i < end; i++) {
			temp2 = matrix[i + 1][end];
			matrix[i + 1][end] = temp;
			temp = temp2;
		}
		// Shifting the last row by 1 element
		for (int i = end; i > begin; i--) {
			temp2 = matrix[end][i - 1];
			matrix[end][i - 1] = temp;
			temp = temp2;

		}
		// Shifting the first column by 1 element
		for (int i = end; i > begin; i--) {
			temp2 = matrix[i - 1][begin];
			matrix[i - 1][begin] = temp;
			temp = temp2;
		}

		// printing final matrix
		System.out.println();
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		test = new int[4][4];
		for (int i = 1; i <= test.length; i++) {
			for (int j = 1; j <= test.length; j++) {
				test[i - 1][j - 1] = i * j;
			}
		}
		int begin = 0;
		int end = test.length - 1;
		boolean clockWise = true;
		int k = 2;// flag that alternate between clockwise and anticlockwise rotation
		while (begin < end) {
			if (clockWise) {
				clockWise = false;
				for (int i = 0; i < k; i++)
					clockwise(test, begin, end);
			} else {
				clockWise = true;
				for (int i = 0; i < k; i++)
					antiClockwise(test, begin, end);
			}
			System.out.println();
			begin++;
			end--;
		}

	}
}
