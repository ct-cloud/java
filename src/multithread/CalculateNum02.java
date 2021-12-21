package multithread;

/**
 * 线程共享变量方式
 */
public class CalculateNum02 {
    private static final int THRED_NUM = 5;
    private static final int CAL_NUM = 10000;
    private static volatile int sum = 0;
    private static final Object obj = new Object();

    public static void main(String [] args){
        Thread [] threads = new Thread[THRED_NUM];
        for(int i=0; i<THRED_NUM; i++){
            int low = CAL_NUM/THRED_NUM * i + 1;
            int high = CAL_NUM/THRED_NUM * (i+1);
            threads[i] = new CalThread(low, high);
        }

        for(int i=0; i<THRED_NUM; i++){
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the result is " + sum);
    }

    static class CalThread extends Thread{
        private int low = 0;
        private int high = 0;

        CalThread(int low, int high){
            this.low = low;
            this.high = high;
        }

        @Override
        public void run() {
            synchronized (obj) {
                for (int i = low; i <= high; i++) {
                    sum += i;
                }
            }
        }
    }
}
