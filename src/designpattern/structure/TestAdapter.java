package designpattern.structure;

import java.util.concurrent.Callable;

//适配器模式
public class TestAdapter {
    public static void main(String[] args){
        new Thread(new Badapter(new B())).start();
    }
}



class Badapter implements Runnable{
    private B b;
    Badapter(B b){
        this.b = b;
    }

    public void run() {
        try {
            b.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class B implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("this is in call method");
        return "done";
    }
}
