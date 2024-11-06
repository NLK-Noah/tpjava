package basics;

public class Matrix {

    public static int[][] buildFrom(String s) {
        String[] rows = s.split("\n");
        int numRows = rows.length;

        int[][] matrix = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            String[] elements = rows[i].trim().split("\\s+");
            int numCols = elements.length;
            matrix[i] = new int[numCols];
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }

        return matrix;
    }
    public static int sum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int m = matrix1[0].length;
        int k = matrix2[0].length;

        int[][] productMatrix = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    productMatrix[i][j] += matrix1[i][l] * matrix2[l][j];
                }
            }
        }
        return productMatrix;
    }
}