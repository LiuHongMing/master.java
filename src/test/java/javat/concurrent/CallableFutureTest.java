package javat.concurrent;

import java.util.concurrent.*;

public class CallableFutureTest {

    static class ResultInfo {
        @Override
        public String toString() {
            return "This is result info";
        }
    }

    static class Runner<V> implements Runnable {

        private Future<V> future;

        public Runner(Future future) {
            this.future = future;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "," + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(5);

        Callable<ResultInfo> resultCall = new Callable<ResultInfo>() {
            @Override
            public ResultInfo call() throws Exception {
                Thread.sleep(5000);
                return new ResultInfo();
            }
        };

        Runnable resultRun = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        final Future<ResultInfo> callFuture = exec.submit(resultCall);
        final Future<String> runFuture = exec.submit(resultRun, "This is return value");

        Runnable test = new Runner<ResultInfo>(callFuture);
        exec.submit(test);

        Runnable test2 = new Runner<ResultInfo>(runFuture);
        exec.submit(test2);

        exec.shutdown();
    }

}
