package multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest2 {
    private static int res = 5;

    public static void main(String [] args) {
        Callable t = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return res;
            }
        };
        FutureTask futureTask = new FutureTask(t);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
