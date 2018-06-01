package chapter1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        while (list.size()<5)
            list.add(scanner.nextInt());
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void test1(){
        ArrayList<Integer> squ = new ArrayList<>();
        for(int i = 1;i <= 5; i++){
            squ.add(i*i);
        }
        squ.forEach(System.out::println);
    }

    @Test
    public void testReflect(){
        Integer c = 1;
        int a = 3,b = 5;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a+".."+b);
        System.out.println(3/7);
    }

    @Test
    public void testRegex(){
        int[] a = {1,2,3,4};
        int[] c = {};
        int[] d = sort1(a);
        for (int i : d){
            System.out.println(i);
        }
    }

    public int[] sort1(int[] a){
        if(a.length == 0){
            int[] c = {};
            return c;
        }
        int[] b = new int[a.length];
        int k = 0;
        for(int i : a){
            if(i%2 !=0){
                b[k] = i;
                k++;
            }
        }
        for (int j : a){
            if(j%2 == 0){
                b[k] = j;
                k++;
            }
        }
        return b;
    }

    @Test
    public void testStack(){
        Integer a = 2;
        System.out.println(a.intValue());
    }
}
