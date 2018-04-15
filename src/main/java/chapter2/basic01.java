package chapter2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhangQ on 2018/2/28.
 */
public class basic01 {
    @Test
    public void test01(){
        String a = "hello";
        change(a);
        System.out.println(a);
        Integer b = 1000000;
        changeInt(b);
        System.out.println(b);
    }

    public void change(String a){
        a = "world";
    }
    public void changeInt(Integer a){
        a = 3;
    }

    public static void main(String[] args) {
        class A{
            public int i = 3;
        }
        Object o = (Object) new A();
        A a = (A)o;
        System.out.println(a.i);
    }

    @Test
    public void test02(){
        boolean a;
        a = 1 > 2 | true;
        System.out.println(a);
    }
}
