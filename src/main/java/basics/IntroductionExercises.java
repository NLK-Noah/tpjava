package basics;

public class IntroductionExercises {

    public static int variable = 0;
    public static int[] squares;

    public static void attribute(int value) {
        variable = value;
    }

    public static int add(int a, int b) {
        return Integer.sum(a, b);
    }

    public static boolean equalsIntegers(int a, int b) {
        return a == b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int middleValue(int a, int b, int c) {
        if (a == b || b == c || a == c) {
            return -1;
        } else if ((a > b && b > c) || (c > b && b > a)) {
            return b;
        } else if ((b > a && a > c) || (c > a && a > b)) {
            return a;
        } else {
            return c;
        }
    }

    public static String greetings(String str) {
        switch (str) {
            case "Morning":
                return "Good morning, sir!";
            case "Evening":
                return "Good evening, sir!";
            default:
                return "Hello, sir!";
        }
    }

    public static int[] lastFirstMiddle(int[] a) {
        int[] b = new int[3];
        b[0] = a[a.length - 1];
        b[1] = a[0];
        b[2] = a[a.length / 2];
        return b;
    }

    public static int sum(int[] array) {
        int somme = 0;
        for (int i = 0; i < array.length; i++) {
            somme += array[i];
        }
        return somme;
    }

    public static int maxArray(int[] array) {
        int i = 0;
        int max = array[0];
        while (i < array.length) {
            if (array[i] > max) {
                max = array[i];
            }
            i++;
        }
        return max;
    }

    public static void main(String... args) {
        squares = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                int number = Integer.parseInt(args[i]);
                squares[i] = number * number;
            } catch (NumberFormatException e) {
                squares[i] = 0;
            }
        }
    }
}