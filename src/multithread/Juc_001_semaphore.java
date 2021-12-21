package multithread;

import sun.awt.windows.ThemeReader;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Juc_001_semaphore {

    static class Synchronize_container <T>{
        private List list = new LinkedList<T>();
        public void put(T t){
            list.add(t);
        }

        public int size(){
            return list.size();
        }
    }

    public static void main(String [] args){
        Synchronize_container container = new Synchronize_container<Integer>();
        new Thread(()->{
            System.out.println("t1启动");
            for(int i = 0; i < 10; i++){
                System.out.println(i);
                container.put(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            System.out.println("t2 启动");
            if(container.size() == 5){
                System.out.println("t2 终止");
            }
        }).start();


    }
}
