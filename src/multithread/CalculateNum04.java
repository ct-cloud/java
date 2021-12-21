package multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CalculateNum04 {
    private static volatile int res = 0;
    private static CyclicBarrier barrier = new CyclicBarrier(5, ()-> System.out.println("the result is " + res));
    private static final Object obj = new Object();
    private static final int THREAD_NUM = 5;
    private static final int CAL_NUM = 10000;

    public static void main(String [] args){
        for(int i = 0; i < THREAD_NUM; i++){
            int low = CAL_NUM/THREAD_NUM * i + 1;
            int high = CAL_NUM/THREAD_NUM * (i + 1);
            Thread t = new CalThread(low, high);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class CalThread extends Thread{
        private int low;
        private int high;
        private int sum;

        CalThread(int low, int high){
            this.low = low;
            this.high = high;
        }

        @Override
        public void run(){
            for(int i = 0; i <= high; i++){
                sum += sum;
            }
            synchronized (obj){
                res += sum;
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
