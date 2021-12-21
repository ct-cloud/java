package multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterPrint02 {
    private static Lock lock = new ReentrantLock();
    private static volatile int num = 0;

    public static void main(String [] args){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while(num < 100){
                    try {
                        lock.lock();
                        if((num & 1) == 0){
                            System.out.println("Thread " + Thread.currentThread().getName() + " print " + num++);
                        }
                    }finally {
                        lock.unlock();
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while(num < 100) {
                    try {
                        lock.lock();
                        if ((num & 1) == 1) {
                            System.out.println("Thread " + Thread.currentThread().getName() + " print " + num++);
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        new Thread(r1, "odd").start();
        new Thread(r2, "even").start();
    }


}
