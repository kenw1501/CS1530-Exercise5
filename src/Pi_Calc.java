import java.util.concurrent.ThreadLocalRandom;

public class Pi_Calc implements Runnable{

    long hits = 0;
    long misses = 0;

    long iterations;

    public Pi_Calc(long it) {
        this.iterations = it;
    }

    @Override
    public void run() {

        for (int i = 0; i < iterations; i++) {
            Double x = getRandom();
            Double y = getRandom();
            if ((Math.pow(x, 2) + Math.pow(y, 2)) <= 1.0) {
                hits++;
            } else {
                misses++;
            }
        }

        double pi = ((hits*1.0)/iterations)*4.0;
        Main.addResult(pi);
    }


    public Double getRandom() {
        return (ThreadLocalRandom.current().nextDouble(1));
    }


}
