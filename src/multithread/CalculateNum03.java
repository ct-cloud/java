package multithread;

/**
 * CountDownLatch
 */

import java.util.concurrent.CountDownLatch;

public class CalculateNum03 {

    private static int THREAD_NUM = 5;
    private static int CAL_NUM = 10000;
    private static CountDownLatch latch = new CountDownLatch(5);
    private static volatile int sum = 0;
    private static final Object obj = new Object();

    public static void main(String [] args){
        for(int i=0; i<THREAD_NUM; i++) {
            int low = CAL_NUM / THREAD_NUM * i + 1;
            int high = CAL_NUM / THREAD_NUM * (i + 1);
            CalThread t = new CalThread(low, high);
            t.start();
        }

        try {
            Thread.sleep(100);
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("the result is " + sum + "," + System.currentTimeMillis());
    }

    static class CalThread extends Thread{
        private int low ;
        private int high;
        private int localSum;
        CalThread (int low, int high){
            this.low = low;
            this.high = high;
        }

        @Override
        public void run(){
             for(int i=low; i<=high; i++){
                 localSum += i;
             }
             synchronized (obj){
                 sum += localSum;
             }
            latch.countDown();
            System.out.println("Thread " + Thread.currentThread().getName() + " with result " + sum + ", " + System.currentTimeMillis());
        }
    }

}
