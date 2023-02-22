import java.util.Random;

public class Pipes {
    
    int x = 700;
    int y = 0;

    Random random = new Random();

    int topLength;
    int bottomLength;
    int width = 30;

    int lengthVariance = random.nextInt(185, 225);

    public Pipes(){
        topLength = random.nextInt(70, 300);
        bottomLength = topLength + 100;
    }

}
