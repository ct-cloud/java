package multithread;

/**
 * 两个线程，线程1打印10次，然后线程2打印100次，再线程1打印10次，线程2打印100次，如此循环50次
 */
public class CicularThread01 {
    private static final Object obj = new Object();
    private static final int MAX_TIMES = 50;
    private static volatile int times = 0;

    public static void main(String [] args){
        Runnable r1 = new Runnable(){
            @Override
            public void run(){
                synchronized (obj){
                    while(times < MAX_TIMES) {
                        System.out.println("***** the " + times + " times *****");
                        for (int i = 0; i < 10; i++) {
                            System.out.println("Thread " + Thread.currentThread().getName() + " print num " + i);
                        }
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    obj.notify();
                }


            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    while(times < MAX_TIMES) {
                        System.out.println("***** the " + times + " times *****");
                        for (int i = 0; i < 100; i++) {
                            System.out.println("Thread " + Thread.currentThread().getName() + " print num " + i);
                        }
                        times++;
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    obj.notify();
                }
            }
        };
        new Thread(r1, "t1").start();
        new Thread(r2, "t2").start();
    }
}
