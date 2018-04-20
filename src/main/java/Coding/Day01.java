package Coding;

import dataStructure.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * Created by ZhangQ on 2017/10/8.
 */
public class Day01 {

    @Test
    public void test01(){
        new Thread(()->{
            int i = 1;
            while (i<10)
                System.out.println("hello"+i++);
        },"hello").start();

        new Thread(()->{
            int i = 1;
            while (i<10)
                System.out.println("hi"+i++);
        },"hi").start();


    }

    @Test
    public void testThread() throws Exception{
        FutureTask<Integer> task = new FutureTask<>(()->{
            int sum = 0;
            for (int i = 0; i <= 100000; i++) {
                sum += i;
            }
            return sum;
        });
        new Thread(task).start();
        System.out.println(task.isCancelled());
        System.out.println(task.get());
        System.out.println(task.isDone());
    }

    //二维数组的查找
    public boolean Find(int target, int [][] array) {
        boolean f = false;
        for (int a[] : array){
            for (int b : a){
                if(b == target) f = true;
            }
        }
        return f;
    }

    //空格替换为 %20
    public String replaceSpace(StringBuffer str) {
        String a = str.toString();
        return a.replaceAll(" ","%20");
    }

    //倒序打印链表的节点
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> array = new ArrayList<>();
        if (listNode == null) return array;
        ListNode temp;

        array.add(listNode.val);
        while (listNode.next != null){
            temp = listNode.next;
            array.add(temp.val);
            listNode = temp;
        }
        Collections.reverse(array);
       return  array;
    }

    @Test
    public void test02(){
        List<Integer> list = new LinkedList<>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
        list.forEach(System.out::println);
    }
}
