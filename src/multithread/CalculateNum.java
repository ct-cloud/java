package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ExecutorService
 */
public class CalculateNum {
    private static final int THREAD_NUM = 5;
    private static final int CAL_NUM = 10000;
    private static int res = 0;

    public static void main(String [] args){
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(20));
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for(int i = 0; i < THREAD_NUM; i++) {
            int low = CAL_NUM / THREAD_NUM * i + 1;
            int high = CAL_NUM / THREAD_NUM * (i + 1);
            MyCall r = new MyCall(low, high);
            list.add(executorService.submit(r));
        }
        for(int i=0; i<THREAD_NUM;i++) {
            Future<Integer> future = list.get(i);
            try {
                int sumOfSubThread = future.get();
                res += sumOfSubThread;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
            System.out.println(res);
            executorService.shutdown();

    }

    static class MyCall implements Callable<Integer> {
        private int low;
        private int high;
        private int sum;

        MyCall(int low, int high){
            this.low = low;
            this.high = high;
        }

        @Override
        public Integer call(){
            for(int i=low; i<=high; i++){
                sum += i;
            }
            return sum;
        }
    }
}
