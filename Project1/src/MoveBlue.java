// this class acts as the function for placing the blue player's chips

public class MoveBlue {

    // initializing the "valid" variable
    boolean valid;

    // main method that takes the user input "play" and board to check and allow moves
    public void move(int play, char[][] frame) {

        // checks out of bounds conditions for column numbers from user input "play"
        if (play > frame.length - 1 ) {
            valid = false;
            System.out.println("this move is not valid! try again.");
        } else {
            valid = true;
        }

        // initializing variable row to start on the bottom row of the board
        int row = frame.length - 1;

        // while loop that runs when only valid moves are entered
        while (valid == true) {

            // conditional statement that checks if locations are already taken within "play" column
            if (frame[row][play] != '-') {
                row--;

                // conditional that checks if a column is completely full
                if (row < 0){
                    valid = false;
                }
            }

            // else statement that only runs when a location is valid, returns with player 2's move
            else {
                frame[row][play] = 'B';
                break;
            }
        }
    }

    // method that returns variable valid. this determines whether a player must make a different
    // move or if their turn is up
    public boolean getValid() {
        return valid;
    }
}
