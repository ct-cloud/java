package multithread;

import java.util.ArrayList;
import java.util.List;

public class Container02 {
    public static void main(String [] args){
        MyContainer<Integer> myContainer = new MyContainer<>();
        final Object obj = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    for (int i = 0; i < 100; i++) {
                        myContainer.add(i);
                        System.out.println("add element " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        obj.notifyAll();
                        System.out.println("Thread " + Thread.currentThread().getName() + "into wait");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    for(int i=0; i<100; i++){
                        System.out.println("container size is " + myContainer.size());

                        obj.notifyAll();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyContainer<T>{
        private List<T> userDefinedContainer;

        MyContainer(){
            userDefinedContainer = new ArrayList<T>();
        }

        public synchronized void add(T t){
            userDefinedContainer.add(t);
        }

        public synchronized int size(){
            return userDefinedContainer.size();
        }
    }

}


