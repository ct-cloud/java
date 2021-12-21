package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoTask implements Runnable {

    // 主线程要等待线程打印完毕，使用CountDownLatch通知机制
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static List<ExecutorService> threadList = new ArrayList<>();
    private static final int MAX = 1024;
    private static int current = 1;

    @Override
    public void run() {
        if (current <= MAX) {
            System.out.println("Thread " + Thread.currentThread().getName() + " print " + current++);
            threadList.get(current % threadList.size()).submit(new DemoTask());
        } else {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            threadList.add(Executors.newFixedThreadPool(1));
        }

        threadList.get(0).submit(new DemoTask());
        countDownLatch.await();
        threadList.forEach(ExecutorService::shutdown);
    }
}