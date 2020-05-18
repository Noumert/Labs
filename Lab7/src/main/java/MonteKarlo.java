import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static java.lang.Math.random;

public class MonteKarlo {
    static final long MAX_POINT_NUMBER = 100_000_000_0L;
    static final double RADIUS = 1;
    static final long START_POINT_NUMBER = 10_000L;

    public void evaluatePI(int threads) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(threads);
        long currentPoints = START_POINT_NUMBER;
        while (currentPoints <= MAX_POINT_NUMBER) {
            long m = System.currentTimeMillis();
            long pointsInCircle = forkJoinPool.invoke(new ForkJoinCheck(currentPoints, threads));
            double pi = (double) pointsInCircle / currentPoints * 4;
            System.out.println(pointsInCircle+"/"+currentPoints);
            System.out.println("Pi is " + pi + "; Threads " + threads + "; Iterations " + currentPoints + "; Time " + (System.currentTimeMillis() - m) + "ms");
            currentPoints *= 2;
        }
    }

    public static class ForkJoinCheck extends RecursiveTask<Long> {
        long currentPoints;
        int numberOfThreads;

        ForkJoinCheck(long currentPoints, int numberOfThreads) {
            this.currentPoints = currentPoints;
            this.numberOfThreads = numberOfThreads;
        }

        @Override
        protected Long compute() {
            if (numberOfThreads > 1) {
                return ForkJoinTask.invokeAll(createSubtasks())
                        .stream()
                        .mapToLong(ForkJoinTask::join)
                        .sum();
            } else {
                return processing(currentPoints);
            }
        }

        private Long processing(long currentPoints) {
            long pointsInCircle = 0;
            for (int i = 0; i < currentPoints; i++) {
                double x = random() * RADIUS;
                double y = random() * RADIUS;
                if (vec(x, y) < RADIUS) {
                    pointsInCircle++;
                }
                i++;
            }
            System.out.println(currentPoints + "/" + pointsInCircle  + " in thread");
            return pointsInCircle*2;
        }

        double vec(double x, double y) {
            return Math.pow((x * x + y * y), 0.5);
        }

        private Collection<ForkJoinCheck> createSubtasks() {
            List<ForkJoinCheck> dividedTasks = new ArrayList<>();
            dividedTasks.add(new ForkJoinCheck(currentPoints/2, numberOfThreads/2));
            dividedTasks.add(new ForkJoinCheck(currentPoints - currentPoints/2, numberOfThreads - numberOfThreads/2));
            return dividedTasks;
        }

    }

}

