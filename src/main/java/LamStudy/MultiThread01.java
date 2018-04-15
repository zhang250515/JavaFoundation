package LamStudy;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Predicate;

/**
 * Created by ZhangQ on 2018/3/8.
 */
public class MultiThread01 {

    @Test
    public void testThread01() {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(i+" thread1");
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(i+" thread2");
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(i+" thread3");
            }
        }).start();


    }

    @Test
    public void testCall() throws Exception{
        FutureTask<String> task = new FutureTask<>(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("call01");
                Thread.sleep(50);
            }
            return "ok";
        });

        FutureTask<String> task01 = new FutureTask<>(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("call02");
                Thread.sleep(100);
            }
            return "ok";
        });
        ExecutorService threadPool = Executors.newCachedThreadPool();
        /*threadPool.execute(task);
        threadPool.execute(task01);*/
        threadPool.submit(task);
        threadPool.submit(task01);
        System.out.println(task.isDone());
        System.out.println(task.get());
        threadPool.shutdown();
    }

    @Test
    public void test02(){
        Thread t = new Thread(()->{
            System.out.println("protect thread");
        });

        t.setDaemon(true);
        t.start();

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.removeIf(a->(a<2));
        System.out.println(list);
    }
}
