package basics;

public class CommonElements {
    /**
     *
     * @param tab1 is a non null array
     * @param tab2 is a non null array
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {i such that tab1[i] == tab2[i]}
     *         for instance count([1,3,5,5],[1,2,5,5,6]) = 3
     */
    public static int count(int[] tab1, int[] tab2) {
        int count = 0;
        int length = Math.min(tab1.length, tab2.length);
        for (int i = 0; i < length; i++) {
            if (tab1[i] == tab2[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param tab1 is a non null 2D array (matrix)
     * @param tab2 is a non null 2D array (matrix)
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {(i,j) such that tab1[i][j] == tab2[i][j]}
     */
    public static int count(int [][] tab1, int [][] tab2) {
        int count = 0;
        int a = tab1.length;
        int b = tab2.length;
        int c = Math.min(a,b);

        for (int i = 0; i < c; i++) {
            int d = Math.min(tab1[i].length, tab2[i].length);
            for (int j = 0; j < d; j++) {
                if (tab1[i][j] == tab2[i][j]) {
                    count++;
                }
            }
        }




        return count;
    }
}
