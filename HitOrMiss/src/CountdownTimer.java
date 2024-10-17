import java.util.Timer;
import java.util.TimerTask;
//class
public class CountdownTimer {
    //declare the interval i and timer t
    static int i;
    static Timer t;
    int sec = 30;


    //start timer
    public void startTimer() {
//set delay and period as 1000
        int del = 1000;
        int per = 1000;
        t = new Timer();
        i = sec;
        System.out.println(sec);
//performs the specified task at certain intervals
        t.scheduleAtFixedRate(new TimerTask()
        {
            //task to be performed
            public void run()
            {
                System.out.println(seti());
            }
        }, del, per);
    }
    //set interval
    private static final int seti() {
//if interval is 1, cancel
        if (i == 1){
            t.cancel();
        }
        return --i;
    }
}
