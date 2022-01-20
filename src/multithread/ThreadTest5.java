package multithread;

import java.security.MessageDigest;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 练题1:编写程序实现,子线程循环3次,接着主线程循环5次,接着再子线程循环3次,主线程循环5次,如此反复,循环3次.
 *
 * 练习题2:设计四个线程,其中两个线程每次对变量i加1,另外两个线程每次对i减1.
 *
 * 练习题3:自己编写代码,实现生产者-消费者模型功能.内容自由发挥,只需要表达思想.
 *
 * 练习题4：现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 */
public class ThreadTest5 {
    private static final Lock lock = new ReentrantLock();
    private static Condition full = lock.newCondition();
    private static volatile boolean stop = false;

    public static void main(String [] args){
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (!stop) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println(Thread.currentThread().getName() + " " + i);
                        }
                        full.signal();
                        try {
                            full.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }catch(Exception e){
                   e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };
        new Thread(t1).start();
        try{
            lock.lock();
            while(!stop){
                try {
                    full.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                for(int i=0; i<2; i++){
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
                full.signal();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
