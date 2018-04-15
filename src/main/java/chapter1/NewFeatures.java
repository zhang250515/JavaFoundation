package chapter1;

import org.junit.Test;

import java.util.*;

/**
 * Created by ZhangQ on 2017/10/25.
 */
public class NewFeatures {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(str);
    }
    @Test
    public void strJoin(){
        String s = String.join("===","a","b","c");
        System.out.println(s);
    }

    @Test
    public void retain(){
        //取交集 去掉不一样的元素
        List<Integer> listA = new LinkedList<>();
        List<Integer> listB = new LinkedList<>();
        System.out.println(listA.retainAll(listB));
        listA.add(1);
        listB.add(1);
        System.out.println(listA.retainAll(listB));
        listA.add(2);
        System.out.println(listA.retainAll(listB));
        System.out.println(listA);
        System.out.println(listA.equals(listB));
        listA.add(2);
        System.out.println(listA.hashCode());
        System.out.println(listB.hashCode());
        ListIterator<Integer> iterator = listA.listIterator();
        iterator.forEachRemaining(System.out::println);
    }

    @Test
    public void testSig(){
        System.out.println(8 >> 2);
    }

    @Test
    public void qqRobot(){
       String str = "  10.26餐费：12  ";
       str = str.trim();
       String str1 = "10.26餐费:12";
       String[] a = str.split("餐费");
       System.out.println(a[0]);
       System.out.println(a[1].substring(1));
    }
}
