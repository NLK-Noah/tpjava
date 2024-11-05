package basics;

public class MagicSquare {


    /**
     * A magic square is an (n x n) matrix such that:
     *
     * - all the positive numbers 1,2, ..., n*n are present (thus each number appears exactly once)
     * - the sums of the numbers in each row, each column and both main diagonals are the same
     *
     *   For instance a 3 x 3 magic square is the following
     *
     *   2 7 6
     *   9 5 1
     *   4 3 8
     *
     *   You have to implement the method that verifies if a matrix is a valid magic square
     */

    /**
     *
     * @param matrix a square matrix of size n x n
     * @return true if matrix is a n x n magic square, false otherwise
     */

    /**
     * calclule une somme d'une ligne
     */
    public static int sommeLigne(int[][] matrix, int i) {
        int sum = 0;
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            sum += matrix[i][j];
        }
        return sum;
    }

    public static boolean verif(int[][] matrix) {
        int sum = sommeLigne(matrix, 0);
        for (int i = 0; i < matrix.length; i++) {
            if (sommeLigne(matrix, i) != sum) {
                return false;
            }
        }
        return true;
    }

    public static boolean verif2(int[] diag, int targetSum) {
        int sum = 0;
        for (int val : diag) {
            sum += val;
        }
        return sum == targetSum;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int[][] transposedMatrix = new int[rows][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static int[] diag(int[][] matrix) {
        int n = matrix.length;
        int[] diag = new int[n];
        for (int i = 0; i < n; i++) {
            diag[i] = matrix[i][i];
        }
        return diag;
    }

    public static boolean containsUniqueValues(int[][] matrix) {
        int n = matrix.length;
        int maxValue = n * n;
        boolean[] seenValues = new boolean[maxValue + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (value < 1 || value > maxValue || seenValues[value]) {
                    return false;
                }
                seenValues[value] = true;
            }
        }
        return true;
    }

    public static boolean isMagicSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        int magicSum = sommeLigne(matrix, 0);

        return containsUniqueValues(matrix) &&
                verif(matrix) &&
                verif(transpose(matrix)) &&
                verif2(diag(matrix), magicSum);
    }
}