import java.util.concurrent.ThreadLocalRandom;

public class Pi_Calc implements Runnable{

    int hits = 0;
    int misses = 0;

    int iterations;

    public Pi_Calc(int it) {
        this.iterations = it;
    }

    @Override
    public void run() {

        for (int i = 0; i < iterations; i++) {
            if ((Math.pow(getRandom(), 2) + Math.pow(getRandom(), 2)) <= 1) {
                hits++;
            } else {
                misses++;
            }
        }

        long pi = ((hits/iterations)*4);
        Main.addResult(pi);
    }


    public long getRandom() {
        return (ThreadLocalRandom.current().nextLong(1));
    }


}
