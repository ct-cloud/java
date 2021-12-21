package multithread;

import java.util.stream.StreamSupport;

/**
 * 两个线程交替打印奇数，偶数
 */
public class InterPrint01 {
//    private static volatile int num;
//    private static final Object obj = new Object();
//
//    static class MyRunable implements Runnable{
//        @Override
//        public void run() {
//            synchronized (obj) {
//                while(true) {
//                    System.out.println("Thread " + Thread.currentThread().getName() + " print " + num++);
//                    obj.notify();
//                    try {
//                        obj.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//
//    public static void main(String [] args){
//        new Thread(new MyRunable(), "奇数").start();
//        new Thread(new MyRunable(), "偶数").start();
//    }


//    private static Integer count = 0;
//    private static final Object lock = new Object() ;
//
//
//    static class WaitNotify implements Runnable{
//
//        @Override
//        public void run() {
//            while (count<=100){
//                synchronized (lock){
//                    System.out.println(Thread.currentThread().getName()+"打印出"+(count++));
//                    lock.notify();
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread(new WaitNotify(),"偶数");
//        thread1.start();
//        Thread.sleep(10);
//        Thread thread2 = new Thread(new WaitNotify(),"奇数");
//        thread2.start();
//
//    }
//
//
//}



    private static Integer count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        /**
         * 利用synchronized通信实现线程的交替
         */
        new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + "打印出" + (count++));
                    }
                }
            }
        }, "偶数").start();

        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + "打印出" + (count++));
                    }
                }
            }
        }, "奇数").start();
    }
}

