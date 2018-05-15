package onlineCoding;

import dataStructure.ListNode;
import dataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


/**
 * Created by ZhangQ on 2017/12/20.
 */
public class day02 {
    public ListNode ReverseList(ListNode head) {
        Stack<Integer> temp = new Stack<>();
        ListNode h = head;
        while (h != null){
            temp.push(h.val);
            h = h.next;
        }
        h = head;
        while (!temp.empty() && head != null){
            head.val = temp.pop();
            head = head.next;
        }
        return h;
    }


    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null ) return list2;
        if (list2 == null) return list1;
        ListNode head = null;
        ListNode p = null;
            while (list1 != null && list2 != null){
                if(list1.val <= list2.val){
                    if (head == null){
                        p = list1;
                        head = p;
                    }else {
                        p.next = list1;
                        p = p.next;
                    }
                    list1 = list1.next;
                }else{
                    if (head == null){
                        p = list2;
                        head = p;
                    }else {
                        p.next = list2;
                        p = p.next;
                    }
                    list2 = list2.next;
                }
            }
            if (list1 == null){
                p.next = list2;
            }else {
                p.next = list1;
            }
        return head;
    }

    @Test
    public void testR(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        /*ListNode head = Merge(node1,node3);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }*/
        ListNode p,q;
        p = node1;
        q = p;
        p.next = node3;
        while (q != null){
            System.out.println(q.val);
            q = q.next;
        }

        int[] a = {};
        Arrays.sort(a);
        ArrayList list = new ArrayList(10);
    }
}
