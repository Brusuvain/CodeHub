package rotate;


public class rotateMatrixClass {
	public static void rotateMatrix(int matrix[][]) {
		int begin = 0;
		int end = matrix.length - 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		while (begin < end) {
			int temp = matrix[begin][begin];
			int temp2 = 0;
			// Shifting the top row by 1 element 
			for (int i = begin; i < end; i++) {
				temp2 = matrix[begin][i + 1];
				matrix[begin][i + 1] = temp;
				temp = temp2;

			}
			//Shifting the last column by 1 element
			for (int i = begin; i < end; i++) {
				temp2 = matrix[i + 1][end];
				matrix[i + 1][end] = temp;
				temp = temp2;
			}
			//Shifting the last row by 1 element
			for (int i = end; i > begin; i--) {
				temp2 = matrix[end][i - 1];
				matrix[end][i - 1] = temp;
				temp = temp2;

			}
			//Shifting the first column by 1 element
			for (int i = end; i > begin; i--) {
				temp2 = matrix[i - 1][begin];
				matrix[i - 1][begin] = temp;
				temp = temp2;
			}

			begin++;
			end--;

		}
		//printing final matrix
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
		int[][] test = new int[4][4];
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				test[i - 1][j - 1] = i * j;
			}
		}

		rotateMatrix(test);

	}
}
