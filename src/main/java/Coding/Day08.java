package Coding;

import LamStudy.User;
import dataStructure.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * Created by ZhangQ on 2017/12/6.
 */
public class Day08  {

    private List head;
    @Test
    public void testList(){
        LinkedHashSet l = new LinkedHashSet();
        l.add(1);

        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(1,3);
        System.out.println(a);
    }

    @Test
    public void testTree(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(6);
        set.add(5);
        set.add(3);
        System.out.println(set);
    }

    @Test
    public void testColl(){
        //视图
        Set s = Collections.singleton("abc");
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        Integer max = Collections.max(list);
        System.out.println(max);
    }

    @Test
    public void testCom(){
        List<User> list = new LinkedList<>();
        User u = new User("amy");
        list.add(u);
        list.add(new User("bob"));
        User user = Collections.max(list,Comparator.comparing(User::getName));
        System.out.println(user);
    }

    @Test
    public void testReverse(){
        Integer a = 150;
        Integer b = 150;
        System.out.println(a==b);
        Integer c = 100;
        Integer d = 100;
        System.out.println(c==d);
        System.out.println(a.equals(b));
        Integer e = Integer.valueOf(150);
        Integer f = Integer.valueOf(150);
        System.out.println(e==f);
        Set g = new HashSet();
        g.add(1);
        g.add(1);
    }


}
