package basics;


/**
 * A class that represents a game of Four in a Row.
 * The game is played on a 6x7 board.
 * A player wins when he has 4 pieces in a row, column or diagonal.
 *
 * ForInARow is a two-player connection rack game, in which the players choose a color and
 * then take turns dropping colored tokens into a six-row, seven-column vertically suspended grid.
 * The pieces fall straight down, occupying the lowest available space within the column.
 *
 * The objective of the game is to be the first to form a horizontal,
 * vertical, or diagonal line of four of one's own tokens.
 *
 * Your taks is to model the game and implement the method hasWon(char player) that returns true.
 * if the player has won the game.
 * We advise you to model the state of the game with an internal 2D array of char.
 */
public class FourInARow {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    private static final char EMPTY = '-';
    private static final char[] PLAYERS = {'X', 'O'};

    private static final char[][] jeu = new char[ROWS][COLUMNS];

    public FourInARow() {
         for (int row = 0; row < ROWS; row++) {
             for (int column = 0; column < COLUMNS; column++) {
                 jeu[row][column] = EMPTY;
             }
         }
    }


    /**
     * Play a piece in column j for the given player.
     * @param j the column index
     * @param player the player (X or O)
     * @throws IllegalArgumentException if j is not a valid column index or if the column is full or if the player is not X or O
     */
    public void play(int j, char player)throws IllegalArgumentException {
        if(j<0 || j >= COLUMNS || jeu[0][j] == ('X') || jeu[0][j] == 'O'|| (player !='X' && player !='O')){
            throw new IllegalArgumentException();
        }
        for (int i = ROWS - 1; i >= 0; i--) {
            if (jeu[i][j] == EMPTY) {
                jeu[i][j] = player;
                break;
            }
        }
    }



    /**
     * Returns true if the player has won the game.
     * @param player the player (X or O)
     * @return true if the player has won the game
     * @throws IllegalArgumentException if the player is not X or O
     */
    public boolean hasWon(char player) throws IllegalArgumentException {
         if(player !='X' && player !='O'){
             throw new IllegalArgumentException();
         }
         // ligne
        for (int i = 0 ; i < ROWS ; i++) {
            int sum = 0;
            for (int j = 0 ; j < COLUMNS ; j++) {

                if (jeu[i][j] == player) {
                    sum++;
                }else{
                    sum = 0;
                }
                if(sum == 4){
                    return true;
            }

            }
        }

        // col
        for (int i = 0 ; i < COLUMNS ; i++) {
            int sum = 0;
            for (int j = 0 ; j < ROWS ; j++) {

                if (jeu[j][i] == player) {
                    sum++;
                }else{
                    sum = 0;
                }
                if(sum == 4){
                    return true;
                }

            }
        }
        // diag montante
        for (int r = ROWS - 1; r >= 3; r--) {
            for (int c = 0; c < COLUMNS - 3; c++) {
                if (jeu[r][c] == player &&
                        jeu[r - 1][c + 1] == player &&
                        jeu[r - 2][c + 2] == player &&
                        jeu[r - 3][c + 3] == player) {
                    return true;
                }
            }
        }

        // diag descendante
        for (int r = 0; r < ROWS - 3; r++) {
            for (int c = 0; c < COLUMNS - 3; c++) {
                if (jeu[r][c] == player &&
                        jeu[r + 1][c + 1] == player &&
                        jeu[r + 2][c + 2] == player &&
                        jeu[r + 3][c + 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }
}
