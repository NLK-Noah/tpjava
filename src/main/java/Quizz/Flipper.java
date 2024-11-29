package Quizz;


// SEE THE explanations in the Videos

public class Flipper {

    public static int run(char[][] map) {
        int n = map.length;
        int m = map[0].length;
        int x = 0, y = 0;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        while (x >= 0 && x < n -1 && y >= 0 && y < m -1) {
            if (!visited[x][y]) {
                visited[x][y] = true;
                count++;
            }

            if (map[x][y] == '/') {
                x--;
                y--;
            } else if (map[x][y] == '\\') {
                x++;
                y++;
            } else {
                y++;
            }
        }

        return count;
    }
}
