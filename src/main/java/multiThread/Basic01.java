package multiThread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by ZhangQ on 2018/5/21.
 */
public class Basic01 implements Runnable{

    private int count = 10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread()+"Thread---"+count);
    }

    public static void main(String[] args) {
        Basic01 b = new Basic01();
        for (int i = 0; i < 5; i++) {
            new Thread(b, "Thread"+i).start();
        }
    }

    @Test
    public void test01(){
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                count--;
                System.out.println(Thread.currentThread() + "Thread---" + count);
            }).start();
        }
    }

}
