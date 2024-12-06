// this class acts as a function for printing the board

public class printFrame {

    // method that prints the frame from the input 2D frame array
    public void printFrame(char[][] frame){

        // for loop that updates each row. this is written first to change rows after the columns are done
        for (int row = 0; row < frame.length; row++){

            // for loop that adds the value for each column per row. this is nested so that once the columns
            // are complete, the row can be update
            for (int col = 0; col < frame[0].length; col++){

                // prints each value in the array, starting with the first row
                System.out.print(frame[row][col]);
            }
            // formats the loop so the next row is on a new line, giving proper matrox format
            System.out.println();
        }
    }
}
