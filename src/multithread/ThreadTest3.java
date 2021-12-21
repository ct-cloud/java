package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest3 {
    private static volatile boolean stop = false;
    private static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main (String [] args){
        countDownLatch.countDown();
        Runnable r = new Runnable() {
            @Override
            public void run(){
                System.out.println("This is in run method...");
            }
        };
        FutureTask futureTask = new FutureTask(r, stop);
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
