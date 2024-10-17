import java.util.Scanner;

public class mainGame {
    public static void main(String args[]) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Players: ");
        int numOfPlayers = sc.nextInt();

        int[] scores = new int[numOfPlayers];
        String[] names = new String[numOfPlayers];

        int n = 1;
        String name;
        while (n <= scores.length) {
            scores[n - 1] = 0;
            System.out.print("Player " + n + " Name: ");
            name = sc.next();
            names[n - 1] = name;
            n++;
        }

        // turn stuff
        int turn = 1;

        // main game loop starts here
        while (turn <= 2) {
            // prompt stuff
            Prompts prompt = new Prompts();
            String subject = prompt.Prompts();
            System.out.println(subject);

            System.out.print("Ready?: ");
            String ready = sc.next();

            if (ready == "y") {
                continue;
            }

            // time stuff here
            CountdownTimer newTimer = new CountdownTimer();
            newTimer.startTimer();


            // delaying next prompt
            long seconds = 30;
            Thread.sleep(seconds * 1000);

            int score;
            int m = 1;
            while (m <= numOfPlayers) {
                HitOrMiss prompts = new HitOrMiss();
                String result = prompts.HitOrMiss();
                System.out.println(names[m - 1] + ", " + result);
                System.out.print(names[m - 1] + ", score for this round: ");
                score = sc.nextInt();
                scores[m - 1] = scores[m - 1] + score;
                m++;
            }
            turn++;

            System.out.println("Final Scores: ");
            int r = 1;
            while (r <= numOfPlayers) {
                System.out.println(names[r - 1] + ": " + scores[r - 1]);
                r++;
            }
        }
    }
}
