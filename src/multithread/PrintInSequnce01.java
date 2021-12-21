package multithread;

/**
 * 3个线程交替打印1-100
 */
public class PrintInSequnce01 implements Runnable{
    private static final Object obj = new Object();
    private static final int N = 3;
    private static volatile int num = 0;

    private int index;

    PrintInSequnce01(int index){
        this.index = index;
    }

    @Override
    public void run(){
        synchronized (obj){
            while(num < 100){
                if(num % N == index) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " print " + num++);
                    obj.notifyAll();
                }
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.exit(0);
        }
    }

    public static void main(String [] args){

        new Thread(new PrintInSequnce01(0), "t1").start();
        new Thread(new PrintInSequnce01(1), "t2").start();
        new Thread(new PrintInSequnce01(2), "t3").start();

    }
}
