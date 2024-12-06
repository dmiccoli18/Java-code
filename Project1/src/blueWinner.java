// this class checks to see if the blue player has won the game
public class blueWinner {

    // initializing an object to the same char as the blue player
    static char p2Color = 'B';

    // main method to check if player 2 wins
    public static boolean checkWinner(char[][] frame){

        // four across
        // each column value is checked if it contains 'B'. if not, the row updates
        for (int row = frame.length - 1; row >= 0; row--) {
            if (frame[row][0] == p2Color &&
                    frame[row][1] == p2Color &&
                    frame[row][2] == p2Color &&
                    frame[row][3] == p2Color) {
                    return true;
            }
        }

        // four down
        // each row value is checked if it contains 'B'. if not, the column updates
        for (int col = frame.length - 1; col >= 0; col--){
                if (frame[0][col] == p2Color &&
                        frame[1][col] == p2Color &&
                        frame[2][col] == p2Color &&
                        frame[3][col] == p2Color) {
                    return true;
                }
            }

        // left to right downward/right to left upward diagonal
        // indices corresponding to diagonal values are checked for 'B'. There is only one possibility
        // for this diagonal, so no values need to be updated
        if (frame[0][0] == p2Color &&
                frame[1][1] == p2Color &&
                frame[2][2] == p2Color &&
                frame[3][3] == p2Color) {
            return true;
                }

        // left to right upward/right to left downward diagonal
        // indices corresponding to diagonal values are checked for 'B'. There is only one possibility
        // for this diagonal, so no values need to be updated
        if (frame[0][3] == p2Color &&
                frame[1][2] == p2Color &&
                frame[2][1] == p2Color &&
                frame[3][0] == p2Color) {
                    return true;
                }

        // if none of these values return true, then player 2 has not won
        return false;
    }
}
