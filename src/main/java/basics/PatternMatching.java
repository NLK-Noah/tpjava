package basics;

public class PatternMatching {

    public static int find(String value, String pattern) {
        int valueLength = value.length();
        pattern= pattern.trim();
        System.out.println(pattern);
        int patternLength = pattern.length();
        System.out.println(patternLength);

        if (value.isEmpty()) {
            return -1;
        }

        if (valueLength == 0 || patternLength == 0 || patternLength < valueLength) {
            return -1;
        }

        for (int i = 0; i <= patternLength - valueLength; i++) {
            if (pattern.substring(i, i + valueLength).equals(value)) {
                return i;
            }
        }

        return -1;
    }
}
