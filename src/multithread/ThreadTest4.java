package multithread;

//实现两个线程交替打印
//子线程打印3次，主线程再打印5次，接着子线程打印3次，主线程打印5次，如此重复3轮
public class ThreadTest4 {
    private static final Object obj = new Object();
    private volatile static int times = 3;
    public static void main(String [] args){
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    while(times>0) {
                        int i = 3;
                        while (i > 0) {
                            System.out.println("in thread sub " + i);
                            i--;
                        }
                        obj.notify();
                        try {
                            obj.wait();
                            i = 3;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        new Thread(t1).start();
        synchronized (obj) {
            while(times >0) {
                int i = 0;
                try {
                    obj.wait();
                    times--;
                    i = 5;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (i > 0) {
                    System.out.println("in thread main " + i);
                    i--;
                }
                obj.notify();

            }
        }
    }

}
