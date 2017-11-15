import java.util.ArrayList;

public class Main {

    static long NUM_THREADS;
    static long NUM_ITERATIONS;

    static double totalResults;

    public static void main(String[] args) throws InterruptedException {

        if (args.length == 0 || args.length > 2) {
            System.out.println("Invalid arguments supplied.");
            System.out.println("Arguments should be 1. Number of Threads, 2. Number of iterations");
        } else {
            try {
                NUM_THREADS = Long.valueOf(args[0]);
                NUM_ITERATIONS = Long.valueOf(args[1]);
            } catch (Exception e) {
                System.out.println("Invalid arguments supplied.");
                System.out.println("Arguments should be 1. Number of Threads, 2. Number of iterations");
            }
        }


        // create threads
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < NUM_THREADS; i++) {
            Runnable processor = new Pi_Calc((NUM_ITERATIONS/NUM_THREADS));
            Thread t = new Thread(processor);
            threads.add(t);
            t.start();
        }

        // join threads
        for (Thread t : threads) {
            t.join();
        }

        // print result
        System.out.println("Total is: " + totalResults);
        System.out.println("Num Threads is: " + NUM_THREADS);
        double actual = totalResults / NUM_THREADS;
        System.out.println("Actual Result: " + actual);


    }


    public synchronized static void addResult(double p) {
        System.out.println("Adding results " + p);
        totalResults += p;
    }
}
