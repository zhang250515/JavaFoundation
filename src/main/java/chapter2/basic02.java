package chapter2;

import org.junit.Test;

import java.util.*;

/**
 * Created by ZhangQ on 2018/3/4.
 */
public class basic02 {
    public static void main(String[] args) {
        ((basic02)null).hello();
    }

    public static void hello(){
        System.out.println("hello");
    }

    @Test
    public void testBreak(){
        out:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                if(j>=2)
                    break out;
                System.out.println(j);
            }
        }
        System.out.println("break");
    }

    @Test
    public void test01(){
        System.out.println(1/5);
        System.out.println(1%5);
        Byte a = 120;
        System.out.println(a+"-------------");
        System.out.println(findA(""));

        int i = 0;
        i = i++;
        System.out.println(i);
        System.out.println(1.0/0.0);
    }

    public Character findA(String a){
        char[] c = a.toCharArray();
        if (c.length == 0)
            return ' ';
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (c[i] == c[j] && i != j) break;
                if (j == c.length-1) return c[i];
            }
        }
        return ' ';
    }

    @Test
    public void test02() throws Exception{
        String a = "abcde";
        System.out.println(a.charAt(4));
        int i = (a!=null)&&(a.length()>0)?a.length():0;
        System.out.println(i);
    }

    @Test
    public void testJVMInfo(){
        Runtime r = Runtime.getRuntime();
        System.out.println(r.availableProcessors());
        System.out.println(r.freeMemory());
        System.out.println(r.totalMemory());
        System.out.println(r.maxMemory());
    }

    @Test
    public void testHash(){
        HashMap<Integer,Integer> map = new HashMap<>();

    }

    @Test
    public void testHW(){
        int a = 34543;
        System.out.println(isHW(a));
    }

    private boolean isHW(int a){
        char value[] = Integer.valueOf(a).toString().toCharArray();
        LinkedList<Character> se = new LinkedList<>();
        for (char v : value)
            se.add(v);
        LinkedList<Character> nx = new LinkedList<>();
        nx.addAll(se);
        Collections.reverse(nx);
        return Objects.equals(se,nx);
    }
}
