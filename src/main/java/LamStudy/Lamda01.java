package LamStudy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ZhangQ on 2017/9/29.
 */
public class Lamda01 {

    @Test
    public void test01(){
        ArrayList<String> names = new ArrayList<>();
        names.add("abc");
        names.add("def");
        LinkedList<User> users = new LinkedList<>();
        names.forEach(n -> users.add(new User(n)));
        users.forEach(u -> System.out.println(u.getName()));
        users.forEach(System.out::println);
    }

    public void repeat(int n, Runnable action){
        for (int i=0;i<n;i++) action.run();
    }

    public void repeat(int n, IntConsumer consumer){
        for(int i=0;i<n;i++) consumer.accept(i);
    }

    //重复一个动作n次
    @Test
    public void test02(){
        List<User> users = new LinkedList<>();
        users.add(new User());
        repeat(2,()-> System.out.println("go"));
        repeat(2,()->System.out.println(users.hashCode()));
        //动作第几次执行

        //repeat(2,a -> System.out.println("consumer"+(a+1)));
    }

}
