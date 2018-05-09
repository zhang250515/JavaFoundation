package algorithm;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by ZhangQ on 2018/5/8.
 * ArrayList
 * LinkedList
 * Stack
 * Queue
 */
public class Ch03 {

    @Test
    public void testAdd(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.listIterator().add(2);
        list.add(3);
        list.addFirst(5);
        list.forEach(System.out::println);
    }
}
