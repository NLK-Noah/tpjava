package basics;

public class StringUtils {


    /**
     * Split a string according to a delimiter
     *
     * @param str The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     *          between two consecutive occurence of the delimiter.
     *          If there is no occurence of the delimiter, it should
     *          return an array of size 1 with the string at element 0
     */
    public static String[] split(String str, char delimiter) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                count++;
            }
        }

        if (count == 0) {
            return new String[]{str};
        }

        String[] result = new String[count + 1];

        int currentStart = 0;
        int currentIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                result[currentIndex] = str.substring(currentStart, i);
                currentIndex++;
                currentStart = i + 1;
            }
        }

        result[currentIndex] = str.substring(currentStart);

        return result;
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     *          the substring in str or -1 if sub does not appear
     *          in str
     */
    public static int indexOf(String str, String sub){
        int count = 0;
        if ( str == null || sub == null || str.length() == 0 || sub.length() == 0 || sub.length() > str.length() ) {
            return -1;
        }
        for (int i = 0; i <= str.length() - sub.length(); i++) {
            if (str.substring(i, i + sub.length()).equals(sub)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     *          character put to lower case.
     */
    public static String toLowerCase(String str){
        str = str.toLowerCase();
        return str;
    }


    /**
     * Check if a string is a palyndrome
     *
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str){
        String a = new StringBuilder(str).reverse().toString();
        if (str.equals(a)) {
            return true;
        }
        return false;
    }


}