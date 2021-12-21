package multithread;

import java.util.concurrent.*;

public class ThreadTest1 {

    public static void main(String [] args) {
        Callable c = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                throw new RuntimeException("exception happened");
            }
        };
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Future<Integer> future = executor.submit(c);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
