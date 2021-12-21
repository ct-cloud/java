package multithread;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class WriteData01 {

    private static volatile int times = 0;

    public static void main(String [] args){
        List<File> files = new ArrayList<File>();
        for(int i = 1; i < 5; i++){
            File file1 = new File("file" + i);
            files.add(file1);
        }
        CyclicBarrier barrier = new CyclicBarrier(4, ()->{
            Collections.rotate(files, 1);
            times++;
        });
        new Thread(new FileRunable('A',0, files, barrier)).start();
        new Thread(new FileRunable('B',1, files, barrier)).start();
        new Thread(new FileRunable('C', 2, files, barrier)).start();
        new Thread(new FileRunable('D',3, files, barrier)).start();
    }


    static class FileRunable implements Runnable {
        private char c;

        private int num;

        private List<File> files;

        private CyclicBarrier barrier;

        public FileRunable(char c, int num, List<File> files, CyclicBarrier barrier) {
            this.c = c;
            this.num = num;
            this.files = files;
            this.barrier = barrier;
        }

        @Override
        public void run() {

            while (times < 20) {
                try {
                    // 向文件写入数值
                    Writer writer = new PrintWriter(new FileWriter(files.get(num), true), true);
                    writer.write(c);
                    // 等待其它线程完成此轮工作
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                    try {
//                        writer.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
            }

        }
    }
}
