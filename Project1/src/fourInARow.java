// Drew Miccoli
// 3/24/2022
// I have neither given nor received unauthorized aid on this program
// fourInARow is a program that runs like the game connect 4, but on a 4x4 grid
/*inputs: the user will be asked for two names for the two players. once the game
* has started, the user will be asked for a location, ranging
 *
* */
import java.util.Scanner;

public class fourInARow {
    public static void main(String[] args) {

        // introduction message
        System.out.println("welcome to four in a row. this is a game in which \n"
                + "the goal is to get four of your color in a row. Each player takes turns \n"
                + "dropping their color in the board. the first player to get four of their \n"
                + "color in a row wins! good luck!");

        // Sets the name for the first player
        System.out.print("Player 1: ");
        Scanner name1 = new Scanner(System.in);
        String player1 = name1.nextLine();
        System.out.println("Player 1: " + player1 + ", you are Red");

        // Sets the name for the second player
        System.out.print("Player 2: ");
        Scanner name2 = new Scanner(System.in);
        String player2 = name2.nextLine();
        System.out.println("Player 2: " + player2 + ", You are Blue");

        //Initializes the array
        char[][] frame = new char[4][4];
        for (int row = 0; row < frame.length; row++) {
            for (int col = 0; col < frame[0].length; col++) {
                frame[row][col] = '-';
            }
        }

        // initializing number of turns and max terms
        int turn = 1;
        final int maxTurns = 16;


        // overview of how values are input and what the board looks like
        System.out.println("Chips are dropped based on the column. Inputs for columns 1,2,3,4\n" +
                " are 0,1,2,3. below is a diagram that illustrates the input values and the\n" +
                " columns that each value represents: \n" +
                "0123 \n" +
                "---- \n" +
                "----\n" +
                "----\n" +
                "----");


       /* setting up for each player to take turns, conditions that turns is less than the max
        possible number of turns (16) */

        while (turn <= maxTurns) {

            /* the use of the modulo operator is to determine which player goes. player 1 goes on
             odd turns, while player 2 goes on even turns. if n mod 2 is 1, then n is odd and it is
             player 1's turn. if n mod 2 = 0, then n is even, and it is player 2's turn */

            /* row numbers are not needed, the user input is only column numbers because each move
            * automatically goes to the lowest possible row. this is accounted for in both move methods
            * within the MoveRed and MoveBlue classes */

            // player 1
            if (turn % 2 == 1) {

                // user input for player 1 to make a turn
                System.out.print(player1 + ", Please make your move: ");
                Scanner move = new Scanner(System.in);
                int play = move.nextInt();

                // calling move method (see moveRed.java)
                MoveRed redMove = new MoveRed();
                redMove.move(play, frame);

                // determines if the move is valid, the count will go up. if not, player 1 must try a
                // new move
                if (redMove.getValid()) {
                    turn++;
                } else {
                    System.out.println("Error: that is not a valid move " + player1 +
                            ", try again");
                }

                // printing the board after player 1's turn
                printFrame display = new printFrame();
                display.printFrame(frame);

                // checks to see if player 1 has won or not (see redWinner class)
                if (redWinner.checkWinner(frame)) {
                    System.out.println(player1 + " wins!");
                    break;
                }
            }

            // player 2
            if (turn % 2 == 0) {

                // prompt for player 2 to make a move
                System.out.print(player2 + ", Please make your move: ");
                Scanner move = new Scanner(System.in);
                int play = move.nextInt();

                // calling the move method (see MoveBlue.java)
                MoveBlue blueMove = new MoveBlue();
                blueMove.move(play, frame);

                // determines if the move is valid. if it is, the count will go up. if not, player 2
                // must try a new move
                if (blueMove.getValid()) {
                    turn++;
                } else {
                    System.out.println("Error: that is not a valid move " + player2 +
                            ", try again");
                }

                // printing the board after player 2's move
                printFrame display = new printFrame();
                display.printFrame(frame);

                // method that checks if player 2 has won (see blueWinner class)
                if (blueWinner.checkWinner(frame)){
                    System.out.println(player2 + " wins!");
                    break;
                }
            }
        }

        // if nobody wins/turns run out
        if (!redWinner.checkWinner(frame) && !blueWinner.checkWinner(frame)) {
            System.out.println("There is no winner");
        }
    }
}