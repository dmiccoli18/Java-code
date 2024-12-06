// this class checks to see if the red player has won the game
public class redWinner {

    // initializing an object to the same char as the red player
    static char p1Color = 'R';

    // main method to check if player 1 wins
    public static boolean checkWinner(char[][] frame) {

        // four across
        // each column value is checked if it contains 'R'. if not, the row updates
            for (int row = frame.length - 1; row >=0; row--) {
                if (frame[row][0] == p1Color &&
                        frame[row][1] == p1Color &&
                        frame[row][2] == p1Color &&
                        frame[row][3] == p1Color) {
                    return true;
                }
            }

        // four down
        // each row value is checked if it contains 'R'. if not, the column updates
            for (int col = frame.length - 1; col >=0; col--) {
                if (frame[0][col] == p1Color &&
                        frame[1][col] == p1Color &&
                        frame[2][col] == p1Color &&
                        frame[3][col] == p1Color) {
                    return true;
                }
            }

        // left to right downward/right to left upward diagonal
        // indices corresponding to diagonal values are checked for 'R'. There is only one possibility
        // for this diagonal, so no values need to be updated
            if (frame[0][0] == p1Color &&
                    frame[1][1] == p1Color &&
                    frame[2][2] == p1Color &&
                    frame[3][3] == p1Color) {
                return true;
            }
        // left to right upward/right to left downward diagonal
        // indices corresponding to diagonal values are checked for 'R'. There is only one possibility
        // for this diagonal, so no values need to be updated
            if (frame[0][3] == p1Color &&
                    frame[1][2] == p1Color &&
                    frame[2][1] == p1Color &&
                    frame[3][0] == p1Color) {
                return true;
            }

            // if none of these values return true, then player 1 has not won
            return false;
    }
}
