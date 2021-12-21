package multithread;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义一个容器，提供add和size方法
 * 两个线程，一个线程给容器添加10个元素，在添加第5个元素时，另一个线程打印出容器size
 *
 */
public class Container01{
    private static MyContainer<Integer> container;
    private static final Object obj = new Object();

    public static void main(String [] args){
        MyContainer<Integer> container = new MyContainer<Integer>();
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    for(int i=0; i<10; i++){
                        if(i==5){
                            obj.notifyAll();
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        container.add(i);
                        System.out.println("add element " + i);
                    }
                    obj.notifyAll();
                }
            }
        };

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    if (container.size() == 5) {
                        System.out.println("get container size " + container.size());
                        obj.notifyAll();
                    }
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class MyContainer <T>{
        private List<T> list;

        MyContainer(){
            list = new ArrayList<T>();
        }

        public synchronized void add(T t){
            list.add(t);
        }

        public synchronized int size(){
            return list.size();
        }
    }
}