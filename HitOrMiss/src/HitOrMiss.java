import java.util.Random;

public class HitOrMiss {
    public String HitOrMiss() {
        Random random = new Random();
        String response;
        int n = random.nextInt(6) + 1;
        if (n % 2 == 0 && n != 6) {
            response = "Miss";
            return response;
        } else if (n % 2 == 1) {
            response = "Hit";
            return response;
        } else {
            response = "You Choose";
            return response;
        }
    }
}
