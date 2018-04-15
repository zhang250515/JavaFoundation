package Coding;

import dataStructure.ListNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by ZhangQ on 2017/11/2.
 */
public class Day06 {
    @Test
    public void testRandom(){
        System.out.println((int)(Math.random()*50+50));
        String s = new String("aaa");
        hello(s);
        System.out.println(s);
    }

    @Test
    public void testListNode(){


    }

    public void hello(String a){
        a.replaceAll("a","d");
    }

    //找到链表的倒数第k个节点
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null) return head;
        ListNode p = head;
        int length = 0;
        while (p.next != null){
            length++;
            p = p.next;
        }
        p = head;
        int index = length-k+1;
        if(index < 0) return null;
        while (index>0){
            p = p.next;
            index--;
        }
        return p;
    }

}
