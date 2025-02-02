package algorithms;

/**
 * The roots of a function are the values of its domain for which it evaluates to false.
 * In this exercice, we give you a function that implements the Function interface below and
 * we ask you to find its only root. You can assume that:
 *  - The function is monotoningly increasing
 *  - The function has exactly one zero
 *  - The function takes an integer as input and returns another integer.
 *
 * You can do the following operation on the function
 *  1) Get the minimum of the domain of the function
 *  2) Get the maximum of the domain of the function
 *  3) Evaluate the function on a value of its domain
 *
 * Your method should run in O(log(n)) with n being the number of elements in the domain of the function.
 *
 */
public class FunctionRoot {

    /**
     * An interface for a function
     */
    public static interface Function {

        /**
         * @return the minimum of the function's domain
         */
        public int getMinDomain();

        /**
         * @return the maximum of the function's domain
         */
        public int getMaxDomain();

        /**
         * @return evaluates the function on a element of its domain
         * @throws IllegalArgumentException if x is not in the domain of the function
         */
        public int evaluates(int x);
    }

    /**
     * Finds the root of the function
     *
     * @param f the function
     * @return the root of f
     */
    public static int findRoot(Function f) {
         int min = f.getMinDomain();
         int max = f.getMaxDomain();
         while (min <= max) {
             int mid=min+max/2;
             int r=f.evaluates(mid);
             if(r==0) {return mid;}
             else if(r<0) {min=mid+1;}
             else { max=mid-1;}
         }
         return Integer.MAX_VALUE;
    }

}
